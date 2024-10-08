package net.martin.tutorialmod.datagen;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.block.ModBlocks;
import net.martin.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.HABER);
        simpleItem(ModItems.HABER_FOOD);
        simpleItem(ModItems.HABER_WAPON);
        simpleItem(ModItems.PINE_CONE);

        //simpleBlockItem(ModBlocks.HABER_DOOR);
        fenceItem(ModBlocks.HABER_FENCE,ModBlocks.HABER_BLOCK);
        buttonItem(ModBlocks.HABER_BUTTON,ModBlocks.HABER_BLOCK);
        wallItem(ModBlocks.HABER_WALL,ModBlocks.HABER_BLOCK);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).
                texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,
                        "item/"+item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block,RegistryObject<Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/fence_inventory"))
                .texture("texture",new ResourceLocation(TutorialMod.MOD_ID,"block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));

    }
    public void buttonItem(RegistryObject<Block> block,RegistryObject<Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/button_inventory"))
                .texture("texture",new ResourceLocation(TutorialMod.MOD_ID,"block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));

    }
    public void wallItem(RegistryObject<Block> block,RegistryObject<Block> baseBlock)
    {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),mcLoc("block/wall_inventory"))
                .texture("texture",new ResourceLocation(TutorialMod.MOD_ID,"block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));

    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).
                texture("layer0",
                        new ResourceLocation(TutorialMod.MOD_ID,
                                "item/"+item.getId().getPath()));
    }
}
