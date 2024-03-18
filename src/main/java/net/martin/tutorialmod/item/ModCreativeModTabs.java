package net.martin.tutorialmod.item;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.HABER.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.HABER.get());
                        pOutput.accept(ModItems.HABER_WAPON.get());


                        pOutput.accept(Items.DIAMOND);
                        pOutput.accept(ModBlocks.RAW_HABER_BLOCK.get());
                        pOutput.accept(ModBlocks.HABER_BLOCK.get());
                        pOutput.accept(ModBlocks.HABER_ORE.get());
                        pOutput.accept(ModItems.HABER_FOOD.get());
                        pOutput.accept(ModItems.PINE_CONE.get());
                        /*pOutput.accept(ModBlocks.DEEPSLATE_HABER_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_HABER_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_HABER_ORE.get());*/
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
