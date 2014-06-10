package Weapon;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sniper implements Listener {
	
	@EventHandler
	public void onShotgunShot(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		ItemStack minigun = new ItemStack (Material.BOW);
		ItemMeta metaMinigun = minigun.getItemMeta();
		metaMinigun.setDisplayName("§eSniper");
		minigun.setItemMeta(metaMinigun);
		
		if (e.getItem() != null && e.getItem().getType() == Material.BOW) {
				if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
					if (p.getInventory().contains(Material.ARROW) && e.getItem().getItemMeta().getDisplayName().equals("§eSniper")) {
						p.setWalkSpeed((float) 0.5D);
					}
				}
		}
	}
}
