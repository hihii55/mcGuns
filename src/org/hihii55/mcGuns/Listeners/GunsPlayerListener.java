package org.hihii55.mcGuns.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.hihii55.mcGuns.GunsActionLib;

public class GunsPlayerListener implements Listener {

	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Action action = event.getAction();
		ItemStack holdedItem = p.getItemInHand();
		//First the pistol:
		switch (action){
			case LEFT_CLICK_AIR: 
				GunsActionLib.pistolShotment(p, holdedItem);
				default:
				
		}
	}
}
