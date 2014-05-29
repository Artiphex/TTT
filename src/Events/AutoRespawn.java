package Events;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R1.EntityPlayer;
import net.minecraft.server.v1_7_R1.EnumClientCommand;
import net.minecraft.server.v1_7_R1.PacketPlayInClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_7_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import de.iron42.TTT.TTT;

public class AutoRespawn implements Listener {

	public static void autoRespawn(final Player player) {
		Bukkit.getScheduler().scheduleSyncDelayedTask(TTT.plugin,
				new Runnable() {
					public void run() {
						try {
							EntityPlayer ePlayer = ((CraftPlayer) player)
									.getHandle();
							PacketPlayInClientCommand packet = new PacketPlayInClientCommand();

							Field field = PacketPlayInClientCommand.class
									.getDeclaredField("a");
							field.setAccessible(true);
							field.set(packet, EnumClientCommand.PERFORM_RESPAWN);
							ePlayer.playerConnection.a(packet);
						} catch (Exception e) {
							TTT.plugin.getLogger().warning(
									"Eventuell falsche Minecraft Version? "
											+ e.getMessage());
						}
					}
				}, 20L);
	}

	@EventHandler
	public void On(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		e.setRespawnLocation(loc);

		// TEST
		p.hidePlayer(p);
	}

}
