package io.github.mspacedev;

import io.github.mspacedev.items.ModItems;
import io.github.mspacedev.utils.Utils;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Copyright © MSpace-Dev 2017
 * Do not distribute without proper permission from the author.
 * https://mspace-dev.github.io
 */

public class RegisterRecipes {
    public static void register() {
        registerRecipes();
        registerSmelting();
    }

    private static void registerRecipes() {
        // Carving Tool
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.carving_tool, 1), new Object[] {"I  ", " I ", "  S", 'S', Items.STICK, 'I', ModItems.spirit_ingot} );
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.carving_tool, 1), new Object[] {"  I", " I ", "S  ", 'S', Items.STICK, 'I', ModItems.spirit_ingot} );
        // Spirit Knife
    }

    private static void registerSmelting() {
        GameRegistry.addSmelting(ModItems.spirit_powder, new ItemStack(ModItems.spirit_ingot, 1), 0.0f);
    }
}