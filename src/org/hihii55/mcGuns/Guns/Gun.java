package org.hihii55.mcGuns.Guns;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.hihii55.mcGuns.McGuns;
import org.hihii55.mcGuns.ammo.AmmoTypes;

public abstract class Gun {
	
	protected ItemStack item;
	protected GunTypes type;
	protected Player owner;
	public int hittedtimes = 0;
	public long firstTime = 0;
	public long lastTime = 0;
	protected int mag;
	public static int maxMag;
	protected AmmoTypes neededAmmo;
	
	
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
		
		if(type == GunTypes.Desert_Eagle
		  || type == GunTypes.G_18
		  || type == GunTypes.M1911
		  || type == GunTypes.MP_5
		  || type == GunTypes.UZI
		  || type == GunTypes.UMP_45)
			{neededAmmo = AmmoTypes.LIGHT;}
		else if(type == GunTypes.AK_47_Kalasnikov
				|| type == GunTypes.M16
				|| type == GunTypes.M46A1
				|| type == GunTypes.RPK
				|| type == GunTypes.RPD
				|| type == GunTypes.M240)
					{neededAmmo = AmmoTypes.MEDIUM;}
		else if(type == GunTypes.SPAS_12
				|| type == GunTypes.STAKEOUT
				|| type == GunTypes.RANGER)
			{neededAmmo = AmmoTypes.SHOTGUN_AMMO;}
		//If it is a bazooka:
		else{neededAmmo = AmmoTypes.SMALL_MISSILE;}
		
		
		}
	
	public abstract void shoot();
	
	public int getMag(){return mag;}
	public void setMag(int arg){ this.mag = arg;}
	
	public void destroy() {
		System.gc();
	}
	
	


	public void load() {
		int y = 0;
		Inventory inv = owner.getInventory();
		ItemStack con[] = inv.getContents();
		while(y >= con.length || mag >=maxMag){
			if(McGuns.hashyammo.get(con[y]) == neededAmmo);{
				if(inv.contains(con[y])){
					inv.remove(con[y]);
					mag++;
					}
				}
		
		y++;}
		if (mag <= 0)
			owner.sendMessage(ChatColor.DARK_AQUA+"You cannot load your gun, you are out of light ammo!");
		if (mag < maxMag)
			owner.sendMessage(ChatColor.DARK_AQUA+"Your cannot load your mag fully. Current mag: "+ChatColor.YELLOW+mag+"/"+maxMag);
		y = 0;
		
	}
	public GunTypes getType() {return this.type;}
	
}
