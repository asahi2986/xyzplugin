package com.example.xyzplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class XYZPlugin extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("XYZPlugin has been enabled.");
        getCommand("xyz").setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("XYZPlugin has been disabled.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("xyz")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                double x = player.getLocation().getX();
                double y = player.getLocation().getY();
                double z = player.getLocation().getZ();

                String message = String.format("%s's XYZ: X=%.2f, Y=%.2f, Z=%.2f",
                        player.getName(), x, y, z);
                getServer().broadcastMessage(message);
            }
            return true;
        }
        return false;
    }
}
