package Weapon;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class Minigun implements Listener {
	
	@EventHandler
	public void onMiniShot(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		ItemStack minigun = new ItemStack (Material.BOW);
		ItemMeta metaMinigun = minigun.getItemMeta();
		metaMinigun.setDisplayName("§cMinigun");
		minigun.setItemMeta(metaMinigun);
		
		if (e.getItem() != null && e.getItem().getType() == Material.BOW) {
				if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
					if (p.getInventory().contains(Material.ARROW) && e.getItem().getItemMeta().getDisplayName().equals("§cMinigun")) {
						//Abfrage mit dem Namen Minigun
						Arrow arrow = (Arrow) p.launchProjectile(Arrow.class);
						arrow.setVelocity(arrow.getVelocity().multiply(3));
						p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.ARROW, 1) });
						p.updateInventory();
						p.playEffect(p.getLocation(), Effect.BOW_FIRE, 1);
						
						//for (int i = 0; i < p.getInventory().getSize(); i++) {
						//	if (p.getInventory().getItem(i) != null) {
						//	if (p.getInventory().getItem(i).getType() == Material.BOW) {
						//		p.getInventory().setItem(i, null);
						//	}
						//}
					//}
						p.getInventory().remove(minigun);
						
						p.updateInventory();
						e.setCancelled(true);
						p.getInventory().addItem(minigun);
						p.updateInventory();
			}
			}
			
		}
	}
}
