package fr.taonix.thyrmen;



import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuLobby implements Listener {



	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();
		
		if(it == null) return;

		if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§6§lMenu")) {


					Inventory menup = Bukkit.createInventory(null, 27, "§4§lMenu de §6§lValhownya");


					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lSortir");
					quit.setItemMeta(Mquit);
					
					ItemStack dms = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
					ItemMeta Mdms = dms.getItemMeta();
					Mdms.setDisplayName("§c.");
					dms.setItemMeta(Mdms);
					
					ItemStack in = new ItemStack(Material.IRON_NUGGET, 1);
					ItemMeta Min = in.getItemMeta();
					Min.setDisplayName("§c.");
					in.setItemMeta(Min);
					
					ItemStack io = new ItemStack(Material.GOLD_NUGGET, 1);
					ItemMeta Mio = io.getItemMeta();
					Mio.setDisplayName("§c.");
					io.setItemMeta(Mio);

					ItemStack thyrmen = new ItemStack(Material.CRAFTING_TABLE, 1);
					ItemMeta Mthyrmen = thyrmen.getItemMeta();
					Mthyrmen.setDisplayName("§2Thyrmen");
					Mthyrmen.setLore(Arrays.asList("","Monde principale"));
					thyrmen.setItemMeta(Mthyrmen);
					
					ItemStack ep = new ItemStack(Material.GOLDEN_SWORD, 1);
					ItemMeta Mep = ep.getItemMeta();
					Mep.setDisplayName("§2PVP");
					Mep.setLore(Arrays.asList("","Monde arène"));
					ep.setItemMeta(Mep);


					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§lGuide :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","","Ici tu pouras te téléporé","dans tout les mondes !"));
					q.setItemMeta(Mq);

					//Acheter / vendre
					menup.setItem(0, dms);
					menup.setItem(1, dms);
					menup.setItem(2, dms);
					menup.setItem(3, dms);
					menup.setItem(4, dms);
					menup.setItem(5, dms);
					menup.setItem(6, dms);
					menup.setItem(7, dms);
					menup.setItem(8, dms);
					
					menup.setItem(18, dms);
					menup.setItem(19, dms);
					menup.setItem(20, dms);
					menup.setItem(21, dms);
					menup.setItem(22, dms);
					menup.setItem(23, dms);
					menup.setItem(24, dms);
					menup.setItem(25, dms);
					menup.setItem(26, dms);
					
					menup.setItem(10, in);
					menup.setItem(12, in);
					//menup.setItem(14, in);
					menup.setItem(16, in);
					
					menup.setItem(11, io);
					menup.setItem(15, io);
					
					menup.setItem(13, thyrmen);
					menup.setItem(9, quit);
					menup.setItem(17, q);


					menup.setItem(14, ep);

					player.openInventory(menup);
					
					
					

			


		}


		

	}//fin player interact

	@EventHandler
	public void onClick(InventoryClickEvent event) {

		Inventory menup = event.getInventory();
		//Inventory acheter1 = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();


		if(current == null) return;


		if(current.getType() ==  Material.BARRIER && current.getItemMeta().getDisplayName().equalsIgnoreCase("§4§lSortir")) {
			event.setCancelled(true);
			player.closeInventory();

		}
		
		
		Location thyrmenloc = new Location(Bukkit.getWorld("a"), 0, 80, 0);
		Location pvploc = new Location(Bukkit.getWorld("Pvp"), 0, 80, 0);
		 



		if(current.getType() ==  Material.CRAFTING_TABLE && current.getItemMeta().getDisplayName().equalsIgnoreCase("§2Thyrmen")) {
			event.setCancelled(true);
			player.teleport(thyrmenloc);
			player.closeInventory();

		}
		
		if(current.getType() ==  Material.GOLDEN_SWORD && current.getItemMeta().getDisplayName().equalsIgnoreCase("§2PVP")) {
			event.setCancelled(true);
			player.teleport(pvploc);
			player.closeInventory();

		}

		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lGuide :")) {
			event.setCancelled(true);
			player.closeInventory();

		}
		
		if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§c.")) {
			event.setCancelled(true);

		}



	}





}//fin de inventory click event

