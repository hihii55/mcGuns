package org.hihii55.mcGuns.Guns;

import org.bukkit.Material;

public enum GunTypes {

	//First assault rifles:
	//TOOL: GLISTERING_MELON
	AK_47_Kalasnikov(1, "AK-47 Kalasnikov", Material.SPECKLED_MELON),
	M16(2, "M16", Material.SPECKLED_MELON),
	M46A1(3, "M46A1", Material.SPECKLED_MELON),

	//Then pistols:
	//TOOL: IRON_INGOT
	Desert_Eagle(4, "Desert Eagle", Material.IRON_INGOT),
	G_18(5 ,"G 18", Material.IRON_INGOT),
	M1911(6, "M1911", Material.IRON_INGOT),

	//Snipers:
	//TOOL: PAPER

	Barrett_M82(7, "Barrett-M82", Material.IRON_INGOT),
	Dragunov(8, "Dragunov", Material.IRON_INGOT),
	Intervention(9, "Intervention", Material.IRON_INGOT),

	//Shotguns:
	//TOOL: BOOK

	SPAS_12(10, "SPAS-12", Material.BOOK),
	STAKEOUT(11, "Stakeout", Material.BOOK),
	RANGER(12, "Ranger", Material.BOOK),

	//Bazookas:
	//TOOL: BLAZE_ROD

	RPG_7(13, "RPG-7", Material.BOOK),
	M72_LAW(14, "M72 LAW", Material.BOOK),
	APILAS(15, "APILAS", Material.BOOK),

	//Light machine guns:
	//TOOL: GOLD_INGOT

	RPK(16, "RPK", Material.BUCKET),
	RPD(17, "RPD", Material.BUCKET),
	M240(18, "M240", Material.BUCKET),

	//Sub machine guns:
	//TOOL: BUCKET

	MP_5(19, "MP-5", Material.GOLD_INGOT),
	UZI(20, "UZI", Material.GOLD_INGOT),
	UMP_45(21, "UMP-45", Material.GOLD_INGOT);

	public int number;
	public String description;
	public Material type;

	GunTypes(int num, String desc, Material typ) {

		number = num;
		description = desc;
		type = typ;
		



	}


}