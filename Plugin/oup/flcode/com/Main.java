package oup.flcode.com;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Created by Fl Code on 2/26/2015.
 */
public class Main extends JavaPlugin {
    private static Plugin plugin;
    public static Plugin getPlugin() {
        return plugin;
    }

    //
    @Override
    public void onEnable() {
        plugin = this;
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new Commands(this), this);
        pm.registerEvents(new Mining(this), this);

        getCommand("Mining").setExecutor(new Mining(this));
        getCommand("McScape").setExecutor(new Commands(this));

        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "McScape Core Enabled");
        super.onEnable();

        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();

    }

    @Override
    public void onDisable() {
        plugin = null;//To stop memory leeks
        this.getServer().getConsoleSender().sendMessage(ChatColor.RED + "McScape Core Disabled");
        super.onDisable();
    }


}
