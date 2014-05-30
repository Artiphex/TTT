package Teams;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
import org.kitteh.tag.TagAPI;

public class Tags implements Listener {
	  @EventHandler


		  public void onNameTag(AsyncPlayerReceiveNameTagEvent event) {
		    event.setTag(event.getNamedPlayer().getName());
		    if ((de.iron42.TTT.TTT.Traitor.contains(event.getNamedPlayer().getName())) && (de.iron42.TTT.TTT.Traitor.contains(event.getPlayer().getName()))) {
		      event.setTag(ChatColor.DARK_RED +  event.getNamedPlayer().getName());
		      TagAPI.refreshPlayer(event.getPlayer());
		      TagAPI.refreshPlayer(event.getPlayer());
		    }
		    if ((de.iron42.TTT.TTT.Innocent.contains(event.getNamedPlayer().getName())) && de.iron42.TTT.TTT.Traitor.contains(event.getPlayer().getName())) {
		      event.setTag(ChatColor.WHITE + event.getNamedPlayer().getName());
		      TagAPI.refreshPlayer(event.getPlayer());
		      TagAPI.refreshPlayer(event.getPlayer());
		    }
		  

	  }

}
