package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import Teams.Traitor;

public class Testcmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label,
			String[] arg) {
		if (label.equalsIgnoreCase("packetsend")) {
			
		}
		return false;
	}

}
