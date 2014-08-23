package Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class Regen implements Listener {
	@EventHandler
	public void onRegen(EntityRegainHealthEvent e) {
	e.setCancelled(true);
	}
}
