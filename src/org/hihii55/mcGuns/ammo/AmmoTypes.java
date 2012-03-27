package org.hihii55.mcGuns.ammo;

public enum AmmoTypes {
	
	VERY_LIGHT(1),
	LIGHT(2),
	MEDIUM(3),
	HEAVY(4),
	SHOTGUN_AMMO(5),
	
	SMALL_MISSILE(6);
	
	int desc;
	
	AmmoTypes(int arg){
		
		desc = arg;
	}

}
