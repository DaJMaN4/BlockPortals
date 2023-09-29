package me.dajman.blockportals.commands.subCommands;

import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;

public class PortalLocationCommand {
    private final Player player;
    private final String[] args;
    private final PortalsManager portalsManager;

    public PortalLocationCommand(Player player, String[] args, PortalsManager portalsManager) {
        this.player = player;
        this.args = args;
        this.portalsManager = portalsManager;
        portalLocation();
    }

    private void portalLocation() {
        if (args.length != 2) {
            player.sendMessage("usage of the subcommand location");
            return;
        }
        if (portalsManager.isPortal(args[1])) {
            player.sendMessage("portal doesn't exists");
            return;
        }


        player.sendMessage("portal location");
    }
}
