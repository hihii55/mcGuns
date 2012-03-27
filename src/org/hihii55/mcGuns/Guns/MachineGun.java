package org.hihii55.mcGuns.Guns;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MachineGun extends Gun {
	
	public MachineGun(ItemStack arg2, Player owner, GunTypes arg3) {
		super(arg2, owner, arg3);
		// TODO Auto-generated constructor stub
	}

	public int hittedtimes = 0;
	public long firstTime = 0;
	public long lastTime = 0;

	@Override
	public int getMag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMag(int arg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void shoot() {
		// TODO Auto-generated method stub

	}
	


}
