package com.alreadydeadinside.custom_items_and_recipes_plugin.commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
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
        if(!(sender instanceof Player)){
            //TODO add description to your commands
            sender.sendMessage("Only players can use this command");
            return true;
        }
        Player player = (Player) sender;

        //heal command
        if(cmd.getName().equalsIgnoreCase("heal")){
            double maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getDefaultValue();
            player.setHealth(maxHealth);
            player.sendMessage("You have been healed!");
        }

        //feed command
        else if (cmd.getName().equalsIgnoreCase("feed")){
            player.setFoodLevel(20); //max feed value
            player.sendMessage("You have been fed!");
        }
        //farm time command (arguments)
        else if(cmd.getName().equalsIgnoreCase("farmtime")){
            if (args.length >= 2){
                try {
                    EntityType entity = EntityType.valueOf(args[0].toUpperCase());
                    int amount = Integer.parseInt(args[1]);
                    for (int i = 0; i < amount; i++){
                        player.getWorld().spawnEntity(player.getLocation(), entity);
                    }
                } catch (IllegalArgumentException e){
                    player.sendMessage("That's is not a valid entity!");
                }
                //TODO add description
            } else{
                player.sendMessage("/farmtime <mob> <amount>");
            }
        }

        return true;
    }
}
