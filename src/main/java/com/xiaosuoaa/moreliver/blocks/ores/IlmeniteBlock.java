package com.xiaosuoaa.moreliver.blocks.ores;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class IlmeniteBlock extends Block {
	public IlmeniteBlock() {
        super(Properties.ofFullCopy(Blocks.STONE).strength(3f));
    }
}
