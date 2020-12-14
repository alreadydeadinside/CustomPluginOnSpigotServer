package com.alreadydeadinside.custom_items_and_recipes_plugin.items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bohdan Vakaliuk
 * @version 13.12.2020
 *
 */

//TODO specified item from Minecraft list, add commands to it.
public class ItemManager {
    public static ItemStack wand;

    public static void init(){
        createWand();
    }

    private static void createWand(){
        ItemStack newItem = new ItemStack(Material.STICK, 1);
        ItemMeta itemMeta = newItem.getItemMeta();
        itemMeta.setDisplayName("Magic wand");
        List<String> lore = new ArrayList<>();
        lore.add("This powerful artifact is a relic of");
        lore.add("Minecraft's ancient history!");
        itemMeta.setLore(lore);
        itemMeta.addEnchant(Enchantment.LUCK, 100, false); //set true, if you want to enchant item to an exist lvl of enchantment in Minecraft
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS); //hiding enchantment lvl in desc
        newItem.setItemMeta(itemMeta);
        wand = newItem;

        //TODO some recipes (idk which exactly)
        //Shaped Recipe
        ShapedRecipe shapedRecipe = new ShapedRecipe(NamespacedKey.minecraft("wand"), newItem);
        shapedRecipe.shape("B  ", " S ", "  S");
        shapedRecipe.setIngredient('B', Material.BLAZE_POWDER);
        shapedRecipe.setIngredient('S', Material.STICK);
        shapedRecipe.setIngredient('S', Material.STICK);
        Bukkit.getServer().addRecipe(shapedRecipe);

        //Shapeless Recipe
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(NamespacedKey.minecraft("wand_shapeless"), newItem);
        shapelessRecipe.addIngredient(2, Material.BLAZE_POWDER);
        shapelessRecipe.addIngredient(1, Material.DIAMOND);
        Bukkit.getServer().addRecipe(shapelessRecipe);

        //Furnace Recipe
        FurnaceRecipe furnaceRecipe = new FurnaceRecipe(NamespacedKey.minecraft("wand_smelt"), newItem, Material.EMERALD, 1.0f, 10 * 20);
        Bukkit.getServer().addRecipe(furnaceRecipe);

        ShapedRecipe shapedRecipe1 = new ShapedRecipe(NamespacedKey.minecraft("lock"), newItem);
        shapedRecipe1.setIngredient('S', Material.DIAMOND);
        shapedRecipe1.setIngredient('S', Material.GOLD_INGOT);
        shapedRecipe1.setIngredient('S', Material.IRON_INGOT);

        FurnaceRecipe fr = new FurnaceRecipe(NamespacedKey.minecraft("wordpress"), newItem, Material.SPRUCE_WOOD, 23.05f, 20*50);
        Bukkit.getServer().addRecipe(fr);
    }
}
