package net.kai_nulled.potioncore.client.screens;

import net.kai_nulled.potioncore.PotionCore;
import net.kai_nulled.potioncore.procedures.LoveVigDisplayOverlayIngameProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterGuiLayersEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = PotionCore.MODID, value = Dist.CLIENT)
public class LoveVigOverlay {

	private static final ResourceLocation LOVE_VIG_TEXTURE = ResourceLocation.fromNamespaceAndPath(PotionCore.MODID, "textures/screens/love_vig.png");

	@SubscribeEvent
	public static void registerGuiLayers(RegisterGuiLayersEvent event) {
		event.registerAbove(VanillaGuiLayers.CAMERA_OVERLAYS, ResourceLocation.fromNamespaceAndPath(PotionCore.MODID, "love_vig_overlay"), (guiGraphics, deltaTracker) -> {

			Minecraft minecraft = Minecraft.getInstance();

			if (minecraft.options.hideGui || minecraft.player == null) {
				return;
			}

			Player entity = minecraft.player;

			if (LoveVigDisplayOverlayIngameProcedure.execute(entity)) {

				int w = guiGraphics.guiWidth();
				int h = guiGraphics.guiHeight();

				guiGraphics.blit(LOVE_VIG_TEXTURE, 0, 0, 0, 0, w, h, w, h);
			}
		});
	}
}