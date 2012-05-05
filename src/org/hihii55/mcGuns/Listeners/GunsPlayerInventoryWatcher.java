package org.hihii55.mcGuns.Listeners;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.hihii55.mcGuns.McGuns;
import org.hihii55.mcGuns.Guns.Gun;
import org.hihii55.mcGuns.ammo.AmmoTypes;

public class GunsPlayerInventoryWatcher extends Thread{
	
	private Player p;
	private ItemStack oldItemInHand;
	private ItemStack newItemInHand;
	private ItemStack oldItemInCursor;
	private ItemStack newItemInCursor;
	private boolean isHoldingGun;
	public ItemStack lastItemAsHelmet;
	
	public GunsPlayerInventoryWatcher(Player watchingPlayer){
		
		this.p = watchingPlayer;
		
		
	}
	@Override
	public void run(){
		Player[] players = McGuns.instance.getServer().getOnlinePlayers();
		ItemStack[] contents = p.getInventory().getContents();
		while(Arrays.asList(players).contains(p) && p.hasPermission("mcguns.use.holding")){
			newItemInHand=p.getItemInHand();
			newItemInCursor=p.getItemOnCursor();
			if(isHoldingGun && p.getInventory().getHelmet().getType() != Material.LEAVES){
				p.getInventory().remove(p.getInventory().getHelmet().getType());
				p.getInventory().setHelmet(lastItemAsHelmet);
				p.sendMessage(ChatColor.DARK_GREEN+"You have to wear the leaves, because they are made to show other players that you are wielding not a normal item, you are wielding a gun or other mcGuns thing.");}
			if(McGuns.hashy.get(p.getItemInHand()) instanceof Gun || McGuns.hashy.get(p.getItemInHand()) instanceof AmmoTypes && McGuns.hashy.get(p.getItemInHand()) != null)
			{
				isHoldingGun = true;
				p.getWorld().dropItemNaturally(p.getLocation(), p.getInventory().getHelmet());
				p.getInventory().remove(p.getInventory().getHelmet());
				lastItemAsHelmet = new ItemStack(Material.LEAVES, 1);
				p.getInventory().setHelmet(lastItemAsHelmet);
				contents = p.getInventory().getContents();
				for(int i = 0; i >= contents.length; i++){
					if(!(McGuns.hashy.get(contents[i]) instanceof Gun || McGuns.hashy.get(contents[i]) instanceof AmmoTypes) && p.getItemInHand().getType() != Material.AIR)
					{
						contents[i].setType(Material.PISTON_MOVING_PIECE);
					}
					contents = p.getInventory().getContents();
				}
				
			}
			else if(!(McGuns.hashy.get(p.getItemInHand()) instanceof Gun || McGuns.hashy.get(p.getItemInHand()) instanceof Gun) )
			{
				isHoldingGun = false;
				p.getInventory().setHelmet(new ItemStack(Material.AIR, 1));
				contents = p.getInventory().getContents();
				for(int i = 0; i >= contents.length; i++){
					if(McGuns.hashy.get(contents[i]) instanceof Gun || McGuns.hashy.get(contents[i]) instanceof AmmoTypes && McGuns.hashy.get(contents[i]) != null)
					{
						contents[i].setType(Material.PISTON_MOVING_PIECE);
					}
					contents = p.getInventory().getContents();
				}
				
			}
			players = McGuns.instance.getServer().getOnlinePlayers();
			contents = p.getInventory().getContents();
			if(oldItemInHand != newItemInHand && McGuns.hashy.get(newItemInHand) instanceof Gun || McGuns.hashy.get(newItemInHand) instanceof AmmoTypes && McGuns.hashy.get(newItemInHand) != null)
			{
				p.sendMessage(McGuns.hashy.get(newItemInCursor) instanceof Gun?ChatColor.YELLOW+"Wielding in the cursor "+ChatColor.DARK_GREEN+((Gun)McGuns.hashy.get(newItemInCursor)).getType().description:
					ChatColor.YELLOW+"Wielding in the cursor "+ChatColor.DARK_GREEN+((AmmoTypes)McGuns.hashy.get(newItemInCursor)).description);
				
			}
			if(oldItemInCursor != newItemInCursor && McGuns.hashy.get(newItemInCursor) instanceof Gun || McGuns.hashy.get(newItemInCursor) instanceof AmmoTypes && McGuns.hashy.get(newItemInCursor) != null)
			{
				p.sendMessage(McGuns.hashy.get(newItemInCursor) instanceof Gun?ChatColor.YELLOW+"Equipped a "+ChatColor.DARK_GREEN+((Gun)McGuns.hashy.get(newItemInCursor)).getType().description:
					ChatColor.YELLOW+"Wielding in hand "+ChatColor.DARK_GREEN+((AmmoTypes)McGuns.hashy.get(newItemInCursor)).description);
				
			}
			
			players = McGuns.instance.getServer().getOnlinePlayers();
			contents = p.getInventory().getContents();
			oldItemInHand = p.getItemInHand();
			oldItemInCursor = p.getItemOnCursor();
		}
		
		
	}
	

}
