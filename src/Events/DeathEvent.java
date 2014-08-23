package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import TTT.ShopConfig;
import TTT.TTT;
import TTT.KarmaConfig.Karma;
import TTT.ShopConfig.tShop;

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
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Innocent getötet §c-20");
				}
				if (TTT.Detective.contains(p.getName())) {
					Karma.removeKarma(50, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Detektive getötet §c-50");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.addKarma(20, k);
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Traitor getötet §a+20");
				}
			}

			if (TTT.Traitor.contains(k.getName())) {
				if (TTT.Detective.contains(p.getName())) {
					Karma.addKarma(30, k);
					ShopConfig.tShop.addtShop(2, k);
					k.sendMessage("§8[§4TTT§8] §7Traitor-Punkte §a+2");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Detektive getötet §a+50");
				}
				if (TTT.Innocent.contains(p.getName())) {
					Karma.addKarma(10, k);
					ShopConfig.tShop.addtShop(1, k);
					k.sendMessage("§8[§4TTT§8] §7Traitor-Punkte §a+1");
					// Coins.addCoins(1, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Innocent getötet §a+20");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.removeKarma(50, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Traitor getötet §c-50");
				}
			}

			if (TTT.Detective.contains(k.getName())) {
				if (TTT.Detective.contains(p.getName())) {
					Karma.removeKarma(50, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Detective getötet §c-50");
				}
				if (TTT.Innocent.contains(p.getName())) {
					Karma.removeKarma(20, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Innocent getötet §c-20");
				}
				if (TTT.Traitor.contains(p.getName())) {
					Karma.addKarma(30, k);
					ShopConfig.tShop.addtShop(2, k);
					k.sendMessage("§8[§4TTT§8] §7Du hast " + p.getName() + " getötet.");
					k.sendMessage("§8[§4TTT§8] §7Du hast einen Traitor getötet §a+30");
					k.sendMessage("§8[§4TTT§8] §7Detective-Punkte §a+4");
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
			WinListener.Win();
		} else if (TTT.Traitor.contains(p.getName())) {
			TTT.Traitor.remove(p.getName());
			JoinQuitListener.Spieler.remove(p);
			WinListener.Win();
		} else if (TTT.Detective.remove(p.getName())) {
			TTT.Detective.remove(p.getName());
			JoinQuitListener.Spieler.remove(p);
			WinListener.Win();
		}
		
		p.setHealth(20.0D);
		//test
		p.hidePlayer(p);
		Teams.Bedanimation.launchBedAnimation(p);

		e.setDeathMessage("");

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
