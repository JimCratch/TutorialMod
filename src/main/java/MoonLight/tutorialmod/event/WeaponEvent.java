package MoonLight.tutorialmod.event;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.damage.DamageSources;
import MoonLight.tutorialmod.item.ModItems;
import MoonLight.tutorialmod.util.DamageUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import java.util.ArrayList;
import java.util.List;
import net.neoforged.neoforge.event.entity.living.LivingDestroyBlockEvent;


public class WeaponEvent {
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void AttackLivingPriorityLOW(LivingAttackEvent event) {
            LivingEntity victim = event.getEntity();

            if (victim.level().isClientSide) return;

            DamageSource source = event.getSource();

            if (!(source.getEntity() instanceof LivingEntity attacker)) return;

            List<Item> items = new ArrayList<>();

            items.add(attacker.getItemInHand(InteractionHand.MAIN_HAND).getItem());

            if (!DamageUtil.isMelee(source)) return;

            if (!source.is(DamageSources.Custom_Damage) && items.contains(ModItems.VENUZDONOA.get())) {
                event.setCanceled(victim.hurt(DamageSources.customDamage(attacker), 1000000000));
            }
        }
    }
}