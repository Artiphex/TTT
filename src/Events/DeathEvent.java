package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.iron42.TTT.KarmaConfig.Karma;
import de.iron42.TTT.TTT;


public class DeathEvent implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		e.setDroppedExp(0);

		Player p = e.getEntity().getPlayer();
		Player k = e.getEntity().getKiller();
		
		//AutoRespawn.autoRespawn(p);
		
		e.setDeathMessage("§8[§3TIMV§8] §7" + p.getName() + "§7 died!");
		if (TTT.Innocent.contains(p.getName())) {
			Bukkit.broadcastMessage("§8[§3TIMV§8] He was an §2Innocent§7!");
		} else if (TTT.Traitor.contains(p.getName())) {
			Bukkit.broadcastMessage("§8[§3TIMV§8] He was an §4Traitor§7!");
		} else if (TTT.Detective.contains(p.getName())) {
			Bukkit.broadcastMessage("§8[§3TIMV§8] He was an §1Detective§7!");
		}


		p.teleport(new Location(Bukkit.getWorld("world"), 0.5, 58.5, 0.5));
		
		//PUNKTE
				if (TTT.Innocent.contains(k.getName())) {
				if (TTT.Innocent.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed an Innocent.");
			    Karma.removeKarma(20, k);
			    k.sendMessage("§8[§3TIMV§8] §c>>20");
			   }
			   if (TTT.Detective.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed a Detective.");
			    Karma.removeKarma(50, k);
			    k.sendMessage("§8[§3TIMV§8] §c>>50");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed an Traitor.");
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("§8[§3TIMV§8] §a>>20");
			    k.sendMessage("§8[§3TIMV§8] §e>>1 Coin");
			   }
			  }
			  
			  if (TTT.Traitor.contains(k.getName())) {
			   if (TTT.Detective.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed a Detective.");
			    Karma.addKarma(50, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("§8[§3TIMV§8] §a>>50");
			    k.sendMessage("§8[§3TIMV§8] §e>>1 Coin");
			   }
			   if (TTT.Innocent.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed an Innocent.");
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("§8[§3TIMV§8] §a>>20");
			    k.sendMessage("§8[§3TIMV§8] §e>>1 Coin");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed a Traitor.");
			    Karma.removeKarma(20, k);
			    k.sendMessage("§8[§3TIMV§8] §c>>20");
			   }
			  }
			  
			  if (TTT.Detective.contains(k.getName())) {
			   if (TTT.Detective.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed a Detective.");
			    Karma.removeKarma(20, k);
			    k.sendMessage("§8[§3TIMV§8] §c>>20");
			   }
			   if (TTT.Innocent.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed an Innocent.");
			    Karma.removeKarma(20, k);
			    k.sendMessage("§8[§3TIMV§8] §c>>20");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    k.sendMessage("§8[§3TIMV§8] §7You've killed a Traitor.");
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("§8[§3TIMV§8] §a>>20");
			    k.sendMessage("§8[§3TIMV§8] §e>>1 Coin");
			   }
			  }
			  
			  //Spectator
			  TTT.Spectator.add(p.getName());
			  for(Player players : Bukkit.getOnlinePlayers()){
					 players.hidePlayer(p);
					 p.setAllowFlight(true);
				 }
			  
			  
		//PUNKTE
		if (TTT.Innocent.contains(p.getName())) {
			TTT.Innocent.remove(p.getName());
			WinListener.onWin();
		} else if (TTT.Traitor.contains(p.getName())) {
			TTT.Traitor.remove(p.getName());
			WinListener.onWin();
		} else if (TTT.Detective.remove(p.getName())) {
			TTT.Detective.remove(p.getName());
			WinListener.onWin();
		}
		
		if (Karma.getKarma(p) == -20) {
			p.setBanned(true);
		}
		
		
	}
	
	@EventHandler
	public void on(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(40);
	}
	
	  @EventHandler
	  public void on(EntityDamageByEntityEvent e) {
		  Player p = (Player) e.getDamager();
		  Player k = (Player) e.getEntity();
		  
		  if (TTT.Spectator.contains(p.getName())){
			  e.setCancelled(true);
		  }
	  }

}
