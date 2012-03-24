package org.hihii55.mcGuns.ExternalFiles;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.hihii55.mcGuns.McGuns;

public abstract class AbstractExternal {

	File datafolder;
	protected final McGuns plugin;
	protected static File configfile;
	protected static File dataFolder;
	protected static FileConfiguration config;
	
	public AbstractExternal(McGuns plugi, String filename) {
		
		this.plugin = plugi;
		datafolder = plugin.getDataFolder();
		configfile = new File(datafolder, File.separator + filename);
		
		
	}
	
	protected abstract void load();
	
	private static void saveConfig() {
		try {
            config.save(configfile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
	protected abstract void loadKeys();
}
