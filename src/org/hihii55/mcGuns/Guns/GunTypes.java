package org.hihii55.mcGuns.Guns;

public enum GunTypes {

	//First assault rifles:
	AK_47_Kalasnikov(1),
	M16(2),
	M46A1(3),

	//Then pistols:
	Desert_Eagle(4),
	G_18(5),
	M1911(6),
	//More pistols coming soon...

	//Snipers:

	Barrett_M82(7),
	Dragunov(8),
	Intervention(9),

	//Shotguns:

	SPAS_12(10),
	STAKEOUT(11),
	RANGER(12),

	//Bazookas:

	RPG_7(13),
	M72_LAW(14),
	APILAS(15),

	//Light machine guns:

	RPK(16),
	RPD(17),
	M240(18),

	//Sub machine guns:

	MP_5(19),
	UZI(20),
	UMP_45(21);
	
	int description;
	
	GunTypes(int desc) {
		
		desc = description;
		
		
		
	}


}