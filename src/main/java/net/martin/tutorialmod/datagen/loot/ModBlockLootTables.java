package net.martin.tutorialmod.datagen.loot;

import net.martin.tutorialmod.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.HABER_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_HABER_BLOCK.get());
        this.add(ModBlocks.RAW_HABER_BLOCK.get(), block ->
                createCopperLikeOreDrops(ModBlocks.RAW_HABER_BLOCK.get()));

        this.dropSelf(ModBlocks.HABER_STAIRS.get());
        this.dropSelf(ModBlocks.HABER_FENCE.get());
        this.dropSelf(ModBlocks.HABER_WALL.get());
        this.dropSelf(ModBlocks.HABER_BUTTON.get());
        //this.dropSelf(ModBlocks.HABER_SLAB.get());
        this.dropSelf(ModBlocks.HABER_FENCE_GATE.get());
        this.dropSelf(ModBlocks.HABER_PRESSURE_PLATE.get());
        this.add(ModBlocks.HABER_SLAB.get(), block -> createDoorTable(ModBlocks.HABER_SLAB.get()));
        //this.add(ModBlocks.HABER_DOOR.get(), block -> createDoorTable(ModBlocks.HABER_DOOR.get()));
    }
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock) {
        return createSilkTouchDispatchTable(pBlock,applyExplosionDecay(pBlock, LootItem.lootTableItem(pBlock)));

//                this.applyExplosionDecay
//                        (pBlock, LootItem.lootTableItem
//                                (item).
//                                apply(SetItemCountFunction.
//                                        setCount(UniformGenerator.between(2.0F, 5.0F))).
//                                apply(ApplyBonusCount.
//                                        addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().
                map(RegistryObject::get)::iterator;
    }
}
