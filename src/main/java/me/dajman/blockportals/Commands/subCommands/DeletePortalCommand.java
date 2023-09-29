package me.dajman.blockportals.commands.subCommands;

import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;

public class DeletePortalCommand {
    private final Player player;
    private final String[] args;
    private final PortalsManager portalsManager;

    public DeletePortalCommand(Player player, String[] args, PortalsManager portalsManager) {
        this.player = player;
        this.args = args;
        this.portalsManager = portalsManager;
        deletePortal();
    }

    private void deletePortal() {
        if (args.length > 2) {
            player.sendMessage("usage of the command");
            return;
        }
        if (portalsManager.isPortal(args[1])) {
            player.sendMessage("portal doesn't exists");
            return;
        }

        portalsManager.deletePortal(args[1]);
        player.sendMessage("portal has been deleted");
    }
}
