package playertraits;

import org.apache.logging.log4j.Logger;

import playertraits.traits.SpeedTrait;
import playertraits.traits.StrengthTrait;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

@Mod(modid = PlayerTraits.MODID, version = PlayerTraits.VERSION)
public class PlayerTraits
{
    public static final String MODID = "playertraits";
    public static final String VERSION = "1.0";
    public static Logger log;
    public static TraitManager traitmanager;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	log = event.getModLog();
    	traitmanager = new TraitManager();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(this);
    	FMLCommonHandler.instance().bus().register(this);
    }
    @SubscribeEvent
    public void join(EntityJoinWorldEvent e) {
    	if(e.entity instanceof EntityPlayerMP) {
    		traitmanager.addPlayer((EntityPlayerMP) e.entity);
    	}
    }
    @SubscribeEvent
    public void chat(ServerChatEvent e) {
    	traitmanager.addTrait(e.player, new SpeedTrait());
    	traitmanager.addTrait(e.player, new StrengthTrait());
    }
    @SubscribeEvent
    public void onTick(PlayerTickEvent e) {
    	traitmanager.tick();
    }
    
}
