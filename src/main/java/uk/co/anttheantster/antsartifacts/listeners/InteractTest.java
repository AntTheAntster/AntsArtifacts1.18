package uk.co.anttheantster.antsartifacts.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import uk.co.anttheantster.antsartifacts.AntsArtifacts;
import uk.co.anttheantster.antsartifacts.commands.Test;

public class InteractTest implements Listener {

    private AntsArtifacts plugin;
    private Test test;
    public InteractTest(AntsArtifacts plugin, Test test){
        this.plugin = plugin;
        this.test = test;
    }

    @EventHandler
    public void rightClick(PlayerInteractEvent e){

        if (e.getAction().equals(Action.RIGHT_CLICK_AIR)){
            if (e.getPlayer().getItemInUse().equals(test.testItem())){

            }
        }

    }

}
