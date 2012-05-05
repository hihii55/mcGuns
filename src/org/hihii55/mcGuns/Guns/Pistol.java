package org.hihii55.mcGuns.Guns;


import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.hihii55.mcGuns.GunsActionLib;
import org.hihii55.mcGuns.projectile.Bullet;

public class Pistol extends Gun {
	
	public int hittedtimes = 0;
	public long firstTime = 0;
	public long lastTime = 0;
	public long lastShootedTime = 0;
	public long firstShootedTime = 0;
	

	private int mag;
	public static int maxMag;
	public Pistol(ItemStack arg2, Player owner, GunTypes arg3) {
		super(arg2, owner, arg3);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void shoot() {
		if(mag >= 0 && !(owner.hasPermission("mcguns.admin.infiniteammo")) && owner.hasPermission("mcguns.use.shoot.pistol."+this.type.description.toLowerCase().replace(" ", ""))){
			//Of course the pistol needs time to cool. The default value is 700 ms.(0.7 seconds)
			firstShootedTime = System.currentTimeMillis();
			if (lastShootedTime - firstShootedTime >= 700 || lastShootedTime == 0){
			mag--;
			owner.getWorld().playEffect(owner.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR, 1, 15);
			Bullet bullet = new Bullet(owner.getLocation(), 400000, 1, owner);
			owner.getLocation().setPitch(owner.getLocation().getPitch() + 0.5f);
			owner.getWorld().playEffect(owner.getLocation(), Effect.POTION_BREAK, 1, 10);
			lastShootedTime = System.currentTimeMillis();}
		else if(owner.hasPermission("mcguns.admin.infiniteammo") || owner.getGameMode() == GameMode.CREATIVE){
			firstShootedTime = System.currentTimeMillis();
			if (lastShootedTime - firstShootedTime >= 700 || lastShootedTime == 0){
			owner.getWorld().playEffect(owner.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR, 1, 10);
			GunsActionLib.physic();
			lastShootedTime = System.currentTimeMillis();}
		}
		
		else{
			owner.getWorld().playEffect(owner.getLocation(), Effect.CLICK2, 1, 5);}
			
		}

		
	}
}

