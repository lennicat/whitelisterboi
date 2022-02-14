package net.lenngi.whitelistboi.commands;

import net.lenngi.whitelistboi.Whitelistboi;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Commands implements CommandExecutor {

    private Object NullPointerException;

    private static Whitelistboi plugin;

    public Commands(Whitelistboi instance) {

        plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                // Send help menu
            } else if (args[0].equalsIgnoreCase("help")){
                final List<String> helpLines = new ArrayList<String>();
                helpLines.add(ChatColor.GRAY + "[" +
                        ChatColor.AQUA + "WHITELIST BOI HELP!" + ChatColor.GRAY + "] ");
                helpLines.add(ChatColor.GRAY + "/wlb help" + ChatColor.RESET + " - brings up this help page!");
                helpLines.add(ChatColor.GRAY + "/wlb list" + ChatColor.RESET + " - get current users on whitelist.");
                helpLines.add(ChatColor.GRAY + "/wlb add {username}" + ChatColor.RESET + " - adds a user to the whitelist.");
                helpLines.add(ChatColor.GRAY + "/wlb remove {username}" + ChatColor.RESET + " - removes a user from the whitelist.");
                for (String i: helpLines) {
                    player.sendMessage(i);
                }
            } else if (args[0].equalsIgnoreCase("list")) {
                OfflinePlayer[] whitelisted = Bukkit.getWhitelistedPlayers().toArray(new OfflinePlayer[0]);
                List<String> whitelistedPlayers = new ArrayList<>();
                for (OfflinePlayer i : whitelisted) {
                    whitelistedPlayers.add(i.getName());
                }
                String wlpJoined = String.join(", ", whitelistedPlayers);
                player.sendMessage(ChatColor.GRAY + "[" +
                        ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                        "Currently whitelisted players: " + ChatColor.RESET + wlpJoined);
            } else if (args[0].equalsIgnoreCase("add")) {
                if (args.length < 2) {
                    player.sendMessage(ChatColor.GRAY + "[" +
                            ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                            "Please provide a valid username!");
                } else if (args[1].length() < 2) {
                    @NotNull UUID namedPlayer = Bukkit.getOfflinePlayer(args[1]).getUniqueId();
                    try {
                        OfflinePlayer finalNamedPlayer = Bukkit.getOfflinePlayer(namedPlayer);
                        if (finalNamedPlayer.isWhitelisted()) {
                            player.sendMessage(ChatColor.GRAY + "[" +
                                    ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                                    "Player " + finalNamedPlayer.getName() + " is already whitelisted!");
                        } else if (!finalNamedPlayer.isWhitelisted()) {
                            finalNamedPlayer.setWhitelisted(true);
                            player.sendMessage(ChatColor.GRAY + "[" +
                                    ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                                    "Player " + finalNamedPlayer.getName() + " has been added to the whitelist!");

                        }
                    } catch (Exception e) {
                        if (e == NullPointerException) {
                            plugin.getLogger().info("[NULL]");
                        }
                    }

                } else {
                    player.sendMessage(ChatColor.GRAY + "[" +
                            ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                            "Please provide a valid username!");
                }
            } else if (args[0].equalsIgnoreCase("remove")) {
                if (args.length < 2) {
                    player.sendMessage(ChatColor.GRAY + "[" +
                            ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                            "Please provide a valid username!");
                } else if (args[1].length() < 2) {
                    @NotNull UUID namedPlayer = Bukkit.getOfflinePlayer(args[1]).getUniqueId();
                    try {
                        OfflinePlayer finalNamedPlayer = Bukkit.getOfflinePlayer(namedPlayer);
                        if (finalNamedPlayer.isWhitelisted()) {
                            finalNamedPlayer.setWhitelisted(false);
                            player.sendMessage(ChatColor.GRAY + "[" +
                                    ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                                    "Player " + finalNamedPlayer.getName() + " has been removed from the whitelist!");
                        } else if (!finalNamedPlayer.isWhitelisted()) {
                            player.sendMessage(ChatColor.GRAY + "[" +
                                    ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                                    "Player " + finalNamedPlayer.getName() + " is not present on the whitelist!");

                        }
                    } catch (Exception e) {
                        if (e == NullPointerException) {
                            plugin.getLogger().info("[NULL]");
                        }
                    }
                } else {
                    player.sendMessage(ChatColor.GRAY + "[" +
                            ChatColor.AQUA + "WHITELIST BOI" + ChatColor.GRAY + "] " +
                            "Please provide a valid username!");
                }
            }
        }

        return true;
    }
}
