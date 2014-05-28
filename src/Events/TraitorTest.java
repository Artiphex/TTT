package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.iron42.TTT.GameStatus;
import de.iron42.TTT.TTT;

public class TraitorTest implements Listener {
	
	public int t = 0;
	
	public TTT plugin;
	public TraitorTest() {
	}
	
	final Location lamp1 = (new Location(Bukkit.getWorld("world"), -3, 68, -56));
	final Location lamp2 = (new Location(Bukkit.getWorld("world"), 3, 68, -56));
	final Location glass1 = (new Location(Bukkit.getWorld("world"), -1, 69, -58));
	final Location glass2 = (new Location(Bukkit.getWorld("world"), 0, 72, -58));
	final Location glass3 = (new Location(Bukkit.getWorld("world"), 1, 72, -58));
	
	final Location button = (new Location(Bukkit.getWorld("world"), 0, 70, -61));
	
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		if (TTT.Status == GameStatus.Game) {
			if ((e.getAction() == Action.RIGHT_CLICK_BLOCK)

					&& (e.getClickedBlock().getType() == Material.STONE_BUTTON)) {
				//if (e.getClickedBlock().getLocation() == button) {
					
					p.teleport(new Location(Bukkit.getWorld("world"), 0.5, 69.5, -59.5));
					p.getWorld().getChunkAt(p.getLocation()).load();
					Bukkit.broadcastMessage("§8[§4TTT§8] §a" + p.getName() + " has entered the Tester!");
				
					//if (JoinQuitListener.Spieler.contains(p.getName())) {
						glass1.getBlock().setType(Material.GLASS);
						glass2.getBlock().setType(Material.GLASS);
						glass3.getBlock().setType(Material.GLASS);

					//}
					
					if (TTT.Traitor.contains(e.getPlayer())) {
						onTestTraitor();
					} else {
						
						onTest();
					}
				//}

					} else if (glass3.getBlock().getType() == Material.GLASS) {
						e.setCancelled(true);
					}
			
		}

	}
	
	public void onTestTraitor() {
		
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run(){
				
				Bukkit.clearRecipes();
				

					glass1.getBlock().setType(Material.AIR);
					glass2.getBlock().setType(Material.AIR);
					glass3.getBlock().setType(Material.AIR);

					lamp1.getBlock().setType(Material.REDSTONE_LAMP_ON);
					lamp2.getBlock().setType(Material.REDSTONE_LAMP_ON);
				
				
			}
		}, 100L);
		

	}
	
	public void onTest() {
		
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			public void run(){
				
				Bukkit.clearRecipes();
				

					glass1.getBlock().setType(Material.AIR);
					glass2.getBlock().setType(Material.AIR);
					glass3.getBlock().setType(Material.AIR);

					lamp1.getBlock().setType(Material.REDSTONE_LAMP_ON);
					lamp2.getBlock().setType(Material.REDSTONE_LAMP_ON);
				
				
			}
		}, 100L);
		

	}
	

}
