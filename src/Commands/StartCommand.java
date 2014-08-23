package Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import TTT.GameStatus;
import TTT.TTT;

public class StartCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("start")) {
			if (TTT.Status == GameStatus.Lobby) {
				if (cs.isOp()) {
					TTT.Timer = 11;
					Bukkit.broadcastMessage("§8[§4TTT§8] §7Das Spiel wurde gestartet!");
				}
			}
		}
		return true;
	}

}
