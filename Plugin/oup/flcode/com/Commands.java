package oup.flcode.com;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

/**
 * Created by Fl Code on 2/26/2015.
 */
public class Commands implements Listener,CommandExecutor {
    Main plugin;
    public Commands(Main instance) {
        plugin = instance;
    }
    //
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player p = (Player) commandSender;

        if(command.getName().equalsIgnoreCase("McScape")){
            p.sendMessage(ChatColor.GREEN + "===============================================");
            p.sendMessage(ChatColor.AQUA + "====================McScape====================");
            p.sendMessage(ChatColor.GOLD + "McScape is a remake of RuneScape in Minecraft. ");
            p.sendMessage(ChatColor.GOLD + "Featuring full talents and professions to make ");
            p.sendMessage(ChatColor.GOLD + "Your RPG experience even more than you ever had");
            p.sendMessage(ChatColor.GOLD + "Ever thought possible.  If you want to level or");
            p.sendMessage(ChatColor.GOLD + "If you want to kill crazy bosses in dungeons.  ");
            p.sendMessage(ChatColor.GOLD + "You are guaranteed to have a fun changing adventure!");
            p.sendMessage(ChatColor.GREEN +"===============================================");
        }return false;
    }
}
