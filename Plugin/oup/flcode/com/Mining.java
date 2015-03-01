package oup.flcode.com;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;

/**
 * Created by Fl Code on 2/28/2015.
 */
public class Mining implements CommandExecutor, Listener {
    Main plugin;
    public Mining(Main instance) {
        plugin = instance;
    }



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equalsIgnoreCase("Mining")){
            Player p = (Player) commandSender;
            p.sendMessage("Your mining level is " + plugin.getConfig().getInt(p.getUniqueId() + "Skills.Mining.level"));
        }

        return false;
    }
    @EventHandler
    public void onPlayerBlockBreakEvent(BlockBreakEvent bbe){
        Player p = (Player) bbe.getPlayer();
        Block broke = bbe.getBlock();
        if(broke.getType() == Material.IRON_ORE){
            int ironexp = 5;
            int current = plugin.getConfig().getInt(p.getUniqueId() + "Skills.Mining.level.experience");
            p.sendMessage("Debugger: Mined Iron Ore");
            plugin.getConfig().set(p.getUniqueId() + "Skills.Mining.level.experience", current + ironexp);
            plugin.saveConfig();
        }if(broke.getType() == Material.STONE){
            p.sendMessage("Debugger: Mined Stone Block");
            int stoneexp = 1;
            int current = plugin.getConfig().getInt(p.getUniqueId() + "Skills.Mining.level.experience");
            plugin.getConfig().set(p.getUniqueId() + "Skills.Mining.level.experience", current + stoneexp);
            plugin.saveConfig();
        }



    }



}
