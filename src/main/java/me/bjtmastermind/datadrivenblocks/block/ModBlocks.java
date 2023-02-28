package me.bjtmastermind.datadrivenblocks.block;

import java.util.function.Supplier;

import me.bjtmastermind.datadrivenblocks.DataDrivenBlocksMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DataDrivenBlocksMod.MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DataDrivenBlocksMod.MODID);

    public static final RegistryObject<Block> UNKNOWN_BLOCK = registerBlock("unknown",
        () -> new Block(BlockBehaviour.Properties.of(Material.STONE).instabreak().explosionResistance(0f).destroyTime(0f).color(MaterialColor.DIRT)));
    public static final RegistryObject<Block> INVISIBLE_BEDROCK = registerBlock("invisible_bedrock",
        () -> new InvisibleBedrock(BlockBehaviour.Properties.of(Material.BARRIER).explosionResistance(3600000.8f).destroyTime(-1).noOcclusion().noParticlesOnBreak()));

    public static void register(IEventBus event) {
        BLOCKS.register(event);
        BLOCK_ITEMS.register(event);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
