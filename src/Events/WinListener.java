package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import de.iron42.TTT.GameStatus;
import de.iron42.TTT.KarmaConfig.Karma;
import de.iron42.TTT.TTT;


public class WinListener implements Listener {
	
	@EventHandler
	public static void onWin() {
		
		if ((TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Deathmatch)) {
			
			if (TTT.Traitor.size() == 0) {
				Bukkit.broadcastMessage("§8[§4TTT§8] §2§lThe Innocent's won the game!");
				for (Player p : JoinQuitListener.Spieler) {
					if (TTT.Innocent.contains(p.getName())) {
						Karma.addKarma(10, p);
						 p.sendMessage("§8[§4TTT§8] §a>>10 Karma");
					}
					if (TTT.Traitor.contains(p.getName())) {
						Karma.addKarma(10, p);
						p.sendMessage("§8[§4TTT§8] §a>>10 Karma");
					}
					
					TTT.Timer = 11;
					TTT.Status = GameStatus.Restarting;
				}
			}
			if (TTT.Innocent.size() == 0 && TTT.Detective.size() == 0) {
				Bukkit.broadcastMessage("§8[§4TTT§8] §4§lThe Traitor's won the game!");
				for (Player p : JoinQuitListener.Spieler) {
					if (TTT.Traitor.contains(p.getName())) {
						Karma.addKarma(10, p);
						 p.sendMessage("§8[§4TTT§8] §a>>10 Karma");
					}
				}
				
				TTT.Timer = 11;
				TTT.Status = GameStatus.Restarting;
			}
		}

	}
}
