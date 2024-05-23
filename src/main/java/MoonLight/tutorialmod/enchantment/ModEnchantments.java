package MoonLight.tutorialmod.enchantment;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.enchantment.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(Registries.ENCHANTMENT, TutorialMod.MOD_ID);

    public static final DeferredHolder<Enchantment,Enchantment> Inflation = ENCHANTMENTS.register("inflation",
            () -> new InflationDelete(Enchantment.Rarity.VERY_RARE, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
}
