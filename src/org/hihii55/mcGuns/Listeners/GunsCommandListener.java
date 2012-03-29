package org.hihii55.mcGuns.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.hihii55.mcGuns.McGuns;

public class GunsCommandListener implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
		if (arg1.getName().equalsIgnoreCase("mcguns") || arg0.hasPermission("mcguns.help")){
			arg0.sendMessage(ChatColor.DARK_GREEN+"mcGuns-");
			arg0.sendMessage(ChatColor.AQUA+"The gun plugin for bukkit.");
			arg0.sendMessage("");
			arg0.sendMessage(ChatColor.GOLD+"More helping things at mcGuns.wikia.com");
			arg0.sendMessage("");
			arg0.sendMessage(ChatColor.BLUE+"What do you want to know? Commands:");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns info"+ChatColor.BLUE+" -Shows a small history about mcGuns");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns using"+ChatColor.BLUE+" -Info to how to use mcGuns. Watch more at "+ChatColor.GOLD+"mcGuns.wikia.com");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns weapons"+ChatColor.BLUE+" -A list and info of guns and other weapons");
			arg0.sendMessage(ChatColor.DARK_RED+"/mcguns admin"+ChatColor.DARK_PURPLE+" -Commands and functions for admins. Not for normal players!");}
			
			else if(arg1.getName().equalsIgnoreCase("mcguns admin") || arg0.hasPermission("mcguns.admin.help")){
			}//More commands coming soon...
		return true;
	}

	public void registerCommands() {
		McGuns.instance.getCommand("mcguns").setExecutor(new GunsCommandListener());
		
	}

}
