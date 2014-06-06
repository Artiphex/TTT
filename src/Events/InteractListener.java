package Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Block block = e.getClickedBlock();
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if ((block != null) && (block.getType() == Material.SKULL)) {
				Skull skullState = (Skull)block.getState();
				if (skullState.hasOwner()){
					String owner = skullState.getOwner();
						if(owner.equals("IntelliJ")) {
							
							
							p.sendMessage("§2Shotgun");
							
						} else if(owner.equals("Abmahnung")) {
							
							p.sendMessage("§2Bogen");
							
						} else if(owner.equals("FallingDiamond")) {
							
							p.sendMessage("§2Sniper");
							//p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 12, 12);
						} else if(owner.equals("KlausurThaler144")) {
							
							p.sendMessage("§2Minigun");
							
						} else if(owner.equals("VareidePlays")) {
							
							if(p.getInventory().contains(Material.STONE_SWORD)) {
								p.getInventory().remove(Material.STONE_SWORD);
								p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_SWORD, 1) });
								p.updateInventory();
								skullState.setOwner("Nottrex");
								skullState.update();
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
							} else if (p.getInventory().contains(Material.WOOD_SWORD)) {
							e.setCancelled(true);
								} else {
								block.setType(Material.AIR);
								p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_SWORD, 1) });
								p.updateInventory();
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
							}
							
							
							
						} else if(owner.equals("Nottrex")) {
							
							if(p.getInventory().contains(Material.WOOD_SWORD)) {
								p.getInventory().remove(Material.WOOD_SWORD);
								p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD, 1) });
								p.updateInventory();
								skullState.setOwner("VareidePlays");
								skullState.update();
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
							} else if (p.getInventory().contains(Material.STONE_SWORD)) {
								e.setCancelled(true);
									} else {
								block.setType(Material.AIR);
								p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD, 1) });
								p.updateInventory();
								p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
							}
							
							
						}
				}
			}
		}
	//	if ((block != null) && (block.getType() == Material.SKULL)) {
	//	Skull skullState = (Skull)block.getState();
	//      if (skullState.hasOwner()){
	//       String owner = skullState.getOwner();
	//        Bukkit.broadcastMessage(owner);
	//       }
	//		}
	}
}
