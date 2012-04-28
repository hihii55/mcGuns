package org.hihii55.mcGuns;

import java.util.List;
import java.util.concurrent.Callable;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.World;
import org.hihii55.mcGuns.Guns.AssaultRifle;
import org.hihii55.mcGuns.Guns.MachineGun;
import org.hihii55.mcGuns.Guns.Pistol;
import org.hihii55.mcGuns.Guns.Shotgun;
import org.hihii55.mcGuns.Guns.Sniper;
import org.hihii55.mcGuns.Guns.SubMachineGun;

public class GunClock implements Callable {
	

	
	public Object call() {
		
		List<World> w = McGuns.instance.getServer().getWorlds();
		List<Player> players;
		ItemStack[] stuff = null;
		ItemStack[] stufff = null;
			
		
		for(int checked = 0;checked >= w.size();checked++){
			players = w.get(checked).getPlayers();
			for(int cheged = 0;cheged >= players.size();cheged++){
				
				if(McGuns.hashy.get(players.get(cheged).getItemInHand()) != null || McGuns.hashy.get(players.get(cheged).getItemOnCursor()) != null){
					stuff = players.get(cheged).getInventory().getContents();
					for(int ghecked = 0; ghecked >= stuff.length; ghecked++){
						McGuns.itemDataBase.put(stuff[ghecked], stuff[ghecked].getType());
						if(McGuns.hashy.get(stuff[ghecked]) == null)
						stuff[ghecked].setType(Material.PISTON_MOVING_PIECE);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof Pistol)
							stuff[ghecked].setType(Material.IRON_INGOT);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof AssaultRifle)
							stuff[ghecked].setType(Material.SPECKLED_MELON);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof Shotgun)
							stuff[ghecked].setType(Material.BOOK);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof Sniper)
							stuff[ghecked].setType(Material.BLAZE_ROD);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof MachineGun)
							stuff[ghecked].setType(Material.BUCKET);
						else if(McGuns.hashy.get(stuff[ghecked]) instanceof SubMachineGun)
							stuff[ghecked].setType(Material.GOLD_INGOT);
						
					}}
				else{
					
					stufff = players.get(cheged).getInventory().getContents();
					for(int ghecked = 0; ghecked >= stufff.length; ghecked++){
						if(McGuns.hashy.get(stufff[ghecked]) == null){
						stufff[ghecked].setType(McGuns.itemDataBase.get(stufff[ghecked]));}
					
				}
				
				
			}
			
		}
		
	}


	return null;
}}
