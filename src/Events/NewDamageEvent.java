package Events;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.Main;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import TTT.TTT;

public class NewDamageEvent implements Listener {

	@EventHandler
	public void onSpectatorHit(EntityDamageByEntityEvent e) {

		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			Player p = (Player) e.getDamager();
			Player k = (Player) e.getEntity();
			
			if (TTT.Spectator.contains(p.getName())) {
				e.setCancelled(true);
			}

			if (TTT.Spectator.contains(k.getName())) {
				e.setCancelled(true);
			}
			
			e.getCause();
			//evtl raus aus dem instance
			if (e.getCause() == DamageCause.FALL) {
				AutoRespawn.autoRespawn(p);
				TTT.Spectator.add(p.getName());
				for (Player players : Bukkit.getOnlinePlayers()) {
					players.hidePlayer(p);
					p.setAllowFlight(true);
					JoinQuitListener.Spieler.remove(p);
					WinListener.Win();
				}
			}
		}
		


	}
	@EventHandler
	 public void arrow(EntityShootBowEvent e) {
	  if(e.getProjectile() instanceof Arrow) {
	  final Arrow a = (Arrow) e.getProjectile();
	  
	  new BukkitRunnable() {
	   
	   @Override
	   public void run() {
	    if(!(a.isValid()) || a.isInsideVehicle()) {
	     a.remove();
	     cancel();
	    } else {
	    if(a.isValid()) {
	    for(Entity pl : a.getNearbyEntities(10D, 10D, 10D)) {
	     if(pl instanceof Player) {
	      if(TTT.Spectator.contains(pl)) {
	       pl.setVelocity(new Vector(0, 1, 0));
	      }
	     }
	     }
	    }
	    }
	   }
	  }.runTaskTimer(TTT.plugin, 0L, 0L);
	 
	  }
	 }

}
