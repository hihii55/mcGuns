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
	public static AmmoTypes neededAmmo;
	
	
	/**
	 * The main constructor of a gun
	 * @param item, the item of the gun
	 * @param owner, owner of the gun
	 * @param type, the guntype of the gun
	 */
	public Gun(ItemStack arg2, Player owner, GunTypes arg3){
		this.item = arg2;
		this.type = arg3;
		this.owner = owner;
		String prestring = ChatColor.AQUA+"Maked "+ChatColor.DARK_GREEN;
			owner.sendMessage(prestring+" "+type.description);
		
		
		if(this.type == GunTypes.Desert_Eagle
		  || this.type == GunTypes.G_18
		  || this.type == GunTypes.M1911
		  || this.type == GunTypes.MP_5
		  || this.type == GunTypes.UZI
		  || this.type == GunTypes.UMP_45)
			{this.neededAmmo = AmmoTypes.VERY_LIGHT;}
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
		else if(this.type == GunTypes.Barrett_M82
				|| this.type == GunTypes.Dragunov
				|| this.type == GunTypes.Intervention)
			{this.neededAmmo = AmmoTypes.HEAVY;}
		//If it is a bazooka:
		else{this.neededAmmo = AmmoTypes.SMALL_MISSILE;}
		
		
		}
	/**
	 * Shooting statement. Abstract.
	 */
	public abstract void shoot();
	/**
	 * Returns the current mag
	 * @return mag
	 */
	public int getMag(){return this.mag;}
	/**
	 * Sets the current mag
	 * @param mag
	 */
	public void setMag(int arg){ this.mag = arg;}
	
	
	


	/**
	 * The gun loading statement
	 */
	public void load() {
		int y = 0;
		Inventory inv = this.owner.getInventory();
		ItemStack con[] = inv.getContents();
		while(y >= con.length || this.mag >=maxMag){
			if(McGuns.hashy.get(con[y]) == this.neededAmmo);{
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
	/**
	 * Returns the type of the gun
	 * 
	 * @return type of the gun
	 */
	public GunTypes getType() {return this.type;}
	/**
	 * Sets the type of the gun
	 * 
	 * @param type of the gun
	 */
	public void setType(GunTypes arg) {this.type = arg;}
	
}
