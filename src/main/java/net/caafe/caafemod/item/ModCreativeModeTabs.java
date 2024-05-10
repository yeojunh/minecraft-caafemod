package net.caafe.caafemod.item;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CaafeMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CAAFEMOD_TAB =
            CREATIVE_MODE_TABS.register("caafemod_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CUP_OF_COFFEE.get()))
                    .title(Component.translatable("creativetab.caafemod_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.CUP_OF_COFFEE.get());
                        pOutput.accept(ModItems.COFFEE_BEAN.get());
                        pOutput.accept(ModItems.EMPTY_CUP.get());
                        pOutput.accept((ModItems.ROASTED_COFFEE_BEAN.get()));

                        pOutput.accept((ModItems.METAL_DETECTOR.get()));

                        pOutput.accept(ModBlocks.BLOCK_OF_COFFEE_BEANS.get());
                        pOutput.accept(ModBlocks.BLOCK_OF_ROASTED_COFFEE_BEANS.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
