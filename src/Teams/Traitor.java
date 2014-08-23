package Teams;

import java.lang.reflect.Field;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_7_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_7_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.minecraft.server.v1_7_R3.PacketPlayOutEntityEquipment;

public class Traitor {

	public static void onTShow(Player p) {
		for (Player all : Bukkit.getOnlinePlayers()) {
			if (TTT.TTT.Traitor.contains(all.getName())) {
				 ItemStack st = new ItemStack(Material.LEATHER_CHESTPLATE);
	             LeatherArmorMeta meta = (LeatherArmorMeta) st.getItemMeta();
	             meta.setColor(Color.RED);
	             st.setItemMeta(meta);
				
				new net.minecraft.server.v1_7_R3.ItemStack(net.minecraft.server.v1_7_R3.Items.LEATHER_CHESTPLATE);
				
				CraftItemStack.asNMSCopy(st);
				
				PacketPlayOutEntityEquipment traitorshow = new PacketPlayOutEntityEquipment();
				setPrivateValue(traitorshow, "a", p.getEntityId());
				setPrivateValue(traitorshow, "b", 3);
				setPrivateValue(traitorshow, "c", CraftItemStack.asNMSCopy(st));
				
				((CraftPlayer)all).getHandle().playerConnection.sendPacket(traitorshow);
				 
			}
			

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
