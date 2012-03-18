package org.hihii55.mcGuns;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import org.hihii55.mcGuns.ExternalFiles.GunsAnnouncements;
import org.hihii55.mcGuns.Guns.GunTypes;

public class GunsActionLib {
	
	public static void pistolShotment(Player shooter, ItemStack item) {
		if(isGun(item))
		Pistol pi = getPistol(shooter);
		if (pi.isLoaded()){
		//This action is truly deprecated, we will fix it:
			shooter.shootArrow();}
		else{
			shooter.sendMessage(ChatColor.DARK_GREEN+GunsAnnouncements.getOutOfAmmo());
		}
		
		 public static GunTypes isGun() {
			
			
		}
	}
	

}
