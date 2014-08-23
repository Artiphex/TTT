package TTT;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class BowWeapon implements Listener {
	
	public static ArrayList<Player> Minigun = new ArrayList<Player>();
	

	
	@EventHandler
	public void onShoot(PlayerInteractEvent e) {
		final Player p = e.getPlayer();
			if (e.getItem().getType() == Material.BOW) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					Minigun.add(p);	
				}
			}
	}
	
	@EventHandler
	public void onShot(EntityShootBowEvent e) {
		  e.getProjectile().setVelocity(e.getEntity().getLocation().getDirection().multiply(3));
		 // if(event.getBow().getItemMeta().getDisplayName().equals(ChatColor.ITALIC + "Rapidfire Bow")){
		  final Player p = (Player) e.getEntity();	
		    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(TTT.plugin, new Runnable(){
				public void run() {
					Bukkit.clearRecipes();
					Minigun.remove(p);
					 
				}
		    	
		    }, 5L);
		}
		  
					
			
	
	
	@EventHandler
	public void onLoad(ProjectileLaunchEvent e) {
		final Player p = (Player) e.getEntity().getShooter();
			//p.launchProjectile(Arrow.class);
	}
	
	@EventHandler
	public void onTest() {
		
	}


	
}
