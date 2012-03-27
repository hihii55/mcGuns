package org.hihii55.mcGuns.Listeners;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.hihii55.mcGuns.McGuns;

public class GunsCommandListener implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerCommands() {
		McGuns.instance.getCommand("mcguns").setExecutor(new GunsCommandListener());
		
	}

}
