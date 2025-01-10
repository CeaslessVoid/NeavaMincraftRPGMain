package net.neava.neavarpgmain.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.neava.neavarpgmain.NeavaRPGMod;
import net.neava.neavarpgmain.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, NeavaRPGMod.MODID);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlock(name, toReturn);
        return  toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlock(String name, RegistryObject<T> block)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

//    public static final RegistryObject<Block> UPGRADE_TABLE = registerBlock("upgrade_table",
//            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));


    public static void register(IEventBus eventBus)
    {
        BLOCKS.register(eventBus);
    }

}
