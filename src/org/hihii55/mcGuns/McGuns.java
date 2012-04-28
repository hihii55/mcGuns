package org.hihii55.mcGuns;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import org.hihii55.mcGuns.ExternalFiles.AbstractExternal;
import org.hihii55.mcGuns.ExternalFiles.GunsAnnouncements;
import org.hihii55.mcGuns.Guns.Gun;
import org.hihii55.mcGuns.Listeners.GunsCommandListener;
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
	public static McGuns instance;
	final PluginDescriptionFile pdf = this.getDescription();
	public final Server s = getServer();
	final PluginManager pm = getServer().getPluginManager();
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
		on = true;
		System.out.println("[mcGuns] Enabled, version "+pdf.getDescription()+" by: "+pdf.getAuthors());
		System.out.println("[mcGuns] Loading files...");
		BukkitScheduler scheduler = getServer().getScheduler();
		scheduler.callSyncMethod(this, new GunClock());
		
		this.register();
	}
	
	
	/**
	 * Registers the events and commands
	 */
	private void register() {
	pm.registerEvents(new GunsPlayerListener(), this);
	GunsCommandListener commands = new GunsCommandListener();
	commands.registerCommands();
	}
	
	/**
	 * Called when the plugin disables
	 */
	@Override
	public void onDisable() {
		on = false;
		System.out.println("[mcGuns] Disabled. Version "+pdf.getDescription()+" by: "+pdf.getAuthors());
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
