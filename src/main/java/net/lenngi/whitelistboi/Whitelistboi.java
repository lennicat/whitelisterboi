package net.lenngi.whitelistboi;

import net.lenngi.whitelistboi.commands.Commands;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Whitelistboi extends JavaPlugin {

    Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info(ChatColor.GREEN + "Enabled " + this.getName());
        getCommand("wlb").setExecutor(new Commands(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info(ChatColor.RED + "Shutting down.. " + this.getName());
    }
}
