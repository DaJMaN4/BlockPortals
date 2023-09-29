package me.dajman.blockportals.commands.subCommands;

import me.dajman.blockportals.commands.BlockPortalCommand;
import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;


public class CreatePortalCommand extends BlockPortalCommand {
    private final Player player;
    private final String[] args;
    private final PortalsManager portalsManager;

    public CreatePortalCommand(Player player, String[] args, PortalsManager portalsManager) {
        this.player = player;
        this.args = args;
        this.portalsManager = portalsManager;
        createPortal();
    }

    private void createPortal() {
        if (args.length != 2) {
            player.sendMessage("usage of the command");
            return;
        }
        if (portalsManager.isPortal(args[1])) {
            player.sendMessage("portal already exists");
            return;
        }
        portalsManager.createPortal(args[1], args[1]);
        player.sendMessage("Creating a portal");
    }

}
