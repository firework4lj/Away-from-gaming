package com.gmail.firework4lj;

 // Imports all needed classes from the bukkit API in your workspace.
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

// Defines the class. 

public class Main extends JavaPlugin{

	// Enable method which creates and saves the config as well as sends a message to the console that the plugin is enabled.
	@Override
	public void onEnable(){
		getConfig().options().copyDefaults();
		getLogger().info("Plugin enabled!");
	}
	// Disable method to simple send as message to the console that the plugin has been disabled.
	@Override
	public void onDisable(){
		getLogger().info("Plugin disabled!");
	}
	// Command method that sets up for handling the commands inside it.
	public boolean onCommand(final CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("setwarp")){
			// Gets the players location and saves it to the config.
			getConfig().set("location.world", p.getLocation().getWorld().getName());
			getConfig().set("location.warpx", p.getLocation().getX());
			getConfig().set("location.warpy", p.getLocation().getY());
			getConfig().set("location.warpz", p.getLocation().getZ());
			// Sends the player a message to confirm the command being run.
			p.sendMessage(ChatColor.GOLD+"Warp sucessfully set!");
		}else if(cmd.getName().equalsIgnoreCase("warp")){
			// Gets the location data from the first warp and sets it as a "Location" named "warp".
			Location warp = new Location(Bukkit.getServer().getWorld(getConfig().getString("location.world")), getConfig().getDouble("location.warpx"), getConfig().getDouble("location.warpy"), getConfig().getDouble("location.warpz"));
			// Teleports the player to location "warp" set above.
		p.teleport(warp);
		        // Sends the player a message to confirm the command being run.
		p.sendMessage(ChatColor.GRAY+"Teleporting...");
		
		}else if(cmd.getName().equalsIgnoreCase("delwarp")){
			// Sets all the location data in the config as "null", which removes all other data and makes the warp invalid.
			getConfig().set("location.world", null);
			getConfig().set("location.warpx", null);
			getConfig().set("location.warpy", null);
			getConfig().set("location.warpz", null);
			// Sends the play a message to confirm the command being run.
			p.sendMessage(ChatColor.GOLD+"Warp sucessfully deleted!");
		}
		return false;
	}
	
}
