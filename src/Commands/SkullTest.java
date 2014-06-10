package Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import de.iron42.TTT.GameStatus;
import de.iron42.TTT.TTT;
import Events.LootBlocks;

public class SkullTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("update")) {
			Bukkit.broadcastMessage("§4§l|||");
			LootBlocks.LootSet();
			TTT.Status = GameStatus.Restarting;
			TTT.Timer = 11;
			for (World world : Bukkit.getWorlds()) {
				 for (Entity entity : world.getEntities()) {
			            if (entity.getType() == EntityType.ARROW) {
			                entity.remove();
			            }
			        }
			}
			Bukkit.broadcastMessage("§2§l|||");
		}
		return true;
	}

}
