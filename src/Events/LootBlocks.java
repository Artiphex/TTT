package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Skull;

public class LootBlocks {
public void Blocktest() {
		final Location SkullT = (new Location(Bukkit.getWorld("world"), -58, 43, 2));
		Skull s = (Skull)SkullT.getBlock().getState();
		s.setOwner("GhostPinyin");
		s.update();
	}
	
}
