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

public class stuff implements Listener {
	
	
	
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
				 
				 if(chest.getCustomName().equals("S3S")) {
					 		 
				 Inventory invshop1 = Bukkit.createInventory(null, 9, "§3§lMagasin de départ");
				 
					
					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);
					
					ItemStack rslt = new ItemStack(Material.IRON_CHESTPLATE, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("Full fer - shop");
					Mrslt.setLore(Arrays.asList("Nécésite 29 emeraudes"));
					rslt.setItemMeta(Mrslt);
					
					ItemStack rslt3 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
					ItemMeta Mrslt3 = rslt3.getItemMeta();
					Mrslt3.setDisplayName("25 cuir - shop");
					Mrslt3.setLore(Arrays.asList("Nécésite 1 émeraudes"));
					rslt3.setItemMeta(Mrslt3);
					
					ItemStack rslt4 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
					ItemMeta Mrslt4 = rslt4.getItemMeta();
					Mrslt4.setDisplayName("Full chainmail - shop");
					Mrslt4.setLore(Arrays.asList("Nécésite 15 émeraudes"));
					rslt4.setItemMeta(Mrslt4);
					
					
					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§lVillageoi :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","Ici tu pouras","m'achetez du contenue","de base"));
					q.setItemMeta(Mq);
					
					//Acheter / vendre
					invshop1.setItem(0, quit);
					invshop1.setItem(8, q);
					invshop1.setItem(3, rslt3);
					invshop1.setItem(4, rslt);
					invshop1.setItem(5, rslt4);
					
					
					
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
				player.sendMessage("Menu de quête fermé");
				player.closeInventory();
				
			}
				ItemStack iron = new ItemStack(Material.IRON_CHESTPLATE, 1);
				ItemStack iron1 = new ItemStack(Material.IRON_BOOTS, 1);
				ItemStack iron2 = new ItemStack(Material.IRON_LEGGINGS, 1);
				ItemStack iron3 = new ItemStack(Material.IRON_HELMET, 1);
				
				ItemStack cm = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				ItemStack cm1 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				ItemStack cm2 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				ItemStack cm3 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
				
				
				ItemStack rslt = new ItemStack(Material.LEATHER, 23);
				
				
				if(current.getType() ==  Material.IRON_CHESTPLATE && current.getItemMeta().getDisplayName().equalsIgnoreCase("Full fer - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 29) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(iron);
					    player.getInventory().addItem(iron1);
					    player.getInventory().addItem(iron2);
					    player.getInventory().addItem(iron3);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
				
				
				if(current.getType() ==  Material.CHAINMAIL_CHESTPLATE && current.getItemMeta().getDisplayName().equalsIgnoreCase("Full chainmail - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 15) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(cm);
					    player.getInventory().addItem(cm1);
					    player.getInventory().addItem(cm2);
					    player.getInventory().addItem(cm3);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
				
				if(current.getType() ==  Material.LEATHER_CHESTPLATE && current.getItemMeta().getDisplayName().equalsIgnoreCase("25 cuir - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 1) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
					
					
					
				
				
				if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lVillageoi :")) {
					event.setCancelled(true);
					player.closeInventory();
					player.openInventory(invshop1);
				}
				
					
				
				
				
					}
					

					
	
					
				}//fin de inventory click event
