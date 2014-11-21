package playertraits.traits;

import net.minecraft.entity.player.EntityPlayerMP;

public abstract class Trait {
	String name;
	short id;
	public Trait(String name) {
		this.name = name;
	}
	
	public abstract void tick(EntityPlayerMP player);
	public abstract void init();
}
