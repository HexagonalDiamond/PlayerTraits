package playertraits.traits;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class StrengthTrait extends Trait {

	public StrengthTrait() {
		super("Strength");
	}

	@Override
	public void tick(EntityPlayerMP player) {
		player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 200, 1));
	}

	@Override
	public void init() {
		
	}

}
