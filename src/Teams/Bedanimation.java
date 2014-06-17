package Teams;

import java.lang.reflect.Field;

import net.minecraft.server.v1_7_R3.PacketPlayOutBed;
import net.minecraft.server.v1_7_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.util.com.mojang.authlib.GameProfile;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Bedanimation {
	  public static void launchBedAnimation(Player p) {
		   for(Player all : Bukkit.getOnlinePlayers()) {
		   PacketPlayOutNamedEntitySpawn a = new PacketPlayOutNamedEntitySpawn();
		         setPrivateValue(a, "a", -p.getEntityId()-1);
		         setPrivateValue(a, "b", new GameProfile(p.getUniqueId(), p.getName())); 
		         setPrivateValue(a, "c", (int) (p.getLocation().getX() * 32.0D)); 
		         setPrivateValue(a, "d", (int) (p.getLocation().getY() * 32.0D)); 
		         setPrivateValue(a, "e", (int) (p.getLocation().getZ() * 32.0D));
		         setPrivateValue(a, "f", (byte) ((int) (0 * 256.0F / 360.0F))); 
		         setPrivateValue(a, "g", (byte) ((int) (0 * 256.0F / 360.0F))); 
		         setPrivateValue(a, "h", 0); 
		         setPrivateValue(a, "i", ((CraftPlayer)p).getHandle().getDataWatcher()); 
		         ((CraftPlayer)all).getHandle().playerConnection.sendPacket(a);
		         
		         PacketPlayOutBed b = new PacketPlayOutBed();
		         setPrivateValue(b, "a", -p.getEntityId()-1);
		         setPrivateValue(b, "b", p.getLocation().getBlockX());
		         setPrivateValue(b, "c", p.getLocation().getBlockY()); 
		         setPrivateValue(b, "d", p.getLocation().getBlockZ());
		         ((CraftPlayer)all).getHandle().playerConnection.sendPacket(b);
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
