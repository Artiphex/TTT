package Events;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import TTT.GameStatus;
import TTT.ShopConfig;
import TTT.KarmaConfig.Karma;
import TTT.TTT;




public class JoinQuitListener implements Listener {
	
	public static ArrayList<Player> Spieler = new ArrayList<Player>();
	
	public final static Location lobby = (new Location(Bukkit.getWorld("world"), 1000.5, 50.5, 1000.5));
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.teleport(lobby);
		p.getInventory().clear();
		p.getInventory().setChestplate(null);
		p.setHealth(20.0);
		Spieler.add(p);
		ShopConfig.tShop.settShop(p, 2);
		
		if(Karma.getKarma(p) == 0) {
		Karma.setKarma(p, 200);
		}
		
		if(Karma.getKarma(p) == -20) {
		p.setBanned(true);
		}
		
		if (TTT.Status == GameStatus.preLobby || TTT.Status == GameStatus.Lobby) {
		e.setJoinMessage("§a" +p.getName()+" §7ist dem Spiel beigetreten");
		if (Bukkit.getOnlinePlayers().length == 4 || Bukkit.getOnlinePlayers().length >= 4) {
			TTT.Status = GameStatus.Lobby;
		}
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (TTT.Status == GameStatus.Lobby || TTT.Status == GameStatus.preLobby || TTT.Status == GameStatus.Restarting) {
		e.setQuitMessage("§a" +p.getName()+" §7hat das Spiel verlassen");
	} else if (TTT.Status == GameStatus.Peace) {
		e.setQuitMessage("");
		WinListener.Win();	
	}
		Spieler.remove(p);
		if((TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Deathmatch)) {
		WinListener.Win();	
		e.setQuitMessage("");
		}
	}
	
	@EventHandler
	public void inGame(PlayerLoginEvent e) {
		if ((TTT.Status == GameStatus.Peace) || (TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Restarting) ) {
			e.disallow(null, null);
		}
		
	}

}
