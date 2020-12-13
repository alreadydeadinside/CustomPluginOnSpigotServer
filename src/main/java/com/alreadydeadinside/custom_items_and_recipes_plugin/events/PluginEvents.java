package com.alreadydeadinside.custom_items_and_recipes_plugin.events;


import com.alreadydeadinside.custom_items_and_recipes_plugin.items.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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

    //TODO explosion animation on right click
    @EventHandler
    public static void explosionOnRightClick(PlayerInteractEvent playerInteractEvent){
        if(playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(playerInteractEvent.getItem() != null){
                if(playerInteractEvent.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())){ //use case, when we have wand
                    Player player = playerInteractEvent.getPlayer();
                    player.getWorld().createExplosion(player.getLocation(), 2.0f);
                    player.sendMessage("You've just exploded!");
                }
            }
        }

    }
}
