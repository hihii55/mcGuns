package org.hihii55.mcGuns.Guns;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AssaultRifle extends Gun {
	
	public AssaultRifle(ItemStack arg2, Player owner, GunTypes arg3) {
		super(arg2, owner, arg3);
		// TODO Auto-generated constructor stub
	}

	public int hittedtimes = 0;
	public long firstTime = 0;
	public long lastTime = 0;

	private int mag;
	static public int maxMag; 
	
	@Override
	public int getMag() {
		// TODO Auto-generated method stub
		return mag;
	}

	@Override
	public void setMag(int arg) {

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}
	


}
