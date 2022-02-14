package net.lenngi.whitelistboi.commands;

import net.dv8tion.jda.api.JDA;
import net.lenngi.whitelistboi.discord.DiscordBot;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiscordCommands implements CommandExecutor {

    private static DiscordBot bot;

    public DiscordCommands (DiscordBot bot) {
        DiscordCommands.bot = bot;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender instanceof Player) {
            if (args[0].equalsIgnoreCase("test")) {
                bot.sendMessage();
            }
        }
        return true;
    }
}
