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
import de.iron42.TTT.TTT;



public class JoinQuitListener implements Listener {
	
	public static ArrayList<Player> Spieler = new ArrayList<Player>();
	
	final Location lobby = (new Location(Bukkit.getWorld("world"), 1000.5, 50.5, 1000.5));
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.teleport(lobby);
		p.getInventory().clear();
		p.getInventory().setChestplate(null);
		p.setHealth(20.0);
		Spieler.add(p);
		
		e.setJoinMessage("§8[§4TTT§8] " +p.getName()+" §7joined the game. §8>§a" + Bukkit.getOnlinePlayers().length + "/24§8<" );
	}
	
	@EventHandler
	public void onJoin(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§8[§4TTT§8] " +p.getName()+" §7left the game. §8>§a" + (Bukkit.getOnlinePlayers().length - 1) + "/24§8<" );
		Spieler.remove(p);
		if((TTT.Status == GameStatus.Game) || (TTT.Status == GameStatus.Deathmatch)) {
		WinListener.onWin();	
		}
	}
	
	@EventHandler
	public void inGame(PlayerLoginEvent e) {
		if ((de.iron42.TTT.TTT.Status == GameStatus.Peace) || (de.iron42.TTT.TTT.Status == GameStatus.Game) || (de.iron42.TTT.TTT.Status == GameStatus.Restarting) ) {
			e.disallow(null, null);
		}
		
	}

}
