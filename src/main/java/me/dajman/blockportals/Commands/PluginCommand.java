package me.dajman.blockportals.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class PluginCommand implements CommandExecutor {
    private final CommandInfo commandInfo;

    public PluginCommand() {
       commandInfo = getClass().getAnnotation(CommandInfo.class);
        Objects.requireNonNull(commandInfo, "Commands must have CommandInfo annotation");
    }

    public CommandInfo getCommandInfo() {
        return commandInfo;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!commandInfo.permission().isEmpty()) {
            if (!sender.hasPermission(commandInfo.permission()) || sender.hasPermission("voidclear.admin")) {
                sender.sendMessage("You don't have permission to use this command");
                return true;
            }
        }

        if (commandInfo.onlyPlayer()) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("This command can only be used by players");
                return true;
            }
            execute((Player) sender, args);
        }

        execute(sender, args);
        return true;
    }

    public void execute (Player player, String[] args) {}
    public void execute (CommandSender sender, String[] args) {}


}
