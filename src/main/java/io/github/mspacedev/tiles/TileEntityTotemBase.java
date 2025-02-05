/*
 *  Copyright © MSpaceDev 2019
 *  Do not distribute without proper permission from the author.
 *
 *  If you would like to contribute, create a pull request:
 *  https://github.com/MSpaceDev/MonsterTotems
 */

package io.github.mspacedev.tiles;

import io.github.mspacedev.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;

public class TileEntityTotemBase extends TileEntityBase
{
	public boolean hasZombie;
	public boolean hasSkeleton;
	public boolean hasCreeper;
	public boolean hasSpider;
	public boolean hasEnderman;
	public boolean hasWitch;
	public boolean hasSilverfish;
	public boolean hasSlime;
	public boolean hasBlaze;
	public boolean hasZombiePigman;
	public boolean hasGhast;
	public boolean hasMagmaCube;
	public boolean isMaster;

	private long cooldown;
	private int cooldownTicks;

	public TileEntityTotemBase()
	{
		this.cooldownTicks = 200;
	}

	/**
	 * Create a cooldown for how many ticks are set in the constructor.
	 * Other classes may check if this cooldown is over
	 */
	public boolean isCooldownOver()
	{
		// Cooldown finished
		if (world.getTotalWorldTime() > cooldown)
		{
			cooldown = world.getTotalWorldTime() + cooldownTicks;
			return true;
		}

		return false;
	}

	/**
	 * Resets the cooldown of this totem base.
	 */
	public void resetCooldown()
	{
		cooldown = world.getTotalWorldTime();
	}

	/**
	 * @return false if there are no totem heads active on top of this totem base
	 */
	public boolean hasActiveTotemHeads()
	{
		return hasZombie || hasSkeleton || hasCreeper || hasSpider ||
				hasEnderman || hasWitch || hasSilverfish || hasSlime ||
				hasBlaze || hasGhast || hasZombiePigman || hasMagmaCube || isMaster;
	}

	/**
	 * Sets totem properties based on what blocks are placed above the totem base
	 */
	public void setTotemProperties()
	{
		resetTotemProperties();
		Iterable<BlockPos> totemBaseRange = BlockPos.getAllInBox(pos, pos.add(0.0D, 12.0D, 0.0D));

		for (BlockPos blockPos : totemBaseRange)
		{
			Block current = getWorld().getBlockState(blockPos).getBlock();

			if (current == Blocks.AIR)
				break;

			if (current == ModBlocks.zombie_totem)
				hasZombie = true;
			else if (current == ModBlocks.skeleton_totem)
				hasSkeleton = true;
			else if (current == ModBlocks.creeper_totem)
				hasCreeper = true;
			else if (current == ModBlocks.spider_totem)
				hasSpider = true;
			else if (current == ModBlocks.enderman_totem)
				hasEnderman = true;
			else if (current == ModBlocks.witch_totem)
				hasWitch = true;
			else if (current == ModBlocks.silverfish_totem)
				hasSilverfish = true;
			else if (current == ModBlocks.slime_totem)
				hasSlime = true;
			else if (current == ModBlocks.blaze_totem)
				hasBlaze = true;
			else if (current == ModBlocks.zombie_pigman_totem)
				hasZombiePigman = true;
			else if (current == ModBlocks.ghast_totem)
				hasGhast = true;
			else if (current == ModBlocks.magma_cube_totem)
				hasMagmaCube = true;
			else if (current == ModBlocks.overworld_totem)
			{
				hasZombie = true;
				hasSkeleton = true;
				hasCreeper = true;
				hasSpider = true;
			} else if (current == ModBlocks.nether_totem)
			{
				hasBlaze = true;
				hasGhast = true;
				hasMagmaCube = true;
				hasZombiePigman = true;
			} else if (current == ModBlocks.unnatural_totem)
			{
				hasEnderman = true;
				hasWitch = true;
				hasSilverfish = true;
				hasSlime = true;
			} else if (current == ModBlocks.master_totem)
				isMaster = true;
		}
	}

	/**
	 * Sets all booleans for this tile to false
	 */
	private void resetTotemProperties()
	{
		hasZombie = false;
		hasSkeleton = false;
		hasCreeper = false;
		hasSpider = false;
		hasEnderman = false;
		hasWitch = false;
		hasSilverfish = false;
		hasSlime = false;
		hasBlaze = false;
		hasGhast = false;
		hasZombiePigman = false;
		hasMagmaCube = false;
		isMaster = false;
	}

	/**
	 * Retrieves all totem head stats when the tile entity is loaded
	 */
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setBoolean("hasZombie", this.hasZombie);
		compound.setBoolean("hasSkeleton", this.hasSkeleton);
		compound.setBoolean("hasCreeper", this.hasCreeper);
		compound.setBoolean("hasSpider", this.hasSpider);
		compound.setBoolean("hasEnderman", this.hasEnderman);
		compound.setBoolean("hasWitch", this.hasWitch);
		compound.setBoolean("hasSilverfish", this.hasSilverfish);
		compound.setBoolean("hasSlime", this.hasSlime);
		compound.setBoolean("hasBlaze", this.hasBlaze);
		compound.setBoolean("hasZombiePigman", this.hasZombiePigman);
		compound.setBoolean("hasGhast", this.hasGhast);
		compound.setBoolean("hasMagmaCube", this.hasMagmaCube);
		compound.setBoolean("isMaster", this.isMaster);
		return compound;
	}

	/**
	 * Saves all totem head stats when the tile entity is unloaded
	 */
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		this.hasZombie = compound.getBoolean("hasZombie");
		this.hasSkeleton = compound.getBoolean("hasSkeleton");
		this.hasCreeper = compound.getBoolean("hasCreeper");
		this.hasSpider = compound.getBoolean("hasSpider");
		this.hasEnderman = compound.getBoolean("hasEnderman");
		this.hasWitch = compound.getBoolean("hasWitch");
		this.hasSilverfish = compound.getBoolean("hasSilverfish");
		this.hasSlime = compound.getBoolean("hasSlime");
		this.hasBlaze = compound.getBoolean("hasBlaze");
		this.hasZombiePigman = compound.getBoolean("hasZombiePigman");
		this.hasGhast = compound.getBoolean("hasGhast");
		this.hasMagmaCube = compound.getBoolean("hasMagmaCube");
		this.isMaster = compound.getBoolean("isMaster");
		super.readFromNBT(compound);
	}
}
