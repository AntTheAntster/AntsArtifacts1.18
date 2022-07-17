package uk.co.anttheantster.antsartifacts;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import uk.co.anttheantster.antsartifacts.commands.ArtifactsShop;
import uk.co.anttheantster.antsartifacts.commands.Test;
import uk.co.anttheantster.antsartifacts.listeners.onJoin;
import uk.co.anttheantster.antsartifacts.sql.MySQL;
import uk.co.anttheantster.antsartifacts.sql.SQLGetter;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class AntsArtifacts extends JavaPlugin {

    public MySQL SQL;
    public SQLGetter data;

    public String prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("Messages.Prefix"));
    public PluginDescriptionFile pdfFile = getDescription();

    private PluginManager pm = Bukkit.getPluginManager();

    @Override
    public void onEnable() {
        setup();
    }

    private void setup(){
        getLogger().info("[AntsArtifacts] - Made by AntTheAntster");

        saveDefaultConfig();

        //setupSQL();

        registerCommandsAndListeners();
    }

    public void registerCommandsAndListeners(){
        getCommand("as").setExecutor(new ArtifactsShop(this));
        getCommand("test").setExecutor(new Test());

        pm.registerEvents(new onJoin(this), this);
    }

    /*
    //Initialize new SQL Connection and try to connect to it
    private void setupSQL() {
        this.SQL = new MySQL(this);
        this.data = new SQLGetter(this);

        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            //e.printStackTrace();
        }

        if (SQL.isConnected()) {
            Bukkit.getLogger().info("[ConstellationsCore] Database is connected!");
            data.createTable();
        } else {
            Bukkit.getLogger().info("[ConstellationsCore] No Database Connected! Please check the details in the Config.yml!");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
     */
}
