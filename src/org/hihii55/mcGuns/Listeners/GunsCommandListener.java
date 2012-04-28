package org.hihii55.mcGuns.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.hihii55.mcGuns.McGuns;
import org.hihii55.mcGuns.Guns.AssaultRifle;
import org.hihii55.mcGuns.Guns.GunTypes;
import org.hihii55.mcGuns.Guns.Pistol;
import org.hihii55.mcGuns.Guns.Sniper;

public class GunsCommandListener implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
	if(arg0 instanceof Player && arg3.length == 1){
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

	
		else if(arg3[0].startsWith("givegun")){
			if(arg3[0].equalsIgnoreCase("mcguns givegun ak47") || arg3[0].equalsIgnoreCase("mcguns givegun ak-47") && arg0.hasPermission("mcguns.admin.givegun.assault.ak47")){
					ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
					((Player) arg0).getInventory().addItem(item);
					McGuns.hashy.put(new AssaultRifle(item, ((Player)arg0), GunTypes.AK_47_Kalasnikov), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun m16") && arg0.hasPermission("mcguns.admin.givegun.assault.m16")){
				ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new AssaultRifle(item, ((Player)arg0), GunTypes.M16), item);
			
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun m46a1") && arg0.hasPermission("mcguns.admin.givegun.assault.m46a1")){
				ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new AssaultRifle(item, ((Player)arg0), GunTypes.M46A1), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun deserteagle") && arg0.hasPermission("mcguns.admin.givegun.pistol.deserteagle")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Pistol(item, ((Player)arg0), GunTypes.Desert_Eagle), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun g18") && arg0.hasPermission("mcguns.admin.givegun.pistol.g18")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Pistol(item, ((Player)arg0), GunTypes.G_18), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun m1911") && arg0.hasPermission("mcguns.admin.givegun.pistol.m1911")){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Pistol(item, ((Player)arg0), GunTypes.M1911), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun m82") || arg3[0].equalsIgnoreCase("mcguns givegun barrettm82") || arg3[0].equalsIgnoreCase("mcguns givegun barrett-m82") && arg0.hasPermission("mcguns.admin.givegun.sniper.barrettm82")){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Sniper(item, ((Player)arg0), GunTypes.Barrett_M82), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun dragunov") && arg0.hasPermission("mcguns.admin.givegun.sniper.dragunov")){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Sniper(item, ((Player)arg0), GunTypes.Dragunov), item);
			}
			if(arg3[0].equalsIgnoreCase("mcguns givegun m82") && arg0.hasPermission("mcguns.admin.givegun.sniper.intervention")){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(new Sniper(item, ((Player)arg0), GunTypes.Intervention), item);
			}
		}
					
			
			
			
				}return true;}	
	public void registerCommands() {
					McGuns.instance.getCommand("mcguns").setExecutor(new GunsCommandListener());
					
				}
	
}



