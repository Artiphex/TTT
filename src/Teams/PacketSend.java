package Teams;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import net.minecraft.server.v1_7_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_7_R3.PacketPlayOutScoreboardTeam;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PacketSend {
	public static void SendPacket() {
		Set players = new HashSet();


		PacketPlayOutNamedEntitySpawn packet = new PacketPlayOutNamedEntitySpawn();
		setPrivateValue(packet, "a", "Traitor");
		setPrivateValue(packet, "f", 0);
		setPrivateValue(packet, "b", "Traitor");
		setPrivateValue(packet, "c", "§4");
		setPrivateValue(packet, "d", "");
		setPrivateValue(packet, "g", 0);
		setPrivateValue(packet, "e", (Collection) players);
		
		for (Player onlineCrafters : Bukkit.getOnlinePlayers()) {
			((CraftPlayer)onlineCrafters).getHandle().playerConnection.sendPacket(packet);
		}


	}
	
	public static void setPrivateValue(Object obj, String key, Object value) {
		 try {
		  Field field = obj.getClass().getDeclaredField(key);
		  field.setAccessible(true);
		  field.set(obj, value);
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		}
	

	
}
