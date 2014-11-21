package playertraits.traits;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SpeedTrait extends Trait {

	public SpeedTrait() {
		super("Speed");
	}

	@Override
	public void tick(EntityPlayerMP player) {
		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 200, 1));
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

}
