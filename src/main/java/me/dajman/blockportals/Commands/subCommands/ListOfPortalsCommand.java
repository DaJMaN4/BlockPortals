package me.dajman.blockportals.commands.subCommands;

import me.dajman.blockportals.portals.Portal;
import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;

import java.util.List;

public class ListOfPortalsCommand {
    private final Player player;
    private final String[] args;
    private final PortalsManager portalsManager;

    public ListOfPortalsCommand(Player player, String[] args, PortalsManager portalsManager) {
        this.player = player;
        this.args = args;
        this.portalsManager = portalsManager;
        listPortals();
    }

    private void listPortals() {
        if (args.length != 1) {
            player.sendMessage("usage of the command");
        }
        List<Portal> playersPortals = portalsManager.getPlayersPortals(player.getName());
        player.sendMessage("your current portals");
    }
}
