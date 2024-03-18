package net.martin.tutorialmod.datagen;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
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
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item)
    {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).
                texture("layer0",
                new ResourceLocation(TutorialMod.MOD_ID,
                        "item/"+item.getId().getPath()));
    }

}
