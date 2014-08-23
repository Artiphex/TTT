package Commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import TTT.GameStatus;
import TTT.ShopConfig;
import TTT.TTT;
import Events.LootBlocks;

public class SkullTest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs.isOp()) {
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
				
				for (Player p : Bukkit.getOnlinePlayers()) {
					ShopConfig.tShop.settShop(p, 0);
				}
				Bukkit.broadcastMessage("§2§l|||");
			}
		}
		return false;

	}

}
