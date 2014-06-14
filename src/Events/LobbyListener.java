package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.iron42.TTT.GameStatus;

public class LobbyListener implements Listener {
	
	@EventHandler
	public void FoodLevel(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void LobbyHealth(EntityDamageEvent e) {
		if (de.iron42.TTT.TTT.Status == GameStatus.Lobby || de.iron42.TTT.TTT.Status == GameStatus.Peace) {
			e.setCancelled(true);
		}
		WinListener.onWin();
		
	}
	
	@EventHandler
	public void Drop(PlayerDropItemEvent e) {
		e.setCancelled(true);
		
	}
}
