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
		
		if(this.type == GunTypes.Desert_Eagle
		  || this.type == GunTypes.G_18
		  || this.type == GunTypes.M1911
		  || this.type == GunTypes.MP_5
		  || this.type == GunTypes.UZI
		  || this.type == GunTypes.UMP_45)
			{this.neededAmmo = AmmoTypes.LIGHT;}
		else if(this.type == GunTypes.AK_47_Kalasnikov
				|| this.type == GunTypes.M16
				|| this.type == GunTypes.M46A1
				|| this.type == GunTypes.RPK
				|| this.type == GunTypes.RPD
				|| this.type == GunTypes.M240)
					{neededAmmo = AmmoTypes.MEDIUM;}
		else if(this.type == GunTypes.SPAS_12
				|| this.type == GunTypes.STAKEOUT
				|| this.type == GunTypes.RANGER)
			{this.neededAmmo = AmmoTypes.SHOTGUN_AMMO;}
		//If it is a bazooka:
		else{this.neededAmmo = AmmoTypes.SMALL_MISSILE;}
		
		
		}
	
	public abstract void shoot();
	
	public int getMag(){return this.mag;}
	public void setMag(int arg){ this.mag = arg;}
	
	public void destroy() {
		System.gc();
	}
	
	


	public void load() {
		int y = 0;
		Inventory inv = this.owner.getInventory();
		ItemStack con[] = inv.getContents();
		while(y >= con.length || this.mag >=maxMag){
			if(McGuns.hashyammo.get(con[y]) == this.neededAmmo);{
				if(inv.contains(con[y])){
					inv.remove(con[y]);
					this.mag++;
					}
				}
		
		y++;}
		if (this.mag <= 0)
			this.owner.sendMessage(ChatColor.DARK_AQUA+"You cannot load your gun, you are out of light ammo!");
		if (this.mag < maxMag)
			this.owner.sendMessage(ChatColor.DARK_AQUA+"Your cannot load your mag fully. Current mag: "+ChatColor.YELLOW+mag+"/"+maxMag);
		y = 0;
		
	}
	public GunTypes getType() {return this.type;}
	
}
