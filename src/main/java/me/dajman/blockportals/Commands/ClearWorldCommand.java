package me.worldclear.Commands;


import me.worldclear.utils.ClearAWorld;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

@CommandInfo(name = "clearworld", permission = "worldclear.clearworld", onlyPlayer = false)
public class ClearWorldCommand extends PluginCommand {
    @Override
    public void execute(Player player, String[] args) {
        if (args.length != 0){
            Bukkit.getServer().getWorlds().forEach(world -> {
                if (world.getName().equals(args[1])) {
                    if (args[2].equals("force")) {
                        if (player.hasPermission("worldclear.force")) {
                            ClearAWorld.clearWorld(player.getWorld(), true);
                            return;
                        }
                    }
                    ClearAWorld.clearWorld(player.getWorld(), false);
                }
            });
            if (args[1].equals("all")) {
                if (args[2].equals("force")) {
                    if (player.hasPermission("worldclear.force")) {
                        ClearAWorld.clearAllWorlds(true);
                        return;
                    }
                }
                ClearAWorld.clearAllWorlds(false);
            }
            else if (args[1].equals("force")) {
                if (player.hasPermission("worldclear.force")) {
                    ClearAWorld.clearWorld(player.getWorld(), true);
                    return;
                }
            }
                ClearAWorld.clearWorld(player.getWorld(), false);
        }
        ClearAWorld.clearWorld(player.getWorld());
    }
}
