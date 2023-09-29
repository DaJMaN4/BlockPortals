package me.dajman.blockportals.commands.adminSubcommands;

import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.entity.Player;

public class FindOwnerCommand {
    private final Player player;
    private final String[] args;
    private final PortalsManager portalsManager;

    public FindOwnerCommand(Player player, String[] args, PortalsManager portalsManager) {
        this.player = player;
        this.args = args;
        this.portalsManager = portalsManager;
    }
}
