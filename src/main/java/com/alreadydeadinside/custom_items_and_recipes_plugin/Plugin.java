package com.alreadydeadinside.custom_items_and_recipes_plugin;

import com.alreadydeadinside.custom_items_and_recipes_plugin.commands.PluginCommands;
import com.alreadydeadinside.custom_items_and_recipes_plugin.events.PluginEvents;
import com.alreadydeadinside.custom_items_and_recipes_plugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bohdan Vakaliuk
 * @version 08.12.2020
 *
 */

public class Plugin extends JavaPlugin {
    //TODO methods, that will notify user in console about enabling/disabling server (DONE)

    @Override
    public void onEnable(){
        PluginCommands pluginCommands = new PluginCommands();
        getCommand("heal").setExecutor(pluginCommands);
        getCommand("feed").setExecutor(pluginCommands);
        getCommand("farmtime").setExecutor(pluginCommands);
        getServer().getPluginManager().registerEvents(new PluginEvents(), this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[CustomItemsAndRecipesPlugin] Plugin is Enabled!");

        ItemManager.init();
        getCommand("wand").setExecutor(pluginCommands);
    }
    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[CustomItemsAndRecipesPlugin] Plugin is Disabled!");
    }

}
