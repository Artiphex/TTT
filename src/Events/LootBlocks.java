package Events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Skull;

public class LootBlocks {
public static void LootSet() {
		
		//final Location SkullT = (new Location(Bukkit.getWorld("world"), -58, 43, 2));	
		//Skull s = (Skull)SkullT.getBlock().getState();
		//s.setOwner("GhostPinyin");
		//s.update();
		
		
		
		//IntelliJ
		final Location IntelliJ1 = (new Location(Bukkit.getWorld("world"), 83, 31, 829));
		final Location IntelliJ2 = (new Location(Bukkit.getWorld("world"), 75, 29, 823));
		final Location IntelliJ3 = (new Location(Bukkit.getWorld("world"), 81, 21, 815));
		final Location IntelliJ4 = (new Location(Bukkit.getWorld("world"), 87, 21, 803));
		final Location IntelliJ5 = (new Location(Bukkit.getWorld("world"), 65, 22, 791));
		final Location IntelliJ6 = (new Location(Bukkit.getWorld("world"), 38, 10, 834));
		final Location IntelliJ7 = (new Location(Bukkit.getWorld("world"), 83, 27, 824));
		
		IntelliJ1.getBlock().setType(Material.SKULL);
		IntelliJ2.getBlock().setType(Material.SKULL);
		IntelliJ3.getBlock().setType(Material.SKULL);
		IntelliJ4.getBlock().setType(Material.SKULL);
		IntelliJ5.getBlock().setType(Material.SKULL);
		IntelliJ6.getBlock().setType(Material.SKULL);
		IntelliJ7.getBlock().setType(Material.SKULL);
		
		Skull I1 = (Skull)IntelliJ1.getBlock().getState();
		Skull I2 = (Skull)IntelliJ2.getBlock().getState();
		Skull I3 = (Skull)IntelliJ3.getBlock().getState();
		Skull I4 = (Skull)IntelliJ4.getBlock().getState();
		Skull I5 = (Skull)IntelliJ5.getBlock().getState();
		Skull I6 = (Skull)IntelliJ6.getBlock().getState();
		Skull I7 = (Skull)IntelliJ7.getBlock().getState();
		
		I1.setOwner("IntelliJ");
		I2.setOwner("IntelliJ");
		I3.setOwner("IntelliJ");
		I4.setOwner("IntelliJ");
		I5.setOwner("IntelliJ");
		I6.setOwner("IntelliJ");
		I7.setOwner("IntelliJ");
		
		I1.update();
		I2.update();
		I3.update();
		I4.update();
		I5.update();
		I6.update();
		I7.update();
		
		
		//Abmahnung
		final Location Abmahnung1 = (new Location(Bukkit.getWorld("world"), 85, 28, 822));
		final Location Abmahnung2 = (new Location(Bukkit.getWorld("world"), 40, 9, 778));
		final Location Abmahnung3 = (new Location(Bukkit.getWorld("world"), 7, 32, 792));
		final Location Abmahnung4 = (new Location(Bukkit.getWorld("world"), 59, 5, 848));
		final Location Abmahnung5 = (new Location(Bukkit.getWorld("world"), 5, 23, 789));
		
		Abmahnung1.getBlock().setType(Material.SKULL);
		Abmahnung2.getBlock().setType(Material.SKULL);
		Abmahnung3.getBlock().setType(Material.SKULL);
		Abmahnung4.getBlock().setType(Material.SKULL);
		Abmahnung5.getBlock().setType(Material.SKULL);
		
		Skull A1 = (Skull)Abmahnung1.getBlock().getState();
		Skull A2 = (Skull)Abmahnung2.getBlock().getState();
		Skull A3 = (Skull)Abmahnung3.getBlock().getState();
		Skull A4 = (Skull)Abmahnung4.getBlock().getState();
		Skull A5 = (Skull)Abmahnung5.getBlock().getState();
		
		A1.setOwner("Abmahnung");
		A2.setOwner("Abmahnung");
		A3.setOwner("Abmahnung");
		A4.setOwner("Abmahnung");
		A5.setOwner("Abmahnung");
		
		A1.update();
		A2.update();
		A3.update();
		A4.update();
		A5.update();
		
		//FallingDiamond
		final Location FallingDiamond1 = (new Location(Bukkit.getWorld("world"), 82, 31, 828));
		final Location FallingDiamond2 = (new Location(Bukkit.getWorld("world"), 25, 4, 846));
		final Location FallingDiamond3 = (new Location(Bukkit.getWorld("world"), 24, 4, 845));
		final Location FallingDiamond4 = (new Location(Bukkit.getWorld("world"), 1, 21, 796));
		//final Location FallingDiamond5 = (new Location(Bukkit.getWorld("world"), 1, 17, 729));
				
		FallingDiamond1.getBlock().setType(Material.SKULL);
		FallingDiamond2.getBlock().setType(Material.SKULL);
		FallingDiamond3.getBlock().setType(Material.SKULL);
		FallingDiamond4.getBlock().setType(Material.SKULL);
		//FallingDiamond5.getBlock().setType(Material.SKULL);
				
		Skull FD1 = (Skull)FallingDiamond1.getBlock().getState();
		Skull FD2 = (Skull)FallingDiamond2.getBlock().getState();
		Skull FD3 = (Skull)FallingDiamond3.getBlock().getState();
		Skull FD4 = (Skull)FallingDiamond4.getBlock().getState();
		//Skull FD5 = (Skull)FallingDiamond5.getBlock().getState();
				
		FD1.setOwner("FallingDiamond");
		FD2.setOwner("FallingDiamond");
		FD3.setOwner("FallingDiamond");
		FD4.setOwner("FallingDiamond");
		//FD5.setOwner("FallingDiamond");
				
		FD1.update();
		FD2.update();
		FD3.update();
		FD4.update();
		//FD5.update();
		
		
		//KlausurThaler144
		final Location KlausurThaler1 = (new Location(Bukkit.getWorld("world"), 82, 23, 827));
		final Location KlausurThaler2 = (new Location(Bukkit.getWorld("world"), 84, 26, 831));
		final Location KlausurThaler3 = (new Location(Bukkit.getWorld("world"), 49, 18, 831));
		final Location KlausurThaler4 = (new Location(Bukkit.getWorld("world"), 48, 18, 832));
		final Location KlausurThaler5 = (new Location(Bukkit.getWorld("world"), 62, 12, 814));
						
		KlausurThaler1.getBlock().setType(Material.SKULL);
		KlausurThaler2.getBlock().setType(Material.SKULL);
		KlausurThaler3.getBlock().setType(Material.SKULL);
		KlausurThaler4.getBlock().setType(Material.SKULL);
		KlausurThaler5.getBlock().setType(Material.SKULL);
					
		Skull KT1 = (Skull)KlausurThaler1.getBlock().getState();
		Skull KT2 = (Skull)KlausurThaler2.getBlock().getState();
		Skull KT3 = (Skull)KlausurThaler3.getBlock().getState();
		Skull KT4 = (Skull)KlausurThaler4.getBlock().getState();
		Skull KT5 = (Skull)KlausurThaler5.getBlock().getState();
						
		KT1.setOwner("KlausurThaler144");
		KT2.setOwner("KlausurThaler144");
		KT3.setOwner("KlausurThaler144");
		KT4.setOwner("KlausurThaler144");
		KT5.setOwner("KlausurThaler144");
						
		KT1.update();
		KT2.update();
		KT3.update();
		KT4.update();
		KT5.update();
			
			
		//VareidePlays
		final Location VareidePlays1 = (new Location(Bukkit.getWorld("world"), 6, 26, 791));
		final Location VareidePlays2 = (new Location(Bukkit.getWorld("world"), 7, 32, 793));
		final Location VareidePlays3 = (new Location(Bukkit.getWorld("world"), 0, 40, 794));
		final Location VareidePlays4 = (new Location(Bukkit.getWorld("world"), 0, 40, 792));
		final Location VareidePlays5 = (new Location(Bukkit.getWorld("world"), 33, 10, 818));
						
		VareidePlays1.getBlock().setType(Material.SKULL);
		VareidePlays2.getBlock().setType(Material.SKULL);
		VareidePlays3.getBlock().setType(Material.SKULL);
		VareidePlays4.getBlock().setType(Material.SKULL);
		VareidePlays5.getBlock().setType(Material.SKULL);
				
		Skull VP1 = (Skull)VareidePlays1.getBlock().getState();
		Skull VP2 = (Skull)VareidePlays2.getBlock().getState();
		Skull VP3 = (Skull)VareidePlays3.getBlock().getState();
		Skull VP4 = (Skull)VareidePlays4.getBlock().getState();
		Skull VP5 = (Skull)VareidePlays5.getBlock().getState();
						
		VP1.setOwner("VareidePlays");
		VP2.setOwner("VareidePlays");
		VP3.setOwner("VareidePlays");
		VP4.setOwner("VareidePlays");
		VP5.setOwner("VareidePlays");
						
		VP1.update();
		VP2.update();
		VP3.update();
		VP4.update();
		VP5.update();
			
			
		//Nottrex
		final Location Nottrex1 = (new Location(Bukkit.getWorld("world"), 40, 10, 821));
		final Location Nottrex2 = (new Location(Bukkit.getWorld("world"), 64, 22, 799));
		final Location Nottrex3 = (new Location(Bukkit.getWorld("world"), 62, 23, 840));
		final Location Nottrex4 = (new Location(Bukkit.getWorld("world"), 37, 4, 827));
		final Location Nottrex5 = (new Location(Bukkit.getWorld("world"), 69, 19, 831));
		final Location Nottrex6 = (new Location(Bukkit.getWorld("world"), 30, 17, 803));
						
		Nottrex1.getBlock().setType(Material.SKULL);
		Nottrex2.getBlock().setType(Material.SKULL);
		Nottrex3.getBlock().setType(Material.SKULL);
		Nottrex4.getBlock().setType(Material.SKULL);
		Nottrex5.getBlock().setType(Material.SKULL);
		Nottrex6.getBlock().setType(Material.SKULL);
					
		Skull N1 = (Skull)Nottrex1.getBlock().getState();
		Skull N2 = (Skull)Nottrex2.getBlock().getState();
		Skull N3 = (Skull)Nottrex3.getBlock().getState();
		Skull N4 = (Skull)Nottrex4.getBlock().getState();
		Skull N5 = (Skull)Nottrex5.getBlock().getState();
		Skull N6 = (Skull)Nottrex6.getBlock().getState();
						
		N1.setOwner("Nottrex");
		N2.setOwner("Nottrex");
		N3.setOwner("Nottrex");
		N4.setOwner("Nottrex");
		N5.setOwner("Nottrex");
		N6.setOwner("Nottrex");
					
		N1.update();
		N2.update();
		N3.update();
		N4.update();
		N5.update();
		N6.update();

		
	}
	
}
