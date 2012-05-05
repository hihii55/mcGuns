package org.hihii55.mcGuns;

import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import org.hihii55.mcGuns.ExternalFiles.AbstractExternal;
import org.hihii55.mcGuns.ExternalFiles.GunsAnnouncements;
import org.hihii55.mcGuns.Guns.Gun;
import org.hihii55.mcGuns.Listeners.GunsCommandListener;
import org.hihii55.mcGuns.Listeners.GunsPlayerInventoryWatcher;
import org.hihii55.mcGuns.Listeners.GunsPlayerListener;
import org.hihii55.mcGuns.ammo.AmmoTypes;

/**
 * The main class of mcGuns
 * 
 * @author hihii55
 *
 */
public class McGuns extends JavaPlugin {
	/**
	 * A general <tt>HashMap</tt> of guns and ammos.
	 */
	public static final HashMap hashy = new HashMap();
	/**
	 * A <tt>HashMap</tt> for the item type changing statement
	 */
	public static final HashMap <ItemStack, Material> itemDataBase = new HashMap<ItemStack, Material>();
	public static final HashMap <Player, GunsPlayerInventoryWatcher> playerWatches = new HashMap<Player, GunsPlayerInventoryWatcher>();
	public static McGuns instance;
	public final PluginDescriptionFile pdf = getDescription();
	public final Server s = getServer();
	public final Logger logger = Bukkit.getLogger();
	final PluginManager pm = Bukkit.getPluginManager();
	/**
	 * The is-the-server-on variable
	 */
	private boolean on;


	/**
	 * Called when this plugin enables
	 * 
	 * 
	 */
	@Override
	public void onEnable() {
		logger.info("[mcGuns] Enabled, version 0.1 by: hihii55");
		logger.info("[mcGuns] Loading files...");
		Player[] players = getServer().getOnlinePlayers();
		if(players.length >= 1){
		for(int i = 0; i >= players.length; i++){
			if(players[i].hasPermission("mcguns.use.holding")) {
			 GunsPlayerInventoryWatcher watcher = new GunsPlayerInventoryWatcher(players[i]);
			 pm.registerEvents(new GunsPlayerListener(), this);
			 GunsCommandListener.registerCommands();
			playerWatches.put(players[i], watcher);
			watcher.start();}
			
		}
		
	}
	}
	
	/**
	 * Called when the plugin disables
	 */
	@Override
	public void onDisable() {
		logger.info("[mcGuns] Disabled. Version 0.1 by: hihii55");
	}

	
	/**
	 * Is the server on?
	 * 
	 * @return boolean value, that is mcGuns enabled
	 */
	public boolean isOn(){
		
		return on;
	}

	
	
	

	
}
