package fr.taonix.thyrmen.trades;



import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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
import org.bukkit.event.inventory.InventoryClickEvent;

public class Magie implements Listener {



	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();

		if(event.getClickedBlock() != null && action == Action.RIGHT_CLICK_BLOCK)
		{

			BlockState bs = event.getClickedBlock().getState();
			if(bs instanceof Chest)
			{



				Chest chest = (Chest) bs;

				if(chest.getCustomName().equals("M1S")) {

					Inventory invshop1 = Bukkit.createInventory(null, 9, "§3§lMagasin de Magie 1");


					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);

					ItemStack rslt = new ItemStack(Material.LAPIS_LAZULI, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("§a2 Lapis - shop");
					Mrslt.setLore(Arrays.asList("Nécésite 9 emeraudes"));
					rslt.setItemMeta(Mrslt);

					ItemStack rslt3 = new ItemStack(Material.BOOK, 1);
					ItemMeta Mrslt3 = rslt3.getItemMeta();
					Mrslt3.setDisplayName("§aLivre - shop");
					Mrslt3.setLore(Arrays.asList("Nécésite 2 émeraudes"));
					rslt3.setItemMeta(Mrslt3);


					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§lMagicien :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","Ici tu pouras","m'achetez toutes sortes","De reliques ou d'objet magiques"));
					q.setItemMeta(Mq);

					//Acheter / vendre
					invshop1.setItem(7, rslt);
					invshop1.setItem(0, quit);
					invshop1.setItem(1, q);
					invshop1.setItem(8, rslt3);




					player.openInventory(invshop1);




				}

			}

		}

	}//fin player interact

	@EventHandler
	public void onClick(InventoryClickEvent event) {

		Inventory invshop1 = event.getInventory();
		//Inventory acheter1 = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();


		if(current == null) return;


		if(current.getType() ==  Material.BARRIER && current.getItemMeta().getDisplayName().equalsIgnoreCase("§4§lQuitter")) {
			event.setCancelled(true);
			player.closeInventory();

		}
		ItemStack rslt3 = new ItemStack(Material.LAPIS_LAZULI, 2);

		ItemStack rslt = new ItemStack(Material.BOOK, 1);


		if(current.getType() ==  Material.LAPIS_LAZULI && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a2 Lapis - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 9) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt3);
				player.updateInventory();
			}
			player.closeInventory();

		}

		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aLivre - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 2) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt);
				player.updateInventory();
			}
			player.closeInventory();

		}





		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lMagicien :")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openInventory(invshop1);
		}





	}





}//fin de inventory click event
