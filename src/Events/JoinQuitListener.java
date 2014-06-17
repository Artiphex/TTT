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

import de.iron42.TTT.GameStatus;
import de.iron42.TTT.KarmaConfig;
import de.iron42.TTT.ShopConfig;
import de.iron42.TTT.TTT;
import de.iron42.TTT.KarmaConfig.Karma;



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
		ShopConfig.tShop.settShop(p, 1);
		
		if(Karma.getKarma(p) == 0) {
		Karma.setKarma(p, 200);
		}
		
		if(Karma.getKarma(p) == -20) {
		p.setBanned(true);
		}
		
		if (TTT.Status == GameStatus.Lobby) {
		e.setJoinMessage("§8[§4TTT§8] " +p.getName()+" §7joined the game. §8>§a" + Bukkit.getOnlinePlayers().length + "/24§8<" );
		}
	}
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (TTT.Status == GameStatus.Lobby || TTT.Status == GameStatus.Restarting) {
		e.setQuitMessage("§8[§4TTT§8] " +p.getName()+" §7left the game. §8>§a" + (Bukkit.getOnlinePlayers().length - 1) + "/24§8<" );
		ShopConfig.tShop.settShop(p, 1);
	} else if (TTT.Status == GameStatus.Peace) {
		e.setQuitMessage("");
		WinListener.onWin();	
	}
		Spieler.remove(p);
		if((TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Deathmatch)) {
		WinListener.onWin();	
		Bukkit.broadcastMessage("§8[§4TTT§8] §7A player died");
		e.setQuitMessage("");
		}
	}
	
	@EventHandler
	public void inGame(PlayerLoginEvent e) {
		if ((de.iron42.TTT.TTT.Status == GameStatus.Peace) || (de.iron42.TTT.TTT.Status == GameStatus.Game) || (de.iron42.TTT.TTT.Status == GameStatus.Restarting) ) {
			e.disallow(null, null);
		}
		
	}

}
