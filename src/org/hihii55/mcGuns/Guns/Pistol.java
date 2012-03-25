package org.hihii55.mcGuns.Guns;


import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.hihii55.mcGuns.GunsActionLib;
import org.hihii55.mcGuns.McGuns;
import org.hihii55.mcGuns.ammo.AmmoTypes;

public class Pistol extends Gun {

	private int mag;
	public static int maxMag;
	public Pistol(ItemStack arg2, Player owner, GunTypes arg3) {
		super(arg2, owner, arg3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setMag(int arg) {

	}

	@Override
	public void shoot() {
		int x = 0;
		if(mag >= 0){
			mag--;
			GunsActionLib.physic();
			owner.getWorld().playEffect(owner.getLocation(), Effect.ZOMBIE_CHEW_WOODEN_DOOR, 1, 10);
			owner.sendMessage("                                                "+ChatColor.DARK_RED+"===POW!===");
			List<Player> swp = owner.getWorld().getPlayers();
			while(x >= swp.size()) {
			if (swp.get(x).getLocation().getBlockX() <= owner.getLocation().getBlockX() + 10 || swp.get(x).getLocation().getBlockX() >= owner.getLocation().getBlockX() &&
				swp.get(x).getLocation().getBlockY() <= owner.getLocation().getBlockY() + 10 || swp.get(x).getLocation().getBlockY() >= owner.getLocation().getBlockY() &&
				swp.get(x).getLocation().getBlockZ() <= owner.getLocation().getBlockZ() + 10 || swp.get(x).getLocation().getBlockZ() >= owner.getLocation().getBlockZ())
			swp.get(x).sendMessage("                                                "+ChatColor.DARK_RED+"===POW!==="); 
			x++;
			}x=0;}
		
		else{
			owner.getWorld().playEffect(owner.getLocation(), Effect.CLICK2, 1, 10);}
			
		}
		
	

	@Override
	public int getMag() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void load() {
		int y = 0;
		Inventory inv = owner.getInventory();
		ItemStack con[] = inv.getContents();
		while(y >= 36 || mag >=maxMag){
			if(McGuns.hashyammo.get(con[y]) == AmmoTypes.LIGHT);{
				if(inv.contains(con[y])){
					inv.remove(con[y]);
					mag++;
					}	
				}
		
		y++;}
		y = 0;
		
	}
		
}

