package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;

public class LootBlocks {
	public static void Blocktest() {
		final Location Skull = (new Location(Bukkit.getWorld("world"), -58, 43, 2));
		Skull s = (Skull)Skull.getBlock().getState();
		s.setOwner("GhostPinyin");
		s.update();
	}
	
	public static void OwnerTest() {
		final Location Skull = (new Location(Bukkit.getWorld("world"), 82, 31, 828));
		BlockState Block;
		Skull s = (Skull)Skull.getBlock().getState();
		Block = s.getBlock().getState();
		Bukkit.broadcastMessage("§cDer Block trägt den Namen" + Block);
	}
}
