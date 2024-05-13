package net.caafe.caafemod.block;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.block.custom.SoundBlock;
import net.caafe.caafemod.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CaafeMod.MOD_ID);

    public static final RegistryObject<Block> BLOCK_OF_COFFEE_BEANS = registerBlock("block_of_coffee_beans",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> BLOCK_OF_ROASTED_COFFEE_BEANS = registerBlock("block_of_roasted_coffee_beans",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));

    // CL4P-TP block
    public static final RegistryObject<Block> CL4P_TP_BLOCK = registerBlock("cl4p_tp_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    // CL4P-TP stairs and slabs
    public static final RegistryObject<Block> CL4P_TP_STAIRS = registerBlock("cl4p_tp_stairs",
            () -> new StairBlock(ModBlocks.CL4P_TP_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CL4P_TP_SLAB = registerBlock("cl4p_tp_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CL4P_TP_BUTTON = registerBlock("cl4p_tp_button",
            () -> new ButtonBlock(BlockSetType.IRON,
                    10,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CL4P_TP_PRESSURE_PLATE = registerBlock("cl4p_tp_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CL4P_TP_FENCE = registerBlock("cl4p_tp_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> CL4P_TP_FENCE_GATE = registerBlock("cl4p_tp_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK),
                    SoundEvents.CHAIN_PLACE,
                    SoundEvents.ANVIL_BREAK,
                    WoodType.OAK)); // TODO: fix the wood type to iron
    public static final RegistryObject<Block> CL4P_TP_WALL = registerBlock("cl4p_tp_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> CL4P_TP_DOOR = registerBlock("cl4p_tp_door",
            () -> new DoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));
    public static final RegistryObject<Block> CL4P_TP_TRAPDOOR = registerBlock("cl4p_tp_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON, BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).noOcclusion()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
