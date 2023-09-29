package me.dajman.blockportals.listeners;


import me.dajman.blockportals.portals.Portal;
import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventOnPlayerInteract implements Listener {

    private final PortalsManager portalsManager;

    public EventOnPlayerInteract(PortalsManager portalsManager) {
        this.portalsManager = portalsManager;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.getClickedBlock().hasMetadata("BP-Portal")) {
            return;
        }

        if (!event.getPlayer().getInventory().getItemInMainHand().getType().isBlock()) {
            if (event.getPlayer().isSneaking()) {
                return;
            }
        }
        event.setCancelled(true);
        Portal portal = portalsManager.getPortal(event.getClickedBlock().getMetadata("BP-Portal").get(0).asString());

        if (portal.isPortalDone()) {
            portal.teleportPlayer(event.getPlayer(), event.getClickedBlock().getLocation());
        } else {
            if (portal.getOwner().equals(event.getPlayer().getName())) {
                if (portalsManager.getPlayersCreatingPortals().containsKey(event.getPlayer().getName())) {
                    portalsManager.setLocationPortal(event.getClickedBlock().getLocation(), event.getPlayer().getName());
                    return;
                }
            }
            event.getPlayer().sendMessage("Portal is not done");
        }

    }


}
