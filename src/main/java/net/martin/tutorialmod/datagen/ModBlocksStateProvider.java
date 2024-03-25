package net.martin.tutorialmod.datagen;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    blockWithItem(ModBlocks.HABER_BLOCK);
    blockWithItem(ModBlocks.RAW_HABER_BLOCK);

    stairsBlock((StairBlock) ModBlocks.HABER_STAIRS.get(),blockTexture(ModBlocks.HABER_BLOCK.get()));
    slabBlock((SlabBlock) ModBlocks.HABER_SLAB.get(),blockTexture(ModBlocks.HABER_BLOCK.get()),blockTexture(ModBlocks.HABER_BLOCK.get()));
    pressurePlateBlock((PressurePlateBlock) ModBlocks.HABER_PRESSURE_PLATE.get(),blockTexture(ModBlocks.HABER_BLOCK.get()));

    fenceBlock((FenceBlock) ModBlocks.HABER_FENCE.get(),blockTexture(ModBlocks.HABER_BLOCK.get()));
    fenceGateBlock((FenceGateBlock) ModBlocks.HABER_FENCE_GATE.get(),blockTexture(ModBlocks.HABER_BLOCK.get()));
    wallBlock((WallBlock) ModBlocks.HABER_WALL.get(),blockTexture(ModBlocks.HABER_BLOCK.get()));

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject)
    {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
