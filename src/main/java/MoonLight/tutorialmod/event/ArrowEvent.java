package MoonLight.tutorialmod.event;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.damage.DamageSources;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class ArrowEvent {

        @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
        public static class Arrows {
            @SubscribeEvent(priority = EventPriority.LOWEST)
            public static void ProjectileLand(ProjectileImpactEvent event) {
                Level player = Minecraft.getInstance().player.level();
                boolean level = player.isClientSide;

                if (level) return;

                int blockX = event.getProjectile().getBlockX();
                int blockY = event.getProjectile().getBlockY();
                int blockZ = event.getProjectile().getBlockZ();
                LivingEntity players = Minecraft.getInstance().player;

                Projectile projectile = event.getProjectile();

                player.explode(projectile, DamageSources.customDamage(players),
                        new ExplosionDamageCalculator(), blockX, blockY, blockZ,
                        3,false, Level.ExplosionInteraction.TNT);

                projectile.remove(Entity.RemovalReason.DISCARDED);

            }
        }
}
