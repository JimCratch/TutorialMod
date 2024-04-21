package MoonLight.tutorialmod.client.handler;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.client.Keybindings;
import MoonLight.tutorialmod.network.PacketHandler;
import MoonLight.tutorialmod.network.packets.KillNear;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientForgeHandler {
    private static final Component EXAMPLE_KEY_PRESSED =
            Component.translatable("message." + TutorialMod.MOD_ID + ".example_key_pressed");

    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        Minecraft minecraft = Minecraft.getInstance();
        if(Keybindings.INSTANCE.exampleKey.consumeClick() && minecraft.player != null) {
            minecraft.player.sendSystemMessage(Component.literal("Hello"));
            minecraft.player.displayClientMessage(EXAMPLE_KEY_PRESSED,true);
        }

        if(Keybindings.INSTANCE.examplePacketKey.consumeClick() && minecraft.player != null) {
            //minecraft.player.sendSystemMessage(Component.literal("Hiiiii"));
                Entity hitResult = minecraft.crosshairPickEntity;
                LocalPlayer entityHitResult = Minecraft.getInstance().player;
                if(hitResult != null) {
                    //sendMessageToTarget(hitResult.getDisplayName().getString());
                    minecraft.player.sendSystemMessage(Component.literal("Snap"));
                    PacketHandler.sendToServer(new KillNear(hitResult.getId()));
                }
                else {
                    sendMessageToTarget(entityHitResult.getDisplayName().getString());

                }
        }
    }

    private static void sendMessageToTarget(String targetName) {
        Minecraft.getInstance().player.sendSystemMessage(Component.literal("Hello, " + targetName + "! You're being watched!"));
    }

}
