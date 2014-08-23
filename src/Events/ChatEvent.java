package Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import TTT.GameStatus;
import TTT.TTT;

public class ChatEvent implements Listener {
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		
		if (JoinQuitListener.Spieler.contains(e.getPlayer())) {
			if (p.hasPermission("chat.color")) {
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
				e.getPlayer().setDisplayName("§4" + e.getPlayer().getName());
				e.setFormat("%1$s§7 » §f%2$s");
			} else if (p.hasPermission("chat.player")) {
				p.setDisplayName("§a" + e.getPlayer().getName());
				e.setFormat("%1$s§7 » §f%2$s");
			} else if (e.getPlayer().hasPermission("chat.yt")) {
				p.setDisplayName("§5" + e.getPlayer().getName());
				e.setFormat("%1$s§7 » §f%2$s");
			} else if (e.getPlayer().hasPermission("chat.premium")) {
				p.setDisplayName("§6" + e.getPlayer().getName());
				e.setFormat("%1$s§7 » §f%2$s");
			}
		} else if (TTT.Spectator.contains(e.getPlayer().getName())) {
			String dc;
			String dcsender;
			e.setCancelled(true);
			dc = e.getMessage();
			dcsender = e.getPlayer().getName();
			
			if (TTT.Status == GameStatus.Game || TTT.Status == GameStatus.Deathmatch) {
				for (Player ps : Bukkit.getOnlinePlayers()) {
					if (TTT.Spectator.contains(ps.getName())) {
						ps.getPlayer().sendMessage("§4X§7 " + dcsender + "»§f " + dc);
					}
				}
			} else {
				for (Player ps : Bukkit.getOnlinePlayers()) {
						ps.getPlayer().sendMessage("§4X§7 " + dcsender + "»§f " + dc);
					}
				}

			}
		}
}
