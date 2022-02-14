package net.lenngi.whitelistboi;

import net.lenngi.whitelistboi.commands.DiscordCommands;
import net.lenngi.whitelistboi.commands.IGCommands;
import net.lenngi.whitelistboi.discord.DiscordBot;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


import javax.security.auth.login.LoginException;
import java.util.logging.Logger;

public class Whitelistboi extends JavaPlugin {

    Logger logger = Bukkit.getLogger();


    @Override
    public void onEnable() {
        // Plugin startup logic
        DiscordBot discordBot = new DiscordBot(this);
        logger.info(ChatColor.GREEN + "Enabled " + this.getName());
        getCommand("wlb").setExecutor(new IGCommands(this));
        getCommand("wlbdiscord").setExecutor(new DiscordCommands(discordBot));

        try {
            discordBot.startup();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info(ChatColor.RED + "Shutting down.. " + this.getName());
    }
}
