package org.hihii55.mcGuns;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import org.hihii55.mcGuns.Listeners.GunsPlayerListener;

public class McGuns extends JavaPlugin {
	final PluginDescriptionFile pdf = this.getDescription();
	private final PluginManager pm = getServer().getPluginManager();
	private final GunsPlayerListener plLis = new GunsPlayerListener();

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
