/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoodBase extends BlockBase
{
	public BlockWoodBase(String name, Material materialIn)
	{
		super(name, materialIn);
		this.setHardness(2.0f);
		this.setSoundType(SoundType.WOOD);
		setHarvestLevel("axe", 0);
	}

	public BlockWoodBase(String name, Material materialIn, String tooltip)
	{
		super(name, materialIn, tooltip);
		this.setHardness(2.0f);
		this.setSoundType(SoundType.WOOD);
		setHarvestLevel("axe", 0);
	}
}
