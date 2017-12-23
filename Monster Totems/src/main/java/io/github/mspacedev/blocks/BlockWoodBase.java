package io.github.mspacedev.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class BlockWoodBase extends BlockBase {
    public BlockWoodBase(String name, Material materialIn) {
        super(name, materialIn);
        this.setHardness(2.0f);
        this.setSoundType(SoundType.WOOD);
        setHarvestLevel("axe", 0);
    }
}