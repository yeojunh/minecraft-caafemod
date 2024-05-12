package net.caafe.caafemod.datagen;

import net.caafe.caafemod.CaafeMod;
import net.caafe.caafemod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, CaafeMod.MOD_ID, existingFileHelper);
    }

    // equivalent to metal_detector_valuables.json in resources/data/caafemod/tags/blocks
    // {
    //  "values": [
    //    "caafemod:block_of_coffee_beans",
    //    "#forge:ores"
    //  ]
    // }
    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // forge/tags/blocks/mineable/xxx.json equivalent
        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(
                    ModBlocks.BLOCK_OF_COFFEE_BEANS.get(),
                    ModBlocks.BLOCK_OF_ROASTED_COFFEE_BEANS.get(),
                    ModBlocks.SOUND_BLOCK.get()
                );

        // minecraft/tags/blocks needs_xxx_tool.json equivalent
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());

        // metal detector tags (custom items) equivalent
//        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
//                .add(ModBlocks.BLOCK_OF_COFFEE_BEANS.get()).addTag(Tags.Blocks.ORES);

    }
}
