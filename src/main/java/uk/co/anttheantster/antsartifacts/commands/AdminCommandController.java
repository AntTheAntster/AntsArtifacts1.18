package uk.co.anttheantster.antsartifacts.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommandController implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("aa") || cmd.getName().equalsIgnoreCase("antsartifacts")){
            if (!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
                return false;
            }


        }
        return false;
    }
}
