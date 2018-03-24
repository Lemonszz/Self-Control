import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


/**
 * Created by Sam on 25/03/2018.
 */
@Mod(modid = "selfcontrol", name="Self Control", version = "1.0.0")
@Mod.EventBusSubscriber(value = {Side.CLIENT})
public class SelfControl
{
	/*
			I used WorldTickEvent as a quick solution, this will likely be changed in the future to
			something like CommandEvent.
	 */

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onWorldTick(TickEvent.WorldTickEvent event)
	{
		if(event.world.provider.getDimension() != 0)
			return;

		if(Minecraft.getMinecraft().player == null || Minecraft.getMinecraft().player.isCreative())
			return;

		Minecraft.getMinecraft().getIntegratedServer().getPlayerList().setCommandsAllowedForAll(false);
		Minecraft.getMinecraft().player.setPermissionLevel(0);
	}
}
