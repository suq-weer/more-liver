package com.xiaosuoaa.moreliver.blocks.ores;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WaterOre extends Block {
	public WaterOre() {
		super(Properties.ofFullCopy(Blocks.STONE).strength(3f));
	}
}
