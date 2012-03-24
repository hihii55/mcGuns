package org.hihii55.mcGuns.Listeners;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.hihii55.mcGuns.GunsActionLib;

public class GunsPlayerListener implements Listener {

	public void onPlayerInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		Action action = event.getAction();
		//First the pistol:
		switch (action){
			case RIGHT_CLICK_AIR: 
				GunsActionLib.shotmentPreprocessor(p);
				break;
			case RIGHT_CLICK_BLOCK:
				GunsActionLib.shotmentPreprocessor(p);
				break;
			case LEFT_CLICK_AIR:
					
				
		}
	}
}
