package Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.iron42.TTT.KarmaConfig;
import de.iron42.TTT.KarmaConfig.Karma;
import de.iron42.TTT.TTT;

public class MyKarma implements CommandExecutor {
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player player = Bukkit.getServer().getPlayer(cs.getName());
		
	    if (label.equalsIgnoreCase("Stats")) {
	        if (args.length == 0) {
	            cs.sendMessage("§8[§4TTT§8] §7You have §a" + this.getKarma(player, player.getName()) + " §7Karma." );
	            return true;
	        } else if (args.length == 1) {
	        	cs.sendMessage("§8[§4TTT§8]§7 " + args[0] + " §7has§a " + this.getKarma(player, args[0]) + " §7Karma.");
	            return true;
	        } else {
	        	 this.getKarma(player, player.getName());
	            return true;
	        }
	    }
	    return false;
	}

	public int getKarma(Player PlayerToSend, String StatsFromPlayer) {
		File file = new File("plugins/TTT", "PlayerStats.yml");
		YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
		return config.getInt("Spieler." + StatsFromPlayer + ".Karma");
		
	}
}