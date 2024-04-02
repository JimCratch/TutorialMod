package MoonLight.tutorialmod.item;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {

    public static final Tier USELESS = TierSortingRegistry.registerTier(
            new SimpleTier(5,1000,5f,10f,25,
                    ModTags.Blocks.NEEDS_USELESS_TOOL, () -> Ingredient.of(ModItems.USELESS_ITEM.get())),
            new ResourceLocation(TutorialMod.MOD_ID, "useless"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier ANOSVOLDIGOAD = TierSortingRegistry.registerTier(
            new SimpleTier(5,1000000000,100000000000000000000000000000000000000f,100000000000000000000000000000000000000f,1000000000,
                    ModTags.Blocks.ANOS_VENUZDONOA, () -> Ingredient.of(ModItems.USELESS_ITEM.get())),
                    new ResourceLocation(TutorialMod.MOD_ID,"venuzdonoa"), List.of(Tiers.NETHERITE), List.of());

}
