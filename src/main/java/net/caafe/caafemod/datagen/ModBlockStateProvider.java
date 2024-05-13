package net.caafe.caafemod.datagen;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, CaafeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_COFFEE_BEANS);
        blockWithItem(ModBlocks.BLOCK_OF_ROASTED_COFFEE_BEANS);

        blockWithItem(ModBlocks.CL4P_TP_BLOCK);

        blockWithItem(ModBlocks.SOUND_BLOCK);

        stairsBlock((StairBlock) ModBlocks.CL4P_TP_STAIRS.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.CL4P_TP_SLAB.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));

        buttonBlock((ButtonBlock) ModBlocks.CL4P_TP_BUTTON.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.CL4P_TP_PRESSURE_PLATE.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));

        fenceBlock((FenceBlock) ModBlocks.CL4P_TP_FENCE.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.CL4P_TP_FENCE_GATE.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.CL4P_TP_WALL.get(), blockTexture(ModBlocks.CL4P_TP_BLOCK.get()));

        doorBlockWithRenderType((DoorBlock) ModBlocks.CL4P_TP_DOOR.get(), modLoc("block/cl4p_tp_door_bottom"), modLoc("block/cl4p_tp_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) ModBlocks.CL4P_TP_TRAPDOOR.get(), modLoc("block/cl4p_tp_trapdoor"), true, "cutout");
    }

    // pass in block -> make custom block + item model
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
