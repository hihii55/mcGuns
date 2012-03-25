package org.hihii55.mcGuns.ammo;

public enum AmmoTypes {
	
	VERY_LIGHT(1),
	LIGHT(2),
	MEDIUM(3),
	HEAVY(4),
	
	SMALL_MISSILE(5);
	
	int desc;
	
	AmmoTypes(int arg){
		
		desc = arg;
	}

}
