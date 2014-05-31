package Teams;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import de.iron42.TTT.TTT;

public class ScoreboardTeam {
	

	public static void createScoreBoardInGame(Player p)
	  {
	    ScoreboardManager sm = Bukkit.getScoreboardManager();
	    Scoreboard board = sm.getNewScoreboard();
	    
	    Team t1 = board.registerNewTeam("Detective");
	    t1.setPrefix("§9§l");
	    Team t2 = board.registerNewTeam("nothing");
	    t2.setPrefix("§e§l");
	    Team t3 = board.registerNewTeam("Innocent");
	    t3.setPrefix("§2§l");
	    Team t4 = board.registerNewTeam("Traitor");
	    t4.setPrefix("§4§l");
	    for (String s : TTT.Detective) {
	      t1.addPlayer(Bukkit.getPlayer(s));
	    }
	    if (TTT.Traitor.contains(p.getName()))
	    {
	      for (String s : TTT.Traitor) {
	        t4.addPlayer(Bukkit.getPlayer(s));
	      }
	      for (String s : TTT.Innocent) {
	        t3.addPlayer(Bukkit.getPlayer(s));
	      }
	    }
	    else
	    {
	      for (String s : TTT.Traitor) {
	        t2.addPlayer(Bukkit.getPlayer(s));
	      }
	      for (String s : TTT.Innocent) {
	        t2.addPlayer(Bukkit.getPlayer(s));
	      }
	    }
	    p.setScoreboard(board);
	  }
	
	
}
