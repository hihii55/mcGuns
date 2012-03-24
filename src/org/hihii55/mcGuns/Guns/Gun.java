package org.hihii55.mcGuns.Guns;

import org.bukkit.inventory.ItemStack;

public abstract class Gun {
	
	ItemStack item;
	
	
	public abstract void setMag(int arg);
	
	public abstract void shoot();
	
	public abstract int getMag();
	
	public void destroy() {
		System.gc();
	}

}
