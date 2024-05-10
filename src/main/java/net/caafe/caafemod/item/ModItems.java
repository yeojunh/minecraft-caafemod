package net.caafe.caafemod.item;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.item.custom.FuelItem;
import net.caafe.caafemod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CaafeMod.MOD_ID);

    public static final RegistryObject<Item> EMPTY_CUP = ITEMS.register("empty_cup", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEAN = ITEMS.register("coffee_bean", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ROASTED_COFFEE_BEAN = ITEMS.register("roasted_coffee_bean", () -> new Item(new Item.Properties()));

    // custom foods
    public static final RegistryObject<Item> CUP_OF_COFFEE = ITEMS.register("cup_of_coffee", () -> new Item(new Item.Properties().food(ModFoods.CUP_OF_COFFEE)));

    // custom behaviours
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> USED_COFFEE_GROUNDS = ITEMS.register("used_coffee_grounds", () -> new FuelItem(new Item.Properties(), 400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
