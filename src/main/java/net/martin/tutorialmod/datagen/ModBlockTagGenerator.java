package net.martin.tutorialmod.datagen;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.block.ModBlocks;
import net.martin.tutorialmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        this.tag(ModTags.Blocks.HABERO_WAPONO_DETECTOR).
                add(ModBlocks.RAW_HABER_BLOCK.get()).
                addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).
                add(ModBlocks.HABER_BLOCK.get(),
                        ModBlocks.RAW_HABER_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL).
                add(ModBlocks.HABER_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).
                add(ModBlocks.RAW_HABER_BLOCK.get());

        this.tag(BlockTags.FENCES).add(ModBlocks.HABER_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.HABER_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.HABER_WALL.get());
    }
}
