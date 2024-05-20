package MoonLight.tutorialmod.event;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.item.ModItems;
import MoonLight.tutorialmod.item.custom.CustomBowItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;

public class ArrowEvent {

    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void ProjectileLandedLow(ProjectileImpactEvent event) {
            Projectile projectile = event.getProjectile();
            Level world = projectile.level();

            if (world.isClientSide()) {
                return;
            }

            if (projectile instanceof Arrow) {

                double x = projectile.getX();
                double y = projectile.getY();
                double z = projectile.getZ();
                projectile.setRemoved(Entity.RemovalReason.DISCARDED);

                /*
                PrimedTnt tnt = new PrimedTnt(EntityType.TNT, world);
                tnt.setPos(x,y,z);
                tnt.setFuse(100); // 5-Second Timer




                LivingEntity entity = EntityType.ZOMBIE.create(world);


                if (entity != null) {
                    entity.setPos(x,y,z);
                    world.addFreshEntity(entity);
                }
                //world.addFreshEntity(tnt);

                 */
                world.explode(null, x, y, z, 5.0F, false, Level.ExplosionInteraction.TNT);
            }
        }
    }
}