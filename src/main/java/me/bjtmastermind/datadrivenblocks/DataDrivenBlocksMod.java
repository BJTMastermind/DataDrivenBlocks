package me.bjtmastermind.datadrivenblocks;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.bjtmastermind.datadrivenblocks.block.ModBlocks;

public class DataDrivenBlocksMod implements ModInitializer {
    public static final String MODID = "datadrivenblocks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
    }
}
