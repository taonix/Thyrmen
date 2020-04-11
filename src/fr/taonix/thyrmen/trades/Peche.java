package fr.taonix.thyrmen.trades;



import java.awt.Color;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


import org.bukkit.event.inventory.InventoryClickEvent;

public class Peche implements Listener {



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

				if(chest.getCustomName().equals("P1S")) {

					Inventory invshop1 = Bukkit.createInventory(null, 9, "§2§lVive la pêche !");


					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);

					ItemStack rslt = new ItemStack(Material.FISHING_ROD, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("§aCanne à pêche - shop");
					Mrslt.setLore(Arrays.asList("Nécésite 4 emeraudes"));
					rslt.setItemMeta(Mrslt);

					ItemStack rslt4 = new ItemStack(Material.NAME_TAG, 1);
					ItemMeta Mrslt4 = rslt4.getItemMeta();
					Mrslt4.setDisplayName("§aName tag - shop");
					Mrslt4.setLore(Arrays.asList("Nécésite 4 emeraudes"));
					rslt4.setItemMeta(Mrslt4);

					ItemStack rslt5 = new ItemStack(Material.EMERALD, 1);
					ItemMeta Mrslt5 = rslt5.getItemMeta();
					Mrslt5.setDisplayName("§a1 emeraude - shop");
					Mrslt5.setLore(Arrays.asList("Nécésite 15 saumon crue"));
					rslt5.setItemMeta(Mrslt5);

					ItemStack rslt3 = new ItemStack(Material.SUNFLOWER, 1);
					ItemMeta Mrslt3 = rslt3.getItemMeta();
					Mrslt3.setDisplayName("§bMédaillon n°3 - shop");
					Mrslt3.setLore(Arrays.asList("Nécésite Nautilus shell"));
					rslt3.setItemMeta(Mrslt3);


					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§lPêcheur :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","Besoin de cane à pêche ?","Besoin d'un casque de l'océan ?","Tu es tombé au bon endroit !"));
					q.setItemMeta(Mq);

					//Acheter / vendre
					invshop1.setItem(7, rslt);
					invshop1.setItem(0, quit);
					invshop1.setItem(1, q);
					invshop1.setItem(8, rslt3);
					invshop1.setItem(6, rslt4);
					invshop1.setItem(5, rslt5);




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
		ItemStack rslt4 = new ItemStack(Material.NAME_TAG, 1);

		ItemStack rslt5 = new ItemStack(Material.EMERALD, 1);

		ItemStack em = new ItemStack(Material.EMERALD, 9);

		ItemStack rslt3 = new ItemStack(Material.FISHING_ROD, 1);

		ItemStack rslt = new ItemStack(Material.LEATHER_HELMET, 1);
		ItemMeta Mrslt = rslt.getItemMeta();
		Mrslt.setDisplayName("§bCasque des Océans");
		Mrslt.setLore(Arrays.asList("Le casque de la puissance !"));
		Mrslt.addEnchant(Enchantment.DURABILITY, 5, true);
		Mrslt.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
		Mrslt.addEnchant(Enchantment.OXYGEN, 3, true);
		rslt.setItemMeta(Mrslt);

		ItemStack med = new ItemStack(Material.SUNFLOWER, 1);
		ItemMeta Mmed = med.getItemMeta();
		Mmed.setDisplayName("§bMédaillon n°3");
		Mmed.setLore(Arrays.asList("§bObtenue en pêchant une coquille de nautilus"));
		Mmed.addEnchant(Enchantment.ARROW_INFINITE, 2000, true);
		Mmed.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		med.setItemMeta(Mmed);


		if(current.getType() ==  Material.FISHING_ROD && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aCanne à pêche - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 4) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt3);
				player.updateInventory();
			}
			player.closeInventory();

		}

		if(current.getType() ==  Material.NAME_TAG && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aName tag - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 4) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt4);
				player.updateInventory();
			}
			player.closeInventory();

		}

		if(current.getType() ==  Material.EMERALD && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a1 emeraude - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.SALMON) && player.getInventory().getItemInMainHand().getAmount() == 15) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt5);
				player.updateInventory();
			}
			player.closeInventory();

		}

		if(current.getType() ==  Material.SUNFLOWER && current.getItemMeta().getDisplayName().equalsIgnoreCase("§bMédaillon n°3 - shop")) {
			event.setCancelled(true);
			if(player.getInventory().getItemInMainHand().getType().equals(Material.NAUTILUS_SHELL)) {
				player.sendMessage("Item acheté");
				player.getInventory().setItemInMainHand(rslt);
				player.getInventory().addItem(em);
				player.getInventory().addItem(med);
				player.updateInventory();
			}
			player.closeInventory();

		}





		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lPêcheur :")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openInventory(invshop1);
		}





	}





}//fin de inventory click event

