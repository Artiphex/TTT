package Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class WeaponHeads implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if ((e.getAction().equals(Action.RIGHT_CLICK_BLOCK))
				&& (e.getClickedBlock().getType() == Material.SKULL)) {
			
			if (e.getClickedBlock().getState().equals("VareidePlays")) {
				p.sendMessage("GEHT ALLES");
				
			}
			if (p.getInventory().contains(Material.WOOD_SWORD)){
			
				} else {
					
				}
			}
	}

}

