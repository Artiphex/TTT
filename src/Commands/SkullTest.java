package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Events.LootBlocks;

public class SkullTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("update")) {
			Bukkit.broadcastMessage("§4§l|||");
			LootBlocks.LootSet();
			Bukkit.broadcastMessage("§2§l|||");
		}
		return true;
	}

}
