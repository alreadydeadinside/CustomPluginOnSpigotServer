package com.alreadydeadinside.custom_items_and_recipes_plugin.items;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
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
    }
}
