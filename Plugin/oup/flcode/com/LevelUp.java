package oup.flcode.com;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Created by Fl Code on 2/28/2015.
 */
public class LevelUp {
    Main plugin;

    public LevelUp(Main instance) {
        plugin = instance;
    }

    Player p = (Player) Bukkit.getOnlinePlayers();

    int miningexp = plugin.getConfig().getInt(p.getUniqueId() + "Skills.Mining.level.experience");

    public int getMiningexp() {
        if (getMiningexp() == 10) {
            plugin.getConfig().set(p.getUniqueId() + "Skills.Mining.level.level", 1);
            plugin.saveConfig();
            p.sendMessage("Level Up Congratulations.");
        }
        return miningexp;
    }
}



