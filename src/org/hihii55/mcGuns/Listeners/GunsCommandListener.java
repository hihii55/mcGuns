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
import org.hihii55.mcGuns.Guns.Bazooka;
import org.hihii55.mcGuns.Guns.GunTypes;
import org.hihii55.mcGuns.Guns.MachineGun;
import org.hihii55.mcGuns.Guns.Pistol;
import org.hihii55.mcGuns.Guns.Shotgun;
import org.hihii55.mcGuns.Guns.Sniper;
import org.hihii55.mcGuns.Guns.SubMachineGun;

public class GunsCommandListener implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2,
			String[] arg3) {
	if(arg0 instanceof Player && arg3.length == 1){
		if (arg0.hasPermission("mcguns.help") && 
				!(arg3[0].contains("givegun")) 
				|| !(arg3[0].contains("info"))  
				|| !(arg3[0].contains("weapons"))  
				|| !(arg3[0].contains("admin")) 
				|| !(arg3[0].contains("seize")) 
				|| !(arg3[0].contains("disable"))
				|| !(arg3[0].contains("giveammo"))){
			arg0.sendMessage(ChatColor.DARK_GREEN+"mcGuns-");
			arg0.sendMessage(ChatColor.AQUA+"The gun plugin for bukkit.");
			arg0.sendMessage("");
			arg0.sendMessage(ChatColor.GOLD+"More helping things at mcGuns.wikia.com");
			arg0.sendMessage("");
			arg0.sendMessage(ChatColor.BLUE+"What do you want to know? Commands:");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns info"+ChatColor.BLUE+" -Shows a small history about mcGuns");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns using"+ChatColor.BLUE+" -Info to how to use mcGuns. Watch more at "+ChatColor.GOLD+"mcGuns.wikia.com");
			arg0.sendMessage(ChatColor.GRAY+"/mcguns weapons"+ChatColor.BLUE+" -A list and info of guns and other weapons");
			arg0.sendMessage(ChatColor.DARK_RED+"/mcguns admin"+ChatColor.DARK_PURPLE+" -Commands and functions for admins. Not for normal players!");
			return true;}
			
			else if(arg3[0].equalsIgnoreCase("admin") && arg0.hasPermission("mcguns.admin.adminhelp") || arg0.isOp()){
			arg0.sendMessage(ChatColor.RED+"Admin commands. Those commands are not for normal players:");
			arg0.sendMessage("");
			arg0.sendMessage(ChatColor.DARK_PURPLE+"/mcguns givegun <weapon>"+ChatColor.BLUE+" -Gives a gun/weapon. Type /mcguns weapons for weapons.");
			arg0.sendMessage(ChatColor.DARK_PURPLE+"/mcguns giveammo <weapon>"+ChatColor.BLUE+" -Gives ammo. Type /mcguns ammo for ammo types.");
			arg0.sendMessage(ChatColor.DARK_PURPLE+"/mcguns seize <player>"+ChatColor.BLUE+" -Seizes all of the guns and modern weapons from the given player.");
			arg0.sendMessage(ChatColor.DARK_RED+"/mcguns disable"+ChatColor.BLUE+" -Disables mcGuns. Be EXTRA-Careful with this, because you CAN'T enable it unless you reload or restart the server.");
			return true;
					} 

	
		else if(arg3[0].startsWith("givegun")){
			if(arg3[0].equalsIgnoreCase("givegun ak47") || arg3[0].equalsIgnoreCase("mcguns givegun ak-47") && arg0.hasPermission("mcguns.admin.givegun.assault.ak47") || arg0.isOp()){
					ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
					((Player) arg0).getInventory().addItem(item);
					McGuns.hashy.put(item, new AssaultRifle(item, ((Player)arg0), GunTypes.AK_47_Kalasnikov));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun m16") && arg0.hasPermission("mcguns.admin.givegun.assault.m16") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new AssaultRifle(item, ((Player)arg0), GunTypes.M16));
			
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun m46a1") && arg0.hasPermission("mcguns.admin.givegun.assault.m46a1") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.SPECKLED_MELON, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new AssaultRifle(item, ((Player)arg0), GunTypes.M46A1));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun deserteagle") && arg0.hasPermission("mcguns.admin.givegun.pistol.deserteagle") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Pistol(item, ((Player)arg0), GunTypes.Desert_Eagle));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun g18") && arg0.hasPermission("mcguns.admin.givegun.pistol.g18") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Pistol(item, ((Player)arg0), GunTypes.G_18));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun m1911") && arg0.hasPermission("mcguns.admin.givegun.pistol.m1911") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.IRON_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Pistol(item, ((Player)arg0), GunTypes.M1911));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun m82") || arg3[0].equalsIgnoreCase("mcguns givegun barrettm82") || arg3[0].equalsIgnoreCase("mcguns givegun barrett-m82") && arg0.hasPermission("mcguns.admin.givegun.sniper.barrettm82") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Sniper(item, ((Player)arg0), GunTypes.Barrett_M82));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun dragunov") && arg0.hasPermission("mcguns.admin.givegun.sniper.dragunov") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Sniper(item, ((Player)arg0), GunTypes.Dragunov));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun intervention") && arg0.hasPermission("mcguns.admin.givegun.sniper.intervention") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.PAPER, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Sniper(item, ((Player)arg0), GunTypes.Intervention));
			return true;}
			else if(arg3[0].equalsIgnoreCase("givegun spas12") || arg3[0].equalsIgnoreCase("givegun spas-12") && arg0.hasPermission("mcguns.admin.givegun.shotgun.spas12") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BOOK, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Shotgun(item, ((Player)arg0), GunTypes.SPAS_12));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun stakeout") && arg0.hasPermission("mcguns.admin.givegun.shotgun.stakeout") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BOOK, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Shotgun(item, ((Player)arg0), GunTypes.STAKEOUT));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun ranger") || arg3[0].equalsIgnoreCase("givegun spas-12") && arg0.hasPermission("mcguns.admin.givegun.shotgun.spas12") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BOOK, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Shotgun(item, ((Player)arg0), GunTypes.RANGER));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun rpg7") || arg3[0].equalsIgnoreCase("givegun rpg-7") && arg0.hasPermission("mcguns.admin.givegun.bazooka.rpg-7") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Bazooka(item, ((Player)arg0), GunTypes.RPG_7));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun m72law") || arg3[0].equalsIgnoreCase("givegun m72-law") || arg3[0].equalsIgnoreCase("givegun m72") && arg0.hasPermission("mcguns.admin.givegun.bazooka.m27-law") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Bazooka(item, ((Player)arg0), GunTypes.M72_LAW));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun apilas") && arg0.hasPermission("mcguns.admin.givegun.bazooka.apilas") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new Bazooka(item, ((Player)arg0), GunTypes.APILAS));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun mp5") || arg3[0].equalsIgnoreCase("givegun mp-5") && arg0.hasPermission("mcguns.admin.givegun.submachinegun.mp-5") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new SubMachineGun(item, ((Player)arg0), GunTypes.MP_5));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun uzi") && arg0.hasPermission("mcguns.admin.givegun.submachinegun.uzi") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new SubMachineGun(item, ((Player)arg0), GunTypes.UZI));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun ump45") || arg3[0].equalsIgnoreCase("givegun ump45") && arg0.hasPermission("mcguns.admin.givegun.submachinegun.ump-45") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new SubMachineGun(item, ((Player)arg0), GunTypes.UMP_45));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun rpk") && arg0.hasPermission("mcguns.admin.givegun.machinegun.rpk") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BUCKET, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new MachineGun(item, ((Player)arg0), GunTypes.RPK));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun rpd") && arg0.hasPermission("mcguns.admin.givegun.machinegun.rpd") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BUCKET, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new MachineGun(item, ((Player)arg0), GunTypes.RPD));
				return true;}
			else if(arg3[0].equalsIgnoreCase("givegun M240") && arg0.hasPermission("mcguns.admin.givegun.machinegun.m240") || arg0.isOp()){
				ItemStack item = new ItemStack(Material.BUCKET, 1);
				((Player) arg0).getInventory().addItem(item);
				McGuns.hashy.put(item, new MachineGun(item, ((Player)arg0), GunTypes.M240));
				return true;}
			
			else{
				return false;
			}
		}
		else{
			return false;
			}
					
			
			
			
				}
	else{ return false;
	}
	}	
	public static void registerCommands() {
					McGuns.instance.getCommand("mcguns").setExecutor(new GunsCommandListener());
					McGuns.instance.getCommand("gun").setExecutor(new GunsCommandListener());
					McGuns.instance.getCommand("guns").setExecutor(new GunsCommandListener());
					
				}
	
}



