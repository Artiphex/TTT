package de.iron42.TTT;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TraitorShop implements Listener {
	
	public Inventory tInv = null;
	
	@EventHandler
	public void TraitorBow(PlayerInteractEvent e) {
		ItemStack traitor = new ItemStack (Material.BOW);
		ItemMeta traitorMeta = traitor.getItemMeta();
		traitorMeta.setDisplayName("§cTraitor Shop");
		traitor.setItemMeta(traitorMeta);
		
		ItemStack medipack = new ItemStack (Material.INK_SACK, 1);
		medipack.setDurability((short) 1);
		ItemMeta medipackMeta = medipack.getItemMeta();
		medipackMeta.setDisplayName("§cMedipack");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("§a1 Point");
		medipackMeta.setLore(Lore);
		medipack.setItemMeta(medipackMeta);
		
		ItemStack radar = new ItemStack (Material.COMPASS);
		ItemMeta radarMeta = radar.getItemMeta();
		radarMeta.setDisplayName("§cRadar");
		radar.setItemMeta(radarMeta);
		
		ItemStack ca = new ItemStack (Material.MONSTER_EGG);
		ca.setDurability((short) 50);
		ItemMeta caMeta = ca.getItemMeta();
		caMeta.setDisplayName("§cCreeper Arrow");
		ca.setItemMeta(caMeta);
		
		ItemStack dgs = new ItemStack (Material.SKULL_ITEM);
		ItemMeta dgsMeta = dgs.getItemMeta();
		dgsMeta.setDisplayName("§cDisguiser");
		dgs.setItemMeta(dgsMeta);
		
		ItemStack ts = new ItemStack (Material.REDSTONE_LAMP_OFF);
		ItemMeta tsMeta = ts.getItemMeta();
		tsMeta.setDisplayName("§cTester-Spoofer");
		ts.setItemMeta(tsMeta);
		
		ItemStack fc = new ItemStack (Material.CHEST);
		ItemMeta fcMeta = fc.getItemMeta();
		fcMeta.setDisplayName("§cFake Chest");
		fc.setItemMeta(fcMeta);
		
		ItemStack tp = new ItemStack (Material.PORTAL);
		ItemMeta tpMeta = tp.getItemMeta();
		tpMeta.setDisplayName("§cTeleporter");
		tp.setItemMeta(tpMeta);
		
		ItemStack c4 = new ItemStack (Material.TNT);
		ItemMeta c4Meta = c4.getItemMeta();
		c4Meta.setDisplayName("§cC4");
		c4.setItemMeta(c4Meta);
		
		ItemStack knive = new ItemStack (Material.DIAMOND_SWORD);
		ItemMeta kniveMeta = knive.getItemMeta();
		kniveMeta.setDisplayName("§cKnive");
		knive.setItemMeta(kniveMeta);
		
		ItemStack jh = new ItemStack (Material.SULPHUR);
		ItemMeta jhMeta = knive.getItemMeta();
		jhMeta.setDisplayName("§cJihadBomb");
		jh.setItemMeta(jhMeta);
		
		ItemStack fg = new ItemStack (Material.FIREBALL);
		ItemMeta fgMeta = fg.getItemMeta();
		fgMeta.setDisplayName("§cFireGrenade");
		fg.setItemMeta(fgMeta);
		
		ItemStack sg = new ItemStack (Material.FIREWORK_CHARGE);
		ItemMeta sgMeta = sg.getItemMeta();
		sgMeta.setDisplayName("§cSmokeGrenade");
		sg.setItemMeta(sgMeta);
		
		
		
		Player p = e.getPlayer();
		
		if (e.getItem() != null && e.getItem().getType() == Material.BOW) {
			if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().getItemMeta().getDisplayName().equals("§cTraitor Shop")) {
				tInv = Bukkit.getServer().createInventory(null, 18, "§4Traitor Shop §8Points: " + (ShopConfig.tShop.gettShop(p)));
				
				tInv.setItem(0, medipack);
				tInv.setItem(1, radar);
				tInv.setItem(2, ca);
				tInv.setItem(3, dgs);
				tInv.setItem(4, ts);
				tInv.setItem(5, fc);
				tInv.setItem(6, tp);
				tInv.setItem(7, c4);
				tInv.setItem(8, knive);
				tInv.setItem(9, jh);
				tInv.setItem(10, fg);
				tInv.setItem(11, sg);
				
				
				p.openInventory(tInv);
				}
			}
		}
	}
	
	@EventHandler
	public void onInvClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		ItemStack medipack = new ItemStack (Material.INK_SACK, 1);
		medipack.setDurability((short) 1);
		ItemMeta medipackMeta = medipack.getItemMeta();
		medipackMeta.setDisplayName("§cMedipack");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("§a1 Point");
		medipackMeta.setLore(Lore);
		medipack.setItemMeta(medipackMeta);
		
		ItemStack radar = new ItemStack (Material.COMPASS);
		ItemMeta radarMeta = radar.getItemMeta();
		radarMeta.setDisplayName("§cRadar");
		radar.setItemMeta(radarMeta);
		
		ItemStack ca = new ItemStack (Material.MONSTER_EGG);
		ca.setDurability((short) 50);
		ItemMeta caMeta = ca.getItemMeta();
		caMeta.setDisplayName("§cCreeper Arrow");
		ca.setItemMeta(caMeta);
		
		ItemStack dgs = new ItemStack (Material.SKULL_ITEM);
		ItemMeta dgsMeta = dgs.getItemMeta();
		dgsMeta.setDisplayName("§cDisguiser");
		dgs.setItemMeta(dgsMeta);
		
		ItemStack ts = new ItemStack (Material.REDSTONE_LAMP_OFF);
		ItemMeta tsMeta = ts.getItemMeta();
		tsMeta.setDisplayName("§cTester-Spoofer");
		ts.setItemMeta(tsMeta);
		
		ItemStack fc = new ItemStack (Material.CHEST);
		ItemMeta fcMeta = fc.getItemMeta();
		fcMeta.setDisplayName("§cFake Chest");
		fc.setItemMeta(fcMeta);
		
		ItemStack tp = new ItemStack (Material.PORTAL);
		ItemMeta tpMeta = tp.getItemMeta();
		tpMeta.setDisplayName("§cTeleporter");
		tp.setItemMeta(tpMeta);
		
		ItemStack c4 = new ItemStack (Material.TNT);
		ItemMeta c4Meta = c4.getItemMeta();
		c4Meta.setDisplayName("§cC4");
		c4.setItemMeta(c4Meta);
		
		ItemStack knive = new ItemStack (Material.DIAMOND_SWORD);
		ItemMeta kniveMeta = knive.getItemMeta();
		kniveMeta.setDisplayName("§cKnive");
		knive.setItemMeta(kniveMeta);
		
		ItemStack jh = new ItemStack (Material.SULPHUR);
		ItemMeta jhMeta = knive.getItemMeta();
		jhMeta.setDisplayName("§cJihadBomb");
		jh.setItemMeta(jhMeta);
		
		ItemStack fg = new ItemStack (Material.FIREBALL);
		ItemMeta fgMeta = fg.getItemMeta();
		fgMeta.setDisplayName("§cFireGrenade");
		fg.setItemMeta(fgMeta);
		
		ItemStack sg = new ItemStack (Material.FIREWORK_CHARGE);
		ItemMeta sgMeta = sg.getItemMeta();
		sgMeta.setDisplayName("§cSmokeGrenade");
		sg.setItemMeta(sgMeta);
		
		if (e.getInventory().getName().equalsIgnoreCase("§4Traitor Shop §8Points: " + (ShopConfig.tShop.gettShop(p)))) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.INK_SACK) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
				if (ShopConfig.tShop.gettShop(p) >= 1) {
					p.getInventory().addItem(medipack);
					ShopConfig.tShop.removetShop(1, p);
					p.closeInventory();
				}
			}
			
			if (e.getCurrentItem().getType() == Material.COMPASS) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.MONSTER_EGG) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.SKULL_ITEM) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.REDSTONE_LAMP_OFF) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.CHEST) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.PORTAL) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.TNT) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.SULPHUR) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.FIREBALL) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
			
			if (e.getCurrentItem().getType() == Material.FIREWORK_CHARGE) {
				p.sendMessage("§8[§4TTT§8] §7Coming soon");
			}
		}
	}
	
	@EventHandler
	public void ontShopUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		
		ItemStack medipack = new ItemStack (Material.INK_SACK, 1);
		medipack.setDurability((short) 1);
		ItemMeta medipackMeta = medipack.getItemMeta();
		medipackMeta.setDisplayName("§cMedipack");
		ArrayList<String> Lore = new ArrayList<String>();
		Lore.add("§a1 Point");
		medipackMeta.setLore(Lore);
		medipack.setItemMeta(medipackMeta);
		
		ItemStack radar = new ItemStack (Material.COMPASS);
		ItemMeta radarMeta = radar.getItemMeta();
		radarMeta.setDisplayName("§cRadar");
		radar.setItemMeta(radarMeta);
		
		ItemStack ca = new ItemStack (Material.MONSTER_EGG);
		ca.setDurability((short) 50);
		ItemMeta caMeta = ca.getItemMeta();
		caMeta.setDisplayName("§cCreeper Arrow");
		ca.setItemMeta(caMeta);
		
		ItemStack dgs = new ItemStack (Material.SKULL_ITEM);
		ItemMeta dgsMeta = dgs.getItemMeta();
		dgsMeta.setDisplayName("§cDisguiser");
		dgs.setItemMeta(dgsMeta);
		
		ItemStack ts = new ItemStack (Material.REDSTONE_LAMP_OFF);
		ItemMeta tsMeta = ts.getItemMeta();
		tsMeta.setDisplayName("§cTester-Spoofer");
		ts.setItemMeta(tsMeta);
		
		ItemStack fc = new ItemStack (Material.CHEST);
		ItemMeta fcMeta = fc.getItemMeta();
		fcMeta.setDisplayName("§cFake Chest");
		fc.setItemMeta(fcMeta);
		
		ItemStack tp = new ItemStack (Material.PORTAL);
		ItemMeta tpMeta = tp.getItemMeta();
		tpMeta.setDisplayName("§cTeleporter");
		tp.setItemMeta(tpMeta);
		
		ItemStack c4 = new ItemStack (Material.TNT);
		ItemMeta c4Meta = c4.getItemMeta();
		c4Meta.setDisplayName("§cC4");
		c4.setItemMeta(c4Meta);
		
		ItemStack knive = new ItemStack (Material.DIAMOND_SWORD);
		ItemMeta kniveMeta = knive.getItemMeta();
		kniveMeta.setDisplayName("§cKnive");
		knive.setItemMeta(kniveMeta);
		
		ItemStack jh = new ItemStack (Material.SULPHUR);
		ItemMeta jhMeta = knive.getItemMeta();
		jhMeta.setDisplayName("§cJihadBomb");
		jh.setItemMeta(jhMeta);
		
		ItemStack fg = new ItemStack (Material.FIREBALL);
		ItemMeta fgMeta = fg.getItemMeta();
		fgMeta.setDisplayName("§cFireGrenade");
		fg.setItemMeta(fgMeta);
		
		ItemStack sg = new ItemStack (Material.FIREWORK_CHARGE);
		ItemMeta sgMeta = sg.getItemMeta();
		sgMeta.setDisplayName("§cSmokeGrenade");
		sg.setItemMeta(sgMeta);
		
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
			if (e.getItem().equals(medipack)) {
				p.setHealth(20.0);
				p.getInventory().remove(medipack);
				ShopConfig.tShop.removetShop(1, p);
				p.updateInventory();
				p.playSound(p.getLocation() ,Sound.LEVEL_UP, 1, 1);
			}
		}
	}
}
