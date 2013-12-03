package com.gmail.firework4lj;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		getConfig().options().copyDefaults();
		getLogger().info("Plugin enabled!");
	}
	
	@Override
	public void onDisable(){
		getLogger().info("Plugin disabled!");
	}
	
	public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setwarp")){
			getConfig().set("location.world", p.getLocation().getWorld().getName());
			getConfig().set("location.warpx", p.getLocation().getX());
			getConfig().set("location.warpy", p.getLocation().getY());
			getConfig().set("location.warpz", p.getLocation().getZ());
			p.sendMessage(ChatColor.GOLD+"Warp sucessfully set!");
		}else if(cmd.getName().equalsIgnoreCase("warp")){
			Location warp = new Location(Bukkit.getServer().getWorld(getConfig().getString("location.world")), getConfig().getDouble("location.warpx"), getConfig().getDouble("location.warpy"), getConfig().getDouble("location.warpz"));
		p.teleport(warp);
		p.sendMessage(ChatColor.GRAY+"Teleporting...");
		
		}else if(cmd.getName().equalsIgnoreCase("delwarp")){
			getConfig().set("location.world", null);
			getConfig().set("location.warpx", null);
			getConfig().set("location.warpy", null);
			getConfig().set("location.warpz", null);
			p.sendMessage(ChatColor.GOLD+"Warp sucessfully deleted!");
		}
		return false;
	}
	
}
