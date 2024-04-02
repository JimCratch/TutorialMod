package MoonLight.tutorialmod;

import MoonLight.tutorialmod.block.ModBlocks;
import MoonLight.tutorialmod.item.ModItems;
import MoonLight.tutorialmod.modcreativemodetabs.ModCreativeModTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";

    public TutorialMod(IEventBus bus) {
        ModLoadingContext ctx = ModLoadingContext.get();

        ModItems.ITEMS.register(bus);
        ModBlocks.BLOCKS.register(bus);
        ModCreativeModTabs.CREATIVE_MODE_TABS.register(bus);



        bus.addListener(TutorialMod::onClientSetup);
    }

    public static void onClientSetup(FMLClientSetupEvent event) {

    }
}