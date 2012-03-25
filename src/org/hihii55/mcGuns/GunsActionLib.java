package org.hihii55.mcGuns;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.hihii55.mcGuns.Guns.GunTypes;



public class GunsActionLib {
	
	public static void shotmentPreprocessor(Player p) {
		ItemStack item = p.getItemInHand();
		if (McGuns.hashy.get(item) != null)
			McGuns.hashy.get(item).shoot();
		

	}

}
