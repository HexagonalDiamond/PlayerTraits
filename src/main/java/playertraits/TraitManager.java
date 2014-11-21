package playertraits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import playertraits.traits.Trait;
import net.minecraft.entity.player.EntityPlayerMP;

public class TraitManager {
	HashMap<EntityPlayerMP,ArrayList<Trait>> traits;
	public TraitManager() {
		traits = new HashMap<EntityPlayerMP,ArrayList<Trait>>();
	}
	public void addPlayer(EntityPlayerMP p) {
		traits.put(p, new ArrayList());
	}
	public void resetPlayer(EntityPlayerMP p) {
		traits.remove(p);
	}
	public void addTrait(EntityPlayerMP p, Trait t) {
		traits.get(p).add(t);
	}
	public void removeTrait(EntityPlayerMP p, Trait t) {
		traits.get(p).remove(t);
	}
	public void tick() {
		for(Entry<EntityPlayerMP, ArrayList<Trait>> player : this.traits.entrySet()) {
			//TODO: implement better way to run every x seconds
			if(player.getKey().ticksExisted % 20 == 0) { //run every second player is alive
				for(Trait trait : player.getValue()) {
					trait.tick(player.getKey());
				}
			}
		}
	}
	//TODO: add load and save to NBT
}
