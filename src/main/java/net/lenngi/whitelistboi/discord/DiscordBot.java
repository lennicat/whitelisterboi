package net.lenngi.whitelistboi.discord;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Channel;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.lenngi.whitelistboi.Whitelistboi;
import org.bukkit.configuration.file.FileConfiguration;

import javax.security.auth.login.LoginException;

public class DiscordBot {
    private static Whitelistboi plugin;

    private JDA jda;

    public DiscordBot (Whitelistboi plugin) {
        DiscordBot.plugin = plugin;
    }

    public void startup() throws LoginException, InterruptedException{
        final FileConfiguration config = plugin.getConfig();
        final String token = config.getString("DiscordToken");

        if (token == null) {
            System.out.println("Please check config!");
        } else {
            jda = JDABuilder.createDefault(token)
                    .enableCache(CacheFlag.EMOTE)
                    .disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE)
                    .setContextEnabled(false)
                    .build()
                    .awaitReady();
        }

    }

    public void sendMessage() {
        System.out.print("sent");
        TextChannel testing = jda.getTextChannelById("901623140550074411");
        testing.sendMessage("beep").queue();
    }
}
