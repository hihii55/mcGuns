package org.hihii55.mcGuns;

import java.util.HashMap;

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

public class McGuns extends JavaPlugin {
	public static final HashMap <ItemStack, Gun> hashy = new HashMap<ItemStack, Gun>();
	public static final HashMap <ItemStack, AmmoTypes> hashyammo = new HashMap<ItemStack, AmmoTypes>();
	public static final HashMap <Gun, ItemStack> hashy2 = new HashMap<Gun, ItemStack>();
	public static final HashMap <AmmoTypes, ItemStack> hashyammo2 = new HashMap<AmmoTypes, ItemStack>();
	public static McGuns instance;
	final PluginDescriptionFile pdf = this.getDescription();
	final PluginManager pm = getServer().getPluginManager();

	@Override
	public void onEnable() {
		System.out.println("[mcGuns] Enabled, version "+pdf.getDescription()+" by: "+pdf.getAuthors());
		System.out.println("[mcGuns] Loading files...");
		BukkitScheduler scheduler = getServer().getScheduler();
		
		this.register();
	}
	
	private void register() {
	pm.registerEvents(new GunsPlayerListener(), this);
	GunsCommandListener commands = new GunsCommandListener();
	commands.registerCommands();
	}
	
	@Override
	public void onDisable() {
		System.out.println("[mcGuns] Disabled. Version "+pdf.getDescription()+" by: "+pdf.getAuthors());
	}
	
	

	
}
