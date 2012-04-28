	package org.hihii55.mcGuns.Listeners;
	
	
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
			Object item = McGuns.hashy.get(p.getItemInHand());
			//When player right-clicks air or a block, and player is holding a gun-item, shoot:
			switch (action){
				case RIGHT_CLICK_AIR: 
					if(item instanceof Gun && item != null)
							((Gun) item).shoot();
					break;
				case RIGHT_CLICK_BLOCK:
					if(item instanceof Gun && item != null)
							((Gun) item).shoot();
					break;
				//When hits (alias left-clicks) a solid block more times, load the gun
				case LEFT_CLICK_BLOCK:
					if(item instanceof Gun && item != null){
					Gun gun = ((Gun) item);
					gun.firstTime = System.currentTimeMillis();
					if(gun.hittedtimes <= 0)
						gun.lastTime = gun.firstTime;
					//This is only a temporytal solution
					if(gun.getType() == GunTypes.Desert_Eagle || gun.getType() == GunTypes.M1911 || gun.getType() == GunTypes.G_18){
						
						if(gun.lastTime-gun.firstTime < 1000){
							gun.lastTime = System.currentTimeMillis();
							gun.hittedtimes++;
							if(gun.hittedtimes >= 3){
							gun.load();
							gun.firstTime = 0;
							gun.lastTime = 0;
							gun.hittedtimes= 0;}
							else{
								gun.firstTime = System.currentTimeMillis();
								gun.lastTime = 0;
								gun.hittedtimes = 1;
								}
						}
					}}
					
					break;
				default: break;}
					
						
						}
					
					
					
			}
