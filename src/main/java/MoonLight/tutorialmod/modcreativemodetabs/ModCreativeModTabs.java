package MoonLight.tutorialmod.modcreativemodetabs;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab", () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.USELESS_ITEM.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.USELESS_ITEM.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.RUBIX_CUBE.get());
                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.BURNING_FUEL.get());
                        pOutput.accept(ModItems.USELESS_SWORD.get());
                        pOutput.accept(ModItems.USELESS_AXE.get());
                        pOutput.accept(ModItems.USELESS_HOE.get());
                        pOutput.accept(ModItems.USELESS_PICKAXE.get());
                        pOutput.accept(ModItems.USELESS_SHOVEL.get());
                        pOutput.accept(ModItems.USELESS_HELMET.get());
                        pOutput.accept(ModItems.USELESS_CHESTPLATE.get());
                        pOutput.accept(ModItems.USELESS_LEGGINGS.get());
                        pOutput.accept(ModItems.USELESS_BOOTS.get());
                        pOutput.accept(ModItems.VENUZDONOA.get());
                        pOutput.accept(ModItems.WEIRD_SWORD.get());
                        pOutput.accept(ModItems.COOL_SWORD.get());
                    }))
                    .build());

}