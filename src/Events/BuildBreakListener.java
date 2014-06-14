package Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildBreakListener implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			e.setCancelled(false);
		} else {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		//TEST
		ItemStack traitor = new ItemStack (Material.BOW);
		ItemMeta traitorMeta = traitor.getItemMeta();
		traitorMeta.setDisplayName("§cTraitor Shop");
		traitor.setItemMeta(traitorMeta);
		//TEST
		if (p.isOp()) {
			e.setCancelled(false);
			p.getInventory().addItem(traitor);
			p.updateInventory();
		} else {
			e.setCancelled(true);
		}
	}
}
