package uk.co.anttheantster.antsartifacts.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import uk.co.anttheantster.antsartifacts.AntsArtifacts;

public class Shop {

    private AntsArtifacts plugin;
    public Shop(AntsArtifacts plugin){ this.plugin = plugin; }

    public Player player;
    public int size = 0;
    public String name = "";

    public Inventory shop = Bukkit.createInventory(player, size, name);



}
