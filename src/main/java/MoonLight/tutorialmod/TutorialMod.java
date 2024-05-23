package MoonLight.tutorialmod;

import MoonLight.tutorialmod.block.ModBlocks;
import MoonLight.tutorialmod.enchantment.ModEnchantments;
import MoonLight.tutorialmod.event.ArrowEvent;
import MoonLight.tutorialmod.item.ModItems;
import MoonLight.tutorialmod.modcreativemodetabs.ModCreativeModTabs;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";

    public TutorialMod(IEventBus bus) {

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModCreativeModTabs.CREATIVE_MODE_TABS.register(bus);
        ModEnchantments.ENCHANTMENTS.register(bus);


        bus.addListener(TutorialMod::onClientSetup);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
    }
}