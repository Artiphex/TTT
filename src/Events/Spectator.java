package Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

import TTT.TTT;

public class Spectator implements Listener {
	
	@EventHandler
	public void onSpecPickup(PlayerPickupItemEvent e) {
		Player p = e.getPlayer();
		if (TTT.Spectator.contains(p.getName())) {
			e.setCancelled(true);
		}
	}
}
