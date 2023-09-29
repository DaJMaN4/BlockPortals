package me.dajman.blockportals.commands;

import me.dajman.blockportals.BlockPortals;
import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class AdminBlockPortalCommand {

    private final PortalsManager portalsManager;

    public AdminBlockPortalCommand() {
        portalsManager = BlockPortals.getInstance().getPortalManager();
    }


    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!label.equalsIgnoreCase("adminblockportal") && !label.equalsIgnoreCase("abp"))
            return true;

        if (!sender.hasPermission("blockportals.admin")) {
            sender.sendMessage("no permission");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("usage of the command");
            return true;
        }

        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("reload")) {
            if (player.hasPermission("blockportals.admin.reload")) {
                BlockPortals.getInstance().reloadConfig();
                sender.sendMessage("config reloaded");
            } else {
                sender.sendMessage("no permission");
            }
        }


        return true;
    }
}
