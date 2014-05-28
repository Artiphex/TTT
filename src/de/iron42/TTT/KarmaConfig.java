package de.iron42.TTT;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class KarmaConfig {
	
	public static class Karma implements Listener {
		public static File file = new File("plugins/TTT", "PlayerStats.yml");
		public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		
		public static void Save() {
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	//.
		public static void setKarma(Player p, int Karma) {
			  config.set("Spieler." + p.getName() + ".Karma", Karma);
			  try {
			   config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 public static int getKarma(Player p) {
			  int karma = config.getInt("Spieler." + p.getName() + ".Karma");
			  return karma;
			 }
			 
			 public static void addKarma(int Karma, Player p) {
				 config.set("Spieler." + p.getName() + ".Karma", getKarma(p)+Karma);
			  try {
				 config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 public static void removeKarma(int Karma, Player p) {
				 config.set("Spieler." + p.getName() + ".Karma", getKarma(p)-Karma);
			  try {
				 config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 public static int getStats(String name) {
					return config.getInt("Spieler." + name + ".Karma");
				}
			 
	}


}
