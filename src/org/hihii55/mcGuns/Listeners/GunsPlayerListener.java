	package org.hihii55.mcGuns.Listeners;
	
	
	import java.util.GregorianCalendar;
	
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.EventPriority;
	import org.bukkit.event.Listener;
	import org.bukkit.event.block.Action;
	import org.bukkit.event.player.PlayerInteractEvent;
	import org.hihii55.mcGuns.McGuns;
	import org.hihii55.mcGuns.Guns.Gun;
	import org.hihii55.mcGuns.Guns.GunTypes;
	
	public class GunsPlayerListener implements Listener {
	
		//The most important event:
		@EventHandler(priority = EventPriority.HIGH)
		public void onPlayerInteract(PlayerInteractEvent event) {
			Player p = event.getPlayer();
			Action action = event.getAction();
			Gun item = McGuns.hashy.get(p.getItemInHand());
			//When player right-clicks air or a block, and player is holding a gun-item, shoot:
			switch (action){
				case RIGHT_CLICK_AIR: 
					if(McGuns.hashy.get(p.getItemInHand()) != null)
							item.shoot();
					break;
				case RIGHT_CLICK_BLOCK:
					if(McGuns.hashy.get(p.getItemInHand()) != null)
						if(item.getType() == GunTypes.Desert_Eagle || 
						item.getType() == GunTypes.G_18 ||
						item.getType() == GunTypes.M1911)
							item.shoot();
					break;
				//When hits (alias left-clicks) a solid block more times, load the gun
				case LEFT_CLICK_BLOCK:
					Gun g = McGuns.hashy.get(p.getItemInHand());
					
					g.firstTime = System.currentTimeMillis();
					if(g.hittedtimes <= 0)
						g.lastTime = g.firstTime;
					if(g.getType() == GunTypes.Desert_Eagle || g.getType() == GunTypes.M1911 || g.getType() == GunTypes.G_18){
						
						if(g.lastTime-g.firstTime < 1000){
							g.lastTime = System.currentTimeMillis();
							g.hittedtimes++;
							if(g.hittedtimes >= 3){
							g.load();
							g.firstTime = 0;
							g.lastTime = 0;
							g.hittedtimes= 0;}
							else{
								g.firstTime = System.currentTimeMillis();
								g.lastTime = 0;
								g.hittedtimes = 1;
								}
						}
					}
					
					break;
				default: break;}
					
						
						}
					
					
					
			}
