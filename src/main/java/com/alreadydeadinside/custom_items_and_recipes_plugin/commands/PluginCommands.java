package com.alreadydeadinside.custom_items_and_recipes_plugin.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author Bohdan Vakaliuk
 * @version 09.12.2020
 *
 */

public class PluginCommands implements CommandExecutor {
    //TODO common commands in chat for our plugin
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){ return true; }
        Player player = (Player) sender;

        //heal command
        if(cmd.getName().equalsIgnoreCase("heal")){
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            return true;
        }

        //feed command
        if (cmd.getName().equalsIgnoreCase("feed")){
            player.setFoodLevel(20); //max feed value
        }

        return true;
    }
}
