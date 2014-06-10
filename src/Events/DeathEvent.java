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
		e.getDrops().clear();

		Player p = e.getEntity().getPlayer();
		Player k = e.getEntity().getKiller();
		
		AutoRespawn.autoRespawn(p);
		
		e.setDeathMessage("�8[�4TTT�8] �7A player died!");


		p.teleport(new Location(Bukkit.getWorld("world"), 0.5, 58.5, 0.5));
		
				if (TTT.Innocent.contains(k.getName())) {
				if (TTT.Innocent.contains(p.getName())) {
			    Karma.removeKarma(20, k);
			    k.sendMessage("�8[�3TIMV�8] �7You killed an Innocent �c>>20");
			   }
			   if (TTT.Detective.contains(p.getName())) {
			    Karma.removeKarma(50, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Detective �c>>50");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Traitor �a>>20");
			   }
			  }
			  
			  if (TTT.Traitor.contains(k.getName())) {
			   if (TTT.Detective.contains(p.getName())) {
			    Karma.addKarma(50, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Detective �a>>50");
			   }
			   if (TTT.Innocent.contains(p.getName())) {
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed an Innocent �a>>20");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    Karma.removeKarma(20, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Trator �a>>50");
			   }
			  }
			  
			  if (TTT.Detective.contains(k.getName())) {
			   if (TTT.Detective.contains(p.getName())) {
			    Karma.removeKarma(20, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Detective �c>>50");
			   }
			   if (TTT.Innocent.contains(p.getName())) {
			    Karma.removeKarma(20, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed an Innocent �c>>20");
			   }
			   if (TTT.Traitor.contains(p.getName())) {
			    Karma.addKarma(20, k);
			    //Coins.addCoins(1, k);
			    k.sendMessage("�8[�4TTT�8] �7You killed a Traitor �a>>20");
			   }
			  }
			  
			  //Spectator
			  TTT.Spectator.add(p.getName());
			  for(Player players : Bukkit.getOnlinePlayers()){
					 players.hidePlayer(p);
					 p.setAllowFlight(true);
					 p.setMaximumNoDamageTicks(99999);
				 }
			  
			  
		if (TTT.Innocent.contains(p.getName())) {
			TTT.Innocent.remove(p.getName());
			JoinQuitListener.Spieler.remove(p);
			WinListener.onWin();
		} else if (TTT.Traitor.contains(p.getName())) {
			TTT.Traitor.remove(p.getName());
			JoinQuitListener.Spieler.remove(p);
			WinListener.onWin();
		} else if (TTT.Detective.remove(p.getName())) {
			TTT.Detective.remove(p.getName());
			JoinQuitListener.Spieler.remove(p);
			WinListener.onWin();
		}
		
		if (Karma.getKarma(p) == -20) {
			p.setBanned(true);
		}
		
		
	}
	
	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(40);
	}
	
	  @EventHandler
	  public void onSpectatorHit(EntityDamageByEntityEvent e) {
		  Player p = (Player) e.getDamager();
		  Player k = (Player) e.getEntity();
		  
		  if (TTT.Spectator.contains(p.getName())){
			  e.setCancelled(true);
		  }
	  }

}
