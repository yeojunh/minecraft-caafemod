package net.caafe.caafemod.datagen;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
                new ResourceLocation(CaafeMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
