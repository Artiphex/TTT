package Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import TTT.GameStatus;
import TTT.TTT;
import TTT.KarmaConfig.Karma;


public class WinListener implements Listener {
	
	@EventHandler
	public static void Win() {
		
		if ((TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Deathmatch)) {
			
			if (TTT.Traitor.size() == 0) {
				Bukkit.broadcastMessage("§8[§4TTT§8] §aDie §2Innocents §ahaben das Spiel gewonnen §b+§e10§bPunkte");
				for (Player p : JoinQuitListener.Spieler) {
					if (TTT.Innocent.contains(p.getName())) {
						Karma.addKarma(10, p);
						 p.sendMessage("§8[§4TTT§8] §a>>10 Karma");
					}
					
					TTT.Timer = 11;
					TTT.Status = GameStatus.Restarting;
				}
			}
			if (TTT.Innocent.size() == 0 && TTT.Detective.size() == 0) {
				Bukkit.broadcastMessage("§8[§4TTT§8] §aDie §4Traitor §ahaben das Spiel gewonnen §b+§e10§bPunkte");
				for (Player p : JoinQuitListener.Spieler) {
					if (TTT.Traitor.contains(p.getName())) {
						Karma.addKarma(10, p);
					}
				}
				
				TTT.Timer = 11;
				TTT.Status = GameStatus.Restarting;
			}
		}

	}
}
