package org.hihii55.mcGuns;

import java.util.HashMap;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import org.hihii55.mcGuns.ExternalFiles.AbstractExternal;
import org.hihii55.mcGuns.ExternalFiles.GunsAnnouncements;
import org.hihii55.mcGuns.Guns.Gun;
import org.hihii55.mcGuns.Listeners.GunsPlayerListener;
import org.hihii55.mcGuns.ammo.AmmoTypes;

public class McGuns extends JavaPlugin {
	public static final HashMap <ItemStack, Gun> hashy = new HashMap<ItemStack, Gun>();
	public static final HashMap <ItemStack, AmmoTypes> hashyammo = new HashMap<ItemStack, AmmoTypes>();
	final PluginDescriptionFile pdf = this.getDescription();
	final PluginManager pm = getServer().getPluginManager();
	final GunsPlayerListener plLis = new GunsPlayerListener();
	public final AbstractExternal annou = new GunsAnnouncements(this);

	@Override
	public void onEnable() {
		System.out.println("[mcGuns] Enabled, version "+pdf.getDescription()+" by: "+pdf.getAuthors());
		System.out.println("[mcGuns] Loading files...");
		
		this.register();
	}
	
	private void register() {
	pm.registerEvents(plLis, this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[mcGuns] Disabled. Version "+pdf.getDescription()+" by: "+pdf.getAuthors());
	}
	

	
}
