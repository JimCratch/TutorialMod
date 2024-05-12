package MoonLight.tutorialmod.network;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.network.packets.*;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlerEvent;
import net.neoforged.neoforge.network.registration.IPayloadRegistrar;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PacketHandler {
    @SubscribeEvent
    public static void onRegisterPayloadHandler(RegisterPayloadHandlerEvent event) {
        IPayloadRegistrar registrar = event.registrar(TutorialMod.MOD_ID)
                .versioned("1.2.3");

        // Clientbound packets
        registrar.play(KillNear.IDENTIFIER, KillNear::new, handler -> handler
                .client(KillNear::handle)
                .server(KillNear::handle));

        registrar.play(ArrowAgain.IDENTIFIER, ArrowAgain::new, handler -> handler
                .client(ArrowAgain::handle)
                .server(ArrowAgain::handle));
    }

    public static <MSG extends CustomPacketPayload> void broadcast(MSG message) {
        PacketDistributor.ALL.noArg().send(message);
    }

    public static <MSG extends CustomPacketPayload> void sendToServer(MSG message) {
        PacketDistributor.SERVER.noArg().send(message);
    }

    public static <MSG extends CustomPacketPayload> void sendToClient(MSG message, ServerPlayer player) {
        PacketDistributor.PLAYER.with(player).send(message);
    }
}