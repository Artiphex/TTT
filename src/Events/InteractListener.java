package Events;

import org.bukkit.Bukkit;
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
import org.bukkit.inventory.meta.ItemMeta;

import TTT.GameStatus;
import TTT.TTT;
import Teams.Traitor;

public class InteractListener implements Listener {
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		
		ItemStack mini = new ItemStack (Material.BOW);
		ItemMeta miniMeta = mini.getItemMeta();
		miniMeta.setDisplayName("§cMinigun");
		mini.setItemMeta(miniMeta);
		
		ItemStack shot = new ItemStack (Material.BOW);
		ItemMeta shotMeta = shot.getItemMeta();
		shotMeta.setDisplayName("§bShotgun");
		shot.setItemMeta(shotMeta);
		
		ItemStack sniper = new ItemStack (Material.BOW);
		ItemMeta sniperMeta = sniper.getItemMeta();
		sniperMeta.setDisplayName("§eSniper");
		shot.setItemMeta(shotMeta);
		
		ItemStack bow = new ItemStack (Material.BOW);
		ItemMeta bowMeta = sniper.getItemMeta();
		bowMeta.setDisplayName("§3Bow");
		bow.setItemMeta(bowMeta);
		
		Block block = e.getClickedBlock();
		if (TTT.Status == GameStatus.Game || TTT.Status == GameStatus.Peace || TTT.Status == GameStatus.Lobby) {
			if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
				if ((block != null) && (block.getType() == Material.SKULL)) {
					if (JoinQuitListener.Spieler.contains(p)) {
						Skull skullState = (Skull)block.getState();
						if (skullState.hasOwner()){
							String owner = skullState.getOwner();
								if(owner.equals("IntelliJ")) {
									
									
									p.sendMessage("§7[§4TTT§8] §7Shotgun - Coming soon");
									
								} else if(owner.equals("Abmahnung")) {
									
									if (p.getInventory().contains(bow)) {
										
									} else if (p.getInventory().contains(shot)) {
									p.getInventory().removeItem(shot);
									p.getInventory().addItem(bow);
									if (p.getInventory().contains(Material.ARROW)) {
										
									} else {
										p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
									}
									p.updateInventory();
									skullState.setOwner("IntelliJ");
									skullState.update();
								
									} else if (p.getInventory().contains(sniper)) {
										p.getInventory().removeItem(sniper);
										p.getInventory().addItem(bow);
										if (p.getInventory().contains(Material.ARROW)) {
										} else {
											p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
										}
										p.updateInventory();
										skullState.setOwner("FallingDiamond");
										skullState.update();
									} else if (p.getInventory().contains(mini)) {
										p.getInventory().removeItem(mini);
										p.getInventory().addItem(bow);
										if (p.getInventory().contains(Material.ARROW)) {
										} else {
											p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
										}
										p.updateInventory();
										skullState.setOwner("KlausurThaler144");
										skullState.update();
									} else {
										p.getInventory().addItem(bow);
										if (p.getInventory().contains(Material.ARROW)) {
										} else {
											p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
										}
										p.updateInventory();
										block.setType(Material.AIR);
									}
								} else if(owner.equals("FallingDiamond")) {
									
									p.sendMessage("§8[§4TTT§8] §7Sniper - Coming soon");
									//p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 12, 12);
								} else if(owner.equals("KlausurThaler144")) {
				
										
										
										if (p.getInventory().contains(mini)) {
												
										} else if (p.getInventory().contains(shot)) {
										p.getInventory().removeItem(shot);
										p.getInventory().addItem(mini);
									    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TTT.plugin, new Runnable(){
											public void run() {
												Bukkit.clearRecipes();
												p.playSound(p.getLocation(), Sound.NOTE_SNARE_DRUM, 12, 12);
											}
									    	
									    }, 10L);
										if (p.getInventory().contains(Material.ARROW)) {
										} else {
											p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
										}
										p.updateInventory();
										skullState.setOwner("IntelliJ");
										skullState.update();
									
										} else if (p.getInventory().contains(sniper)) {
											p.getInventory().removeItem(sniper);
											p.getInventory().addItem(mini);
											if (p.getInventory().contains(Material.ARROW)) {
											} else {
												p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
											}
											p.updateInventory();
											skullState.setOwner("FallingDiamond");
											skullState.update();
										} else if (p.getInventory().contains(bow)) {
											p.getInventory().removeItem(bow);
											p.getInventory().addItem(mini);
											if (p.getInventory().contains(Material.ARROW)) {
											} else {
												p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
											}
											p.updateInventory();
											skullState.setOwner("Abmahnung");
											skullState.update();
										} else {
											p.getInventory().addItem(mini);
											if (p.getInventory().contains(Material.ARROW)) {
											} else {
												p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 32) });
											}
											p.updateInventory();
											block.setType(Material.AIR);
										}
									
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
									
									
									
								} else if (owner.equals("Nottrex")) {
									
									if(p.getInventory().contains(Material.WOOD_SWORD)) {
										p.getInventory().remove(Material.WOOD_SWORD);
										p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD, 1) });
										p.updateInventory();
										skullState.setOwner("VareidePlays");
										skullState.update();
										p.playSound(p.getLocation(), Sound.ITEM_PICKUP, 1, 1);
									} else if (p.getInventory().contains(Material.STONE_SWORD)) {
										p.updateInventory();
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
			}
		}
	//	if ((block != null) && (block.getType() == Material.SKULL)) {
	//	Skull skullState = (Skull)block.getState();
	//      if (skullState.hasOwner()){
	//       String owner = skullState.getOwner();
	//        Bukkit.broadcastMessage(owner);
	//       }
	//		}
		
		if (TTT.Spectator.contains(p.getName())) {
			e.setCancelled(true);
		}
		
	}
}
