package MoonLight.tutorialmod.event;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.network.PacketHandler;
import MoonLight.tutorialmod.network.packets.ArrowAgain;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class ArrowEvent {

    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void ProjectileLandedLow(ProjectileImpactEvent event) {
            LivingEntity victim = Minecraft.getInstance().player;
            victim.sendSystemMessage(Component.literal("This is test before explosion"));

            Projectile source = event.getProjectile();

            int blockposx = event.getProjectile().getBlockX();
            int blockposy = event.getProjectile().getBlockY();
            int blockposz = event.getProjectile().getBlockZ();

            /*event.setCanceled(victim.level().explode(source,DamageSources.customDamage(victim),
                    new ExplosionDamageCalculator(), blockposx, blockposy, blockposz,
                    3,false, Level.ExplosionInteraction.TNT).interactsWithBlocks());*/

            PacketHandler.sendToServer(new ArrowAgain(blockposx,blockposy,blockposz));
            source.setRemoved(Entity.RemovalReason.DISCARDED);
        }
    }
}