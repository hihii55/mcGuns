package org.hihii55.mcGuns.Guns;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.hihii55.mcGuns.McGuns;

public abstract class Gun {
	
	protected ItemStack item;
	protected boolean pulled;
	protected int pulledTimes;
	protected GunTypes type;
	protected int mag;
	protected Player owner;
	
	
	public Gun(ItemStack arg2, Player owner, GunTypes arg3){
		this.item = arg2;
		this.type = arg3;
		this.owner = owner;
		McGuns.hashy.put(item, this);
		String prestring = ChatColor.AQUA+"Crafted "+ChatColor.DARK_GREEN;
		switch(type){
		
		case AK_47_Kalasnikov:
			owner.sendMessage(prestring+"AK-47 Kalasnikov"+ChatColor.AQUA+"-assault rifle.");
			break;
		
		case M16:
			owner.sendMessage(prestring+"M16"+ChatColor.AQUA+"-assault rifle.");
			break;
		
		case M46A1:
			owner.sendMessage(prestring+"M4"+ChatColor.AQUA+"-assault rifle.");
			break;}
		
		
		
	}
	
	public abstract void shoot();
	
	public int getMag(){return mag;}
	public void setMag(int arg){ this.mag = arg;}
	
	public void destroy() {
		System.gc();
	}
	
	public int getPulledTimes(){return this.pulledTimes;}
	public void setPulledTimes(int arg){this.pulledTimes = arg;}
	public boolean getPulled() {return pulled;}
	public void setPulled(boolean arg) {this.pulled = arg;}
	public GunTypes getType() {return this.type;}

}
