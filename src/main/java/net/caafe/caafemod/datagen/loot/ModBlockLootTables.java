package net.caafe.caafemod.datagen.loot;

import net.caafe.caafemod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.BLOCK_OF_COFFEE_BEANS.get());
        this.dropSelf(ModBlocks.BLOCK_OF_ROASTED_COFFEE_BEANS.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());
        this.dropSelf(ModBlocks.CL4P_TP_BLOCK.get());
        this.dropSelf(ModBlocks.CL4P_TP_STAIRS.get());
        this.dropSelf(ModBlocks.CL4P_TP_BUTTON.get());
        this.dropSelf(ModBlocks.CL4P_TP_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CL4P_TP_TRAPDOOR.get());
        this.dropSelf(ModBlocks.CL4P_TP_FENCE.get());
        this.dropSelf(ModBlocks.CL4P_TP_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CL4P_TP_WALL.get());

        this.add(ModBlocks.CL4P_TP_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CL4P_TP_SLAB.get()));
        this.add(ModBlocks.CL4P_TP_DOOR.get(),
                block -> createDoorTable(ModBlocks.CL4P_TP_DOOR.get()));

        // add drops for ores
//        this.add(ModBlocks.SOME_ORE.get(),
//                block -> createCopperLikeOreDrops(ModBlocks.SOME_ORE.get(), ModItems.SOME_RAW_ORE.get()));
    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     * all blocks with loot tables = all blocks added via ModBlocks deferred register BLOCKS object
     * has a custom loot table unless specified to have no loot table
     **/
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
