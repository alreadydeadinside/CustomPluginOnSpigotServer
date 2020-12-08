package com.alreadydeadinside.custom_items_and_recipes_plugin.events;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 *
 * @author Bohdan Vakaliuk
 * @version 08.12.2020
 *
 */

public class PluginEvents implements Listener {
    //TODO player join event (DONE)

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent joinEvent){
        Player player = joinEvent.getPlayer();
        player.sendMessage("Welcome to my overrated server! :>" + ChatColor.WHITE);
    }
    //TODO player walk on certain block type event (DONE)

    @EventHandler
    public static void onPlayerMove(PlayerMoveEvent moveEvent) {
        Player player = moveEvent.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        Material block = player.getWorld().getBlockAt(x, y-1, z).getType();

        if (block == Material.GRASS_BLOCK){
            player.sendMessage("Hey! You're walking on a grass block!" +ChatColor.LIGHT_PURPLE);
        }

    }
}
