package uk.co.anttheantster.antsartifacts.sql;

import org.bukkit.entity.Player;
import uk.co.anttheantster.antsartifacts.AntsArtifacts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SQLGetter {

    private AntsArtifacts plugin;

    public SQLGetter(AntsArtifacts plugin) {
        this.plugin = plugin;
    }

    public void createTable() {
        PreparedStatement ps;

        //Everything must be surrounded in Try/Catch statements in SQL Connections... I HATE MySQL.
        try {
            //Create the "constellationscoreplayers" table in the Database if it doesn't exist
            ps = plugin.SQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS antsartifactsplayers "
                    //Table will store the players Name, UUID and Time Logged Out so far.
                    + "(NAME VARCHAR(100),UUID VARCHAR(100),TIMELOGGED VARCHAR(100),FRAGMENTS INT(255), PRIMARY KEY (NAME))");
            //Similar to "#saveConfig()" SQL classes have to "#executeUpdate()" after each modification.
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createPlayer(Player player) {
        try {
            UUID uuid = player.getUniqueId();

            //If the UUID doesn't exist, create the player in the database.
            if (!exists(uuid)) {
                PreparedStatement ps2 = plugin.SQL.getConnection().prepareStatement("INSERT antsartifactsplayers"
                        + " (NAME,UUID) VALUES (?,?)");
                ps2.setString(1, player.getName());
                ps2.setString(2, uuid.toString());
                ps2.executeUpdate();

                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean exists(UUID uuid) {
        try {
            PreparedStatement ps = plugin.SQL.getConnection().prepareStatement("SELECT * FROM antsartifactsplayers WHERE UUID=?");
            ps.setString(1, uuid.toString());

            ResultSet results = ps.executeQuery();
            if (results.next()) {
                //"results.next()" meants player UUID is found
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}