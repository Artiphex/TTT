package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Skull;

public class LootBlocks {
	public static void Blocktest() {
		final Location Skull = (new Location(Bukkit.getWorld("world"), -58, 43, 2));
		Skull s = (Skull)Skull.getBlock().getState();
		s.setOwner("GhostPinyin");
		s.update();
	}
}
