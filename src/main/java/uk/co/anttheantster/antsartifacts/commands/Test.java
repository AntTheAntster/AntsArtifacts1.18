package uk.co.anttheantster.antsartifacts.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Test implements CommandExecutor {

    public ItemStack testItem() {
        ItemStack testItems = new ItemStack(Material.STICK);
        ItemMeta testMeta = testItems.getItemMeta();

        testMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Test Item");
        testMeta.setUnbreakable(true);
        testMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        testMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        testMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        testItems.setItemMeta(testMeta);

        return testItem();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("test")){

            player.getInventory().addItem(testItem());
        }

        return false;
    }
}
