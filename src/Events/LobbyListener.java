package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import TTT.GameStatus;

public class LobbyListener implements Listener {
	
	@EventHandler
	public void FoodLevel(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void LobbyHealth(EntityDamageEvent e) {
		if (TTT.TTT.Status == GameStatus.preLobby || TTT.TTT.Status == GameStatus.Lobby || TTT.TTT.Status == GameStatus.Peace) {
			e.setCancelled(true);
		}
		WinListener.Win();
		
	}
	
	@EventHandler
	public void Drop(PlayerDropItemEvent e) {
		e.setCancelled(true);
		
	}
}
