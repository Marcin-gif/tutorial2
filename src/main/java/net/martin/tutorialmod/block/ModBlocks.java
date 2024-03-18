package net.martin.tutorialmod.block;

import net.martin.tutorialmod.TutorialMod;
import net.martin.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> HABER_BLOCK = registerBlock("haber_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_HABER_BLOCK = registerBlock("raw_haber_block",
            ()->new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> HABER_ORE = registerBlock("haber_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    /*public static final RegistryObject<Block> DEEPSLATE_HABER_ORE = registerBlock("deepslate_haber_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(),UniformInt.of(3,7)));
    public static final RegistryObject<Block> NETHER_HABER_ORE = registerBlock("nether_haber_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(1f).requiresCorrectToolForDrops(),UniformInt.of(3,7)));
    public static final RegistryObject<Block> END_STONE_HABER_ORE = registerBlock("end_stone_haber_ore",
            ()->new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(5f).requiresCorrectToolForDrops(),UniformInt.of(3,7)));*/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>blocks)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name,blocks);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T>block){
        return ModItems.ITEMS.register(name,()->new BlockItem(block.get(),new Item.Properties()));
    }
    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }
}
