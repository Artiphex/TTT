package de.iron42.TTT;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Teams.PacketSend;
import Events.AutoRespawn;
import Events.BuildBreakListener;
import Events.DeathEvent;
import Events.InteractListener;
import Events.JoinQuitListener;
import Events.LobbyListener;
import Events.TraitorTest;
import Events.WeatherListener;
import Events.WinListener;


public class TTT extends JavaPlugin {
	public static int Timer = 0;
	public static GameStatus Status;
	public static TTT plugin;
	
	public static ArrayList<String> Innocent = new ArrayList<String>();
	public static ArrayList<String> Detective = new ArrayList<String>();
	public static ArrayList<String> Traitor = new ArrayList<String>();
	public static ArrayList<String> Spectator = new ArrayList<String>();
	
	public void onDisable() {
		System.out.println("[TTT] disabled");
	}
	
	public void onEnable() {
		System.out.println("[TTT] enabled");
		System.out.println("[TTT] coded by iron42");
		
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new JoinQuitListener(), this);
		pm.registerEvents(new BuildBreakListener(), this);
		pm.registerEvents(new LobbyListener(), this);
		pm.registerEvents(new TraitorTest(), this);
		pm.registerEvents(new WinListener(), this);
		pm.registerEvents(new DeathEvent(), this);
		pm.registerEvents(new AutoRespawn(), this);
		pm.registerEvents(new InteractListener(), this);
		pm.registerEvents(new WeatherListener(), this);
		
		
		this.getCommand("start").setExecutor(new Commands.StartCommand());
		this.getCommand("update").setExecutor(new Commands.SkullTest());
		
		Timer = 91;
		Status = GameStatus.Lobby;
		StartCounter();
		
		plugin = this;
		
		KarmaConfig.Karma.Save();
	}
	
	public void StartCounter() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				Timer -= 1;
				Bukkit.clearRecipes();
				if(Status == GameStatus.Lobby) {
					WorldPvP(false);
					if((Timer == 90) || (Timer == 80) || (Timer == 70) || (Timer == 60) || (Timer == 50) || (Timer == 40) || (Timer == 30) || (Timer == 20) || (Timer == 10) || (Timer == 5) || (Timer == 4) || (Timer == 3) || (Timer == 2) ) {
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The lobby ends in §e" + Timer + " §7seconds.");
					} else if (Timer == 1) {
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The lobby ends in §e" + Timer + " §7second.");
					} else if (Timer == 0) {
						if(Bukkit.getOnlinePlayers().length <= 3) {
							Bukkit.broadcastMessage("§8[§4TTT§8] §cThere are not enough players online!");
							Bukkit.broadcastMessage("§8[§4TTT§8] §cThe timer restarts...");
							Timer = 91;
							Status = GameStatus.Lobby;
						} else {
							MapTeleport();
							Bukkit.broadcastMessage("§8[§4TTT§8] §cThe grace period starts.");
							Timer = 31;
							Status = GameStatus.Peace;
						}
					}
				} else if (Status == GameStatus.Peace){
					if((Timer == 60) || (Timer == 50) || (Timer == 40) || (Timer == 30) || (Timer == 20) || (Timer == 10) || (Timer == 5) || (Timer == 4) || (Timer == 3) || (Timer == 2)) {
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The grace period ends in §c" + Timer + " §7seconds.");
						
					} else if(Timer == 1) {
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The grace period ends in §c1 §7second.");

					} else if (Timer == 0) {
						WorldPvP(true);
						Bukkit.broadcastMessage("§8[§4TTT§8] §cThe grace period is over.");
						Bukkit.broadcastMessage("§8[§4TTT§8] §aThe game starts now!");
						
						assignment();
						//TEST
						PacketSend.SendPacket();
						//TEST
						
						Status = GameStatus.Game;
						Timer = 1801;
					}
					
				} else if (Status == GameStatus.Game){
					WorldPvP(true);
					if((Timer == 1800) || (Timer == 900) || (Timer == 600) || (Timer == 300) || (Timer == 180)){
						
						StringBuilder D = new StringBuilder();
						for (int i = 0; i < Detective.size(); i++) {
						    if (i != 0) D.append(", ");
						    D.append(Detective.get(i));
						}
						Bukkit.broadcastMessage("§8[§4TTT§8] §1Detective§7: " + D.toString());
						
						StringBuilder T = new StringBuilder();
						for (int in = 0; in < Traitor.size(); in++) {
						    if (in != 0) T.append(", ");
						    T.append(Traitor.get(in));
						}
						//
						//for (Player p : ((Player) TIMV.Traitor).getName()) {
						//	Bukkit.getServer().getPlayer(p).sendMessage("§8[§3TIMV§8] §7The Traitors are: §e" + Traitor.toString());	
						//}
						//
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The game ends in §c" + Timer /60 + " §7minutes.");
					} else if ((Timer == 60) || (Timer == 50) || (Timer == 40) || (Timer == 30) || (Timer == 20) || (Timer == 10) || (Timer == 5) || (Timer == 4) || (Timer == 3) || (Timer == 2)){
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The deathmatch starts in §c" + Timer + " §7seconds.");
					} else if (Timer == 1){
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The deathmatch starts in §c" + Timer + " §7second.");
					} else if (Timer == 0) {
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The deathmatch starts now.");
						// TELEPORT
						Timer = 61;
						Status = GameStatus.Deathmatch;
					}
				} else if (Status == GameStatus.Deathmatch){
					WorldPvP(true);
					Bukkit.broadcastMessage("§4DEATHMATCH GESPERRT");
					Timer = 11;
					Status = GameStatus.Restarting;
					
				} else if (Status == GameStatus.Restarting){
					WorldPvP(false);
					//Kisten Reset
					//for (FakeMob mob : FakeMobsPlugin.getPlugin().getMobs()) 
					   //FakeMobsPlugin.getPlugin().removeMob(mob.getId());
					if((Timer == 10) || (Timer == 9) || (Timer == 8) || (Timer == 7) || (Timer == 6) || (Timer == 5) || (Timer == 4) || (Timer == 3) || (Timer == 2)){
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The server restarts in §c" + Timer + " §7seconds.");
					} else if (Timer == 1){
						Bukkit.broadcastMessage("§8[§4TTT§8] §7The server restarts in §c" + Timer + " §7second.");
					} else if (Timer == 0){
						for (Player p : Bukkit.getOnlinePlayers()) {
							p.performCommand("hub");
							for (World w : Bukkit.getWorlds()) {
								   for (Entity e : w.getEntities()) {
								     if (e instanceof Item) {
								       e.remove();
								     }
								   }
								}
							Bukkit.getServer().shutdown();
						}
					}

				}
			}
		}, 0L, 20L);
	}
	
	public void WorldPvP(boolean pvp) {
		Bukkit.getWorld("world").setPVP(pvp);
	}
	
	public void MapTeleport() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			final Location tp = (new Location(Bukkit.getWorld("world"), -60.5, 42.5, 0.5));
			p.teleport(tp);
		}
	}
	
	public void assignment() {
		  ArrayList<String> playerAssignmentList = new ArrayList<String>();
		  for (Player player : JoinQuitListener.Spieler) {
		   playerAssignmentList.add(player.getName());
		  }

		  int numberOfTraitors = playerAssignmentList.size() / 4;
		  int numberOfDetective = playerAssignmentList.size() / 8;

		  if (numberOfDetective < 1) {
		   numberOfDetective = 1;
		  }

		  for (int i = 0; i < numberOfTraitors; i++) {
		   int randomNumber = new Random()
		     .nextInt(playerAssignmentList.size());
		   Traitor.add((playerAssignmentList.get(randomNumber)));
		   playerAssignmentList.remove(randomNumber);
		  }

		  for (int i = 0; i < numberOfDetective; i++) {
		   int randomNumber = new Random()
		     .nextInt(playerAssignmentList.size());
		   Detective.add((playerAssignmentList.get(randomNumber)));
		   playerAssignmentList.remove(randomNumber);
		  }

		  Innocent.addAll(playerAssignmentList);

		  for (Player p : JoinQuitListener.Spieler) {
		   if (Innocent.contains(p.getName())) {
		    p.sendMessage("§8[§4TTT§8] §7You are §2Innocent");
		    ItemStack de = new ItemStack(
		    Material.LEATHER_CHESTPLATE, 1);
		    LeatherArmorMeta d = (LeatherArmorMeta) de.getItemMeta();
			d.setColor(Color.WHITE);
			de.setItemMeta(d);
			p.getInventory().setChestplate(de);
		   }
		   if (Traitor.contains(p.getName())) {
		    p.sendMessage("§8[§4TTT§8] §7You are §4Traitor");
		    ItemStack de = new ItemStack(
		    Material.LEATHER_CHESTPLATE, 1);
		    LeatherArmorMeta d = (LeatherArmorMeta) de.getItemMeta();
			d.setColor(Color.WHITE);
			de.setItemMeta(d);
			p.getInventory().setChestplate(de);
		   }
		   if (Detective.contains(p.getName())) {
		    p.sendMessage("§8[§4TTT§8] §7You are §1Detective");
		    ItemStack de = new ItemStack(
		      Material.LEATHER_CHESTPLATE, 1);
		    LeatherArmorMeta d = (LeatherArmorMeta) de.getItemMeta();
		    d.setColor(Color.BLUE);
		    de.setItemMeta(d);
		    p.getInventory().setChestplate(de);
		   }
		  }

		 }
}
