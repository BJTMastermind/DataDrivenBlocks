package me.bjtmastermind.datadrivenblocks.block;

import me.bjtmastermind.datadrivenblocks.DataDrivenBlocksMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block UNKNOWN_BLOCK = registerBlock("unknown",
        new UnknownBlock(FabricBlockSettings.of(Material.STONE).breakInstantly().resistance(0f).hardness(0f).mapColor(MapColor.DIRT_BROWN)));
    public static final Block INVISIBLE_BEDROCK = registerBlock("invisible_bedrock",
        new InvisibleBedrock(FabricBlockSettings.of(Material.BARRIER).resistance(3600000.8f).hardness(-1).dropsNothing().nonOpaque().noBlockBreakParticles()));

    public static void registerModBlocks() {
        DataDrivenBlocksMod.LOGGER.info("Registering mod blocks for "+DataDrivenBlocksMod.MODID);
    }

    private static Block registerBlock(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, new Identifier(DataDrivenBlocksMod.MODID, id), block);
    }

    private static Item registerBlockItem(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, new Identifier(DataDrivenBlocksMod.MODID, id),
            new BlockItem(block, new FabricItemSettings()));
        return item;
    }
}
