package Teams;

import org.bukkit.Color;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
 
import com.comphenix.protocol.Packets;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ConnectionSide;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

import de.iron42.TTT.TTT;

public class LeatherTeam implements Listener {
	
	public static void onTraitorLeather() {
		TTT.manager.addPacketListener(new PacketAdapter(TTT.plugin, ConnectionSide.SERVER_SIDE,
                Packets.Server.ENTITY_EQUIPMENT) {
            @Override
            public void onPacketSending(PacketEvent event) {
                PacketContainer packet = event.getPacket();
 
                ItemStack stack = packet.getItemModifier().read(0);
 
                // Only modify leather armor
                if (stack != null && stack.getType().name().contains("LEATHER")) {
 
                    // The problem turned out to be that certain Minecraft functions update
                    // every player with the same packet for an equipment, whereas other
                    // methods update the equipment with a different packet per player.
 
                    // To fix this, we'll simply clone the packet before we modify it
                    packet = event.getPacket().deepClone();
                    event.setPacket(packet);
                    stack = packet.getItemModifier().read(0);
 
                    // Color that depends on the player's name
                    String recieverName = event.getPlayer().getName();
                    int color = recieverName.hashCode() & 0xFFFFFF;
 
                    // Update the color
                    LeatherArmorMeta meta = (LeatherArmorMeta) stack.getItemMeta();
                    meta.setColor(Color.RED);
                    stack.setItemMeta(meta);
                }
            }
        });
	}
}
