package me.dajman.blockportals.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventOnPlayerInteract {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if (event.getClickedBlock().hasMetadata("portal")) {

        }
    }
}
