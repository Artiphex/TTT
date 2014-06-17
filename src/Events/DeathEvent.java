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
import de.iron42.TTT.ShopConfig;
import de.iron42.TTT.TTT;

public class DeathEvent implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		e.setDroppedExp(0);
		e.getDrops().clear();
		
		if (e.getEntity().getPlayer() instanceof Player) {
		Player p = e.getEntity().getPlayer();
		Player k = e.getEntity().getKiller();
		
		if (e.getEntity().getKiller() instanceof Player) {
			if (TTT.Innocent.contains(k.getName())) {
				if (TTT.Innocent.contains(p.getName())) {
					Karma.removeKarma(20, k);
					k.sendMessage("§8[§4TTT§8] §7You killed an Innocent §c>>20");
				}
				if (TTT.Detective.contains(p.getName())) {
					Karma.removeKarma(50, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Detective §c>>50");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.addKarma(20, k);
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Traitor §a>>20");
				}
			}

			if (TTT.Traitor.contains(k.getName())) {
				if (TTT.Detective.contains(p.getName())) {
					Karma.addKarma(50, k);
					ShopConfig.tShop.addtShop(2, p);
					k.sendMessage("§8[§4TTT§8] §7Shoppoint §a>>2");
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Detective §a>>50");
				}
				if (TTT.Innocent.contains(p.getName())) {
					Karma.addKarma(20, k);
					ShopConfig.tShop.addtShop(1, p);
					k.sendMessage("§8[§4TTT§8] §7Shoppoint §a>>1");
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7You killed an Innocent §a>>20");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.removeKarma(50, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Traitor §c>>50");
				}
			}

			if (TTT.Detective.contains(k.getName())) {
				if (TTT.Detective.contains(p.getName())) {
					Karma.removeKarma(20, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Detective §c>>50");
				}
				if (TTT.Innocent.contains(p.getName())) {
					Karma.removeKarma(20, k);
					k.sendMessage("§8[§4TTT§8] §7You killed an Innocent §c>>20");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.addKarma(20, k);
					ShopConfig.tShop.addtShop(2, p);
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7You killed a Traitor §a>>20");
				}
			}
		}
		
		TTT.Spectator.add(p.getName());
		for (Player players : Bukkit.getOnlinePlayers()) {
			players.hidePlayer(p);
			p.setAllowFlight(true);
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
		
		p.setHealth(20.0D);
		//test
		p.hidePlayer(p);
		Teams.Bedanimation.launchBedAnimation(p);

		e.setDeathMessage("§8[§4TTT§8] §7A player died!");






		if (Karma.getKarma(p) == -20) {
			p.setBanned(true);
		}
		
		
		}
		
		
		


	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent e) {
		e.setFoodLevel(40);
	}

}
