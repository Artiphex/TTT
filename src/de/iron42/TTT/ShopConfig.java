package de.iron42.TTT;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ShopConfig {

	public static class tShop  {
		public static File file = new File("plugins/TTT", "tShop.yml");
		public static FileConfiguration config = YamlConfiguration.loadConfiguration(file);

		
		public static void Save() {
			try {
				config.save(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	//.
		public static void settShop(Player p, int Points) {
			  config.set("Spieler." + p.getName() + ".Points", Points);
			  try {
			   config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 public static int gettShop(Player p) {
			  int Point = config.getInt("Spieler." + p.getName() + ".Points");
			  return Point;
			 }
			 
			 public static void addtShop(int Points, Player p) {
				 config.set("Spieler." + p.getName() + ".Points", gettShop(p) + Points);
			  try {
				 config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 public static void removetShop(int Points, Player p) {
				 config.set("Spieler." + p.getName() + ".Points", gettShop(p)-Points);
			  try {
				 config.save(file);
			  } catch (IOException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
			 }
			 
			 
	}
}
