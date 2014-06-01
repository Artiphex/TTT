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
			
				if (cs.isOp()) {

					LootBlocks.Blocktest();

					Bukkit.broadcastMessage("§8[§4TTT§8] §7All Skins are §bupdated!");
				}
			
		}
		return true;
	}

}
