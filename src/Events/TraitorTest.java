package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import TTT.GameStatus;
import TTT.TTT;

public class TraitorTest implements Listener {
	
	public int t = 0;
	

	
	final Location lamp1 = (new Location(Bukkit.getWorld("world"), 79, 29, 825));
	final Location lamp2 = (new Location(Bukkit.getWorld("world"), 82, 29, 825));
	final Location glass1 = (new Location(Bukkit.getWorld("world"), 80, 27, 825));
	final Location glass2 = (new Location(Bukkit.getWorld("world"), 81, 27, 825));;
	
	final Location button = (new Location(Bukkit.getWorld("world"), 80, 28, 823));
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		 if (e.getAction() == Action.RIGHT_CLICK_BLOCK){
			if (e.getClickedBlock().getType() == Material.STONE_BUTTON) {
				if (JoinQuitListener.Spieler.contains(p) && glass1.getBlock().getType() == Material.AIR && lamp1.getBlock().getType() == Material.REDSTONE_LAMP_OFF &&  TTT.Status == GameStatus.Game) {
						if (JoinQuitListener.Spieler.contains(p)) {
							p.teleport(new Location(Bukkit.getWorld("world"), 80.5, 27.0, 823.5));
							p.getWorld().getChunkAt(p.getLocation()).load();
							Bukkit.broadcastMessage("§8[§4TTT§8] §a" + p.getName() + " hat den Tester betreten!");
							glass1.getBlock().setType(Material.GLASS);
				            glass2.getBlock().setType(Material.GLASS);
						
							
						}
						
						if (TTT.Traitor.contains(p.getName())) {
						    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TTT.plugin, new Runnable(){
								public void run() {
									Bukkit.clearRecipes();
							        
									glass1.getBlock().setType(Material.AIR);
							        glass2.getBlock().setType(Material.AIR);
							        lamp1.getBlock().setType(Material.GLOWSTONE);
							        lamp2.getBlock().setType(Material.GLOWSTONE);
								}
						    	
						    }, 80L);
						    
						    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TTT.plugin, new Runnable(){
								public void run() {
									Bukkit.clearRecipes();
							        lamp1.getBlock().setType(Material.REDSTONE_LAMP_OFF);
							        lamp2.getBlock().setType(Material.REDSTONE_LAMP_OFF);
								}
						    	
						    }, 160L);
						} else {
						    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TTT.plugin, new Runnable(){
								public void run() {
									Bukkit.clearRecipes();
							        
									glass1.getBlock().setType(Material.AIR);
							        glass2.getBlock().setType(Material.AIR);
								}
						    	
						    }, 100L);
						}	
					
				}

			}
		 }

	}
	
	
}
