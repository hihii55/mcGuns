package org.hihii55.mcGuns.projectile;

import java.util.UUID;

import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

public class Bullet extends Thread{
	
	private double velocity;
	private int size;
	private LivingEntity shooter;
	public final Location originalLocation;
	private Location location;
	
	public Bullet(Location originalLocation, double velocity, int size, LivingEntity shooter) {
		
		this.originalLocation = originalLocation;
		this.setLocation(originalLocation);
		this.setVelocity(velocity);
		this.setSize(size);
		this.setShooter(shooter);
		
		this.start();
		
		
	}
	
	@Override
	public void run() {
		final double startingTime = System.currentTimeMillis();
		double time = 0;
		double travelledX = 0;
		double travelledY = 0;
		double travelledZ = 0;
		while(location.getWorld().getBlockAt(location).getType() == Material.AIR) {
			
			this.location.setX(originalLocation.getX() + velocity * Math.cos(originalLocation.getYaw()) * time);
			this.location.setX(originalLocation.getY() + velocity * Math.sin(originalLocation.getYaw()) * time - 0.5 * 9.81 * Math.pow(time, 2));
			this.location.setZ(originalLocation.getY() + velocity * Math.cos(originalLocation.getPitch()) * time);
			location.getWorld().playEffect(location, Effect.SMOKE, 1);
			
			
			
			time = System.currentTimeMillis() - startingTime;
		}
		
		location.getWorld().playEffect(location, Effect.STEP_SOUND, 2);
		
	}
	public void setLocation(Location loc) {
		
		this.location = loc;
	}
	
	public Location getLocation() {
		return location;
		
	}

	public void setShooter(LivingEntity shooter) {
		
		this.shooter = shooter;
	}
	
	public LivingEntity getShooter() {
		return shooter;
	}

	public double getVelocity() {
		return velocity;
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


}
