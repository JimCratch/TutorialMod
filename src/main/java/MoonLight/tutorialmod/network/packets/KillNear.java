package MoonLight.tutorialmod.network.packets;

import MoonLight.tutorialmod.TutorialMod;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.network.handling.PlayPayloadContext;
import org.jetbrains.annotations.NotNull;

public class KillNear implements CustomPacketPayload {
    public static final ResourceLocation IDENTIFIER = new ResourceLocation(TutorialMod.MOD_ID, "kill_near_serverbound");

    private final int id;

    public KillNear(int id) {
        this.id = id;
    }

    public KillNear(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public void handle(PlayPayloadContext ctx) {
        ctx.workHandler().execute(() -> {
            if (!(ctx.player().orElseThrow() instanceof ServerPlayer sender)) return;

            Entity entity = sender.level().getEntity(this.id);

            if (entity == null) return;

            entity.kill();
            entity.setRemoved(Entity.RemovalReason.KILLED);
        });
    }

    @Override
    public void write(FriendlyByteBuf pBuffer) {
        pBuffer.writeInt(this.id);
    }


    @Override
    public @NotNull ResourceLocation id() {
        return IDENTIFIER;
    }
}