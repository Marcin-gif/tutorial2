package net.martin.tutorialmod.item;


//import net.martin.tutorialmod.TutorialMod;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.item.custom.FuelItem;
import net.martin.tutorialmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);
    public static final RegistryObject<Item> HABER = ITEMS.register("haber",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HABER_WAPON = ITEMS.register("haber_wapon",
            ()->new MetalDetectorItem(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> HABER_FOOD = ITEMS.register("haber_food"
    ,()->new Item(new Item.Properties().food(ModFoods.HABERFOOD)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            ()->new FuelItem(new Item.Properties(),480));
    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}