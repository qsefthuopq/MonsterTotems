package io.github.mspacedev.tiles;

import io.github.mspacedev.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class TileEntityTotemBase extends TileEntity {
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
     * Sets totem properties based on what block was placed above the totem base
     */
    public void setTotemProperties() {
        resetTotemProperties();
        Iterable<BlockPos> totemBaseRange = BlockPos.getAllInBox(pos, pos.add(0.0D, 12.0D, 0.0D));

        for (BlockPos posRange : totemBaseRange) {
            Block current = getWorld().getBlockState(posRange).getBlock();

            if(current == Blocks.AIR) {
                break;
            }

            if (current == ModBlocks.zombie_totem) {
                hasZombie = true;
            } else if (current == ModBlocks.skeleton_totem) {
                hasSkeleton = true;
            } else if (current == ModBlocks.creeper_totem) {
                hasCreeper = true;
            } else if (current == ModBlocks.spider_totem) {
                hasSpider = true;
            } else if (current == ModBlocks.enderman_totem) {
                hasEnderman = true;
            } else if (current == ModBlocks.witch_totem) {
                hasWitch = true;
            } else if (current == ModBlocks.silverfish_totem) {
                hasSilverfish = true;
            } else if (current == ModBlocks.slime_totem) {
                hasSlime = true;
            } else if (current == ModBlocks.blaze_totem) {
                hasBlaze = true;
            } else if (current == ModBlocks.zombie_pigman_totem) {
                hasZombiePigman = true;
            } else if (current == ModBlocks.ghast_totem) {
                hasGhast = true;
            } else if (current == ModBlocks.magma_cube_totem) {
                hasMagmaCube = true;
            } else if(current == new Block(Material.WOOD)) {
                hasBlaze = true;
                hasGhast = true;
                hasMagmaCube = true;
                hasZombiePigman = true;
            }
        }
    }

    /**
     * Sets all booleans for this tile to false
     */
    private void resetTotemProperties() {
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
    }

    /**
     * Retrieves all totem head stats when the tile entity is loaded
     */
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
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
        return compound;
    }

    /**
     * Saves all totem head stats when the tile entity is unloaded
     */
    @Override
    public void readFromNBT(NBTTagCompound compound) {
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
        super.readFromNBT(compound);
    }
}
