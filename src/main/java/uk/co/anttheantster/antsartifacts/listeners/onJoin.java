package uk.co.anttheantster.antsartifacts.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import uk.co.anttheantster.antsartifacts.AntsArtifacts;

public class onJoin implements Listener {

    private AntsArtifacts plugin;

    public onJoin(AntsArtifacts plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void playerJoin(PlayerJoinEvent e) {

        if (plugin.SQL.isConnected()) {
            if (!plugin.data.exists(e.getPlayer().getUniqueId())) {
                Player player = e.getPlayer();
                plugin.data.createPlayer(player);
            }
        }

        Player player = e.getPlayer();

        if (player.isOp()){
            player.sendMessage(plugin.prefix + " v" + plugin.pdfFile.getVersion());
            player.sendMessage(ChatColor.AQUA + "For support, Message me on Discord or join my discord and make a ticket.");
        }
    }
}
