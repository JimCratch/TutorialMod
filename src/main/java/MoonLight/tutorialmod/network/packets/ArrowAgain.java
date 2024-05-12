package MoonLight.tutorialmod.network.packets;

import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class ArrowAgain implements CustomPacketPayload {
    public static final ResourceLocation IDENTIFIER = new ResourceLocation(TutorialMod.MOD_ID, "arrow_again_serverbound");

    private final int blockx;
    private final int blocky;
    private final int blockz;

    public ArrowAgain(int blockx, int blocky, int blockz) {
        this.blockx = blockx;
        this.blocky = blocky;
        this.blockz = blockz;
    }

    public ArrowAgain(FriendlyByteBuf buf) {
        this(buf.readInt(),buf.readInt(),buf.readInt());
    }

    public void handle(PlayPayloadContext ctx) {
        ctx.workHandler().execute(() -> {
            LocalPlayer player = Minecraft.getInstance().player;

            if (player == null) return;

            player.sendSystemMessage(Component.literal("Block X: " + this.blockx + "\nBlock Y: " + this.blocky + "\nBlock Z: " + this.blockz));
            player.level().explode(player,this.blockx,this.blocky,this.blockz,3, Level.ExplosionInteraction.TNT);
        });
    }

    @Override
    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(this.blockx);
        pBuffer.writeInt(this.blocky);
        pBuffer.writeInt(this.blockz);
    }


    @Override
    public @NotNull ResourceLocation id() {
        return IDENTIFIER;
    }
}