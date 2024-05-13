package net.caafe.caafemod.datagen;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.block.ModBlocks;
import net.caafe.caafemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CaafeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.EMPTY_CUP);
        simpleItem(ModItems.CUP_OF_COFFEE);
        simpleItem(ModItems.COFFEE_BEAN);
        simpleItem(ModItems.ROASTED_COFFEE_BEAN);
        simpleItem(ModItems.USED_COFFEE_GROUNDS);

        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.COFFEE_BEAN);

        simpleBlockItem(ModBlocks.CL4P_TP_DOOR);

        fenceItem(ModBlocks.CL4P_TP_FENCE, ModBlocks.CL4P_TP_BLOCK);
        buttonItem(ModBlocks.CL4P_TP_BUTTON, ModBlocks.CL4P_TP_BLOCK);
        wallItem(ModBlocks.CL4P_TP_WALL, ModBlocks.CL4P_TP_BLOCK);

        evenSimplerBlockItem(ModBlocks.CL4P_TP_STAIRS);
        evenSimplerBlockItem(ModBlocks.CL4P_TP_SLAB);
        evenSimplerBlockItem(ModBlocks.CL4P_TP_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CL4P_TP_FENCE_GATE);

        trapdoorItem(ModBlocks.CL4P_TP_TRAPDOOR);
    }

    /**
     * Register a simple item model, equivalent to resources/assets/caafemod/models/item/xxx.json
     * {
     *   "parent": "item/generated",
     *   "textures": {
     *     "layer0": "caafemod:item/xxx"
     *   }
     * }
     *
     * @param item the item to register
     * @return the item model builder
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CaafeMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(CaafeMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(CaafeMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(CaafeMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(CaafeMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(CaafeMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
