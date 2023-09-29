package me.dajman.blockportals.commands;

import me.dajman.blockportals.BlockPortals;
import me.dajman.blockportals.commands.subCommands.CreatePortalCommand;
import me.dajman.blockportals.commands.subCommands.DeletePortalCommand;
import me.dajman.blockportals.commands.subCommands.ListOfPortalsCommand;
import me.dajman.blockportals.portals.PortalsManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BlockPortalCommand {

    private final PortalsManager portalsManager;

    public BlockPortalCommand() {
        portalsManager = BlockPortals.getInstance().getPortalManager();
    }


    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!label.equalsIgnoreCase("blockportal"))
            return true;

        if (!sender.hasPermission("blockportals.command")) {
            sender.sendMessage("no permission");
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage("usage of the command");
            return true;
        }

        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("create")) {
            if (player.hasPermission("blockportals.command.create")) {
                CreatePortalCommand createPortalCommand = new CreatePortalCommand(player, args, portalsManager);
            } else {
                sender.sendMessage("no permission");
            }

        }


        if (args[0].equalsIgnoreCase("delete")) {
            if (player.hasPermission("blockportals.command.delete")) {
                DeletePortalCommand deletePortalCommand = new DeletePortalCommand(player, args, portalsManager);
            } else {
                sender.sendMessage("no permission");
            }
        }


        if (args[0].equalsIgnoreCase("list")) {
            if (player.hasPermission("blockportals.command.list")) {
                ListOfPortalsCommand listOfPortalsCommand = new ListOfPortalsCommand(player, args, portalsManager);
            } else {
                sender.sendMessage("no permission");
            }
        }


        if (args[0].equalsIgnoreCase("location")) {

            ListOfPortalsCommand listOfPortalsCommand = new ListOfPortalsCommand(player, args, portalsManager);
        }


        return true;
    }

}
