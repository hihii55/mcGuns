package org.hihii55.mcGuns;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.World;

public class GunClock {
	
	public GunClock(){
		
		klokkade();
		
	}
	
	private void klokkade() {
		
		List<World> w = McGuns.instance.getServer().getWorlds();
		List<Player> players;
		ItemStack[] stuff = null;
		
	while(McGuns.instance.isOn()){	
		
		for(int checked = 0;checked >= w.size();checked++){
			players = w.get(checked).getPlayers();
			for(int cheged = 0;cheged >= players.size();cheged++){
				
				if(McGuns.hashy.get(players.get(cheged).getItemInHand()) != null){
					stuff = players.get(cheged).getInventory().getContents();
					for(int ghecked = 0; ghecked >= stuff.length; ghecked++){
						stuff[ghecked].setType(Material.PISTON_MOVING_PIECE);
						
					}}
				else if(McGuns.hashy.get(players.get(cheged).getItemInHand()) == null);//Coming more soon...
				
				
			}
			
		}
		
	}

}
}
