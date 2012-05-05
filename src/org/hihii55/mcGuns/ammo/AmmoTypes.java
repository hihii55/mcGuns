package org.hihii55.mcGuns.ammo;

import org.bukkit.Material;


public enum AmmoTypes {
	
	VERY_LIGHT(1, "light bullet", Material.CLAY_BALL),
	MEDIUM(2, "medium bullet", Material.CLAY_BRICK),
	HEAVY(3, "heavy bullet", Material.FLINT),
	SHOTGUN_AMMO(4, "shotgun ammo", Material.SUGAR),
	
	SMALL_MISSILE(5, "small missile (for bazookas)", Material.GHAST_TEAR);
	
	int number;
	public String description;
	public Material type;
	
	AmmoTypes(int num ,String desc, Material typ){
		
		number = num;
		description = desc;
		type = typ;
	}

}
