package uk.co.anttheantster.antsartifacts.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import uk.co.anttheantster.antsartifacts.AntsArtifacts;

public class ArtifactsShop implements CommandExecutor {

    private AntsArtifacts plugin;
    public ArtifactsShop(AntsArtifacts plugin){ this.plugin = plugin; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("as") || cmd.getName().equalsIgnoreCase("artifactsshop")){
            if (!(sender instanceof Player)){
                sender.sendMessage(ChatColor.RED + "You must be a player to do this!");
                return false;
            }

            Player player = (Player) sender;
            Inventory shop = Bukkit.createInventory(player, 9, ChatColor.GOLD + "Artifacts Shop");
            player.openInventory(shop);
        }

        return false;
    }
}
