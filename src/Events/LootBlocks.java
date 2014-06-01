package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Skull;
import org.bukkit.event.Listener;

public class LootBlocks implements Listener {
	public static void Blocktest() {
		final Location Skull = (new Location(Bukkit.getWorld("world"), 1, 72, -58));
		Skull s = (Skull)Skull.getBlock().getState();
		s.setOwner("GhostPinyin");
		s.update();
	}
}
