package MoonLight.tutorialmod.item;

import MoonLight.tutorialmod.TutorialMod;
import MoonLight.tutorialmod.item.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(BuiltInRegistries.ITEM, TutorialMod.MOD_ID);

    public static final DeferredHolder<Item, Item> USELESS_ITEM = ITEMS.register("useless_item",
            () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item>  METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final DeferredHolder<Item, Item> RUBIX_CUBE = ITEMS.register("rubix_cube",
            () -> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredHolder<Item, Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final DeferredHolder<Item, Item> BURNING_FUEL = ITEMS.register("burning_fuel",
            () -> new FuelItem(new Item.Properties(), 100));

    public static final DeferredHolder<Item, Item> USELESS_SWORD = ITEMS.register("useless_sword",
            () -> new EffectApplyingSword(ModToolTiers.USELESS,3, 5, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_AXE = ITEMS.register("useless_axe",
            () -> new AxeItem(ModToolTiers.USELESS,3, 5, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_PICKAXE = ITEMS.register("useless_pickaxe",
            () -> new PickaxeItem(ModToolTiers.USELESS,3, 5, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_HOE = ITEMS.register("useless_hoe",
            () -> new HoeItem(ModToolTiers.USELESS,3, 5, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_SHOVEL = ITEMS.register("useless_shovel",
            () -> new ShovelItem(ModToolTiers.USELESS,3, 5, new Item.Properties()));

    public static final DeferredHolder<Item, Item> WEIRD_SWORD = ITEMS.register("weird_sword",
            () -> new SwordItem(ModToolTiers.USELESS,10,10, new Item.Properties()));

    public static final DeferredHolder<Item, Item> COOL_SWORD = ITEMS.register("cool_sword",
            () -> new SwordItem(ModToolTiers.USELESS,10,10, new Item.Properties()));

    public static final DeferredHolder<Item, Item> VENUZDONOA = ITEMS.register("venuzdonoa",
            () -> new VenezdonoaItem(ModToolTiers.ANOSVOLDIGOAD, 1000000000,1000000000, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).fireResistant()));

    public static final DeferredHolder<Item, Item> USELESS_BOW = ITEMS.register("useless_bow",
            () -> new CustomBowItem(new Item.Properties()));

    public static final DeferredHolder<Item, Item> USELESS_HELMET = ITEMS.register("useless_helmet",
            () -> new ModArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_CHESTPLATE = ITEMS.register("useless_chestplate",
            () -> new ModArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_LEGGINGS = ITEMS.register("useless_leggings",
            () -> new ModArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredHolder<Item, Item> USELESS_BOOTS = ITEMS.register("useless_boots",
            () -> new ModArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));

}
