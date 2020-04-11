package fr.taonix.thyrmen;



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

public class Menu implements Listener {
	
	
	
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
				 
				 if(chest.getCustomName().equals("Q1S")) {
					 		 
				 Inventory invshop1 = Bukkit.createInventory(null, 9, "§c§lQuête du paysant");
				 
				 ItemStack acheter = new ItemStack(Material.IRON_INGOT, 1);
					ItemMeta Macheter = acheter.getItemMeta();
					Macheter.setDisplayName("Valider la quête");
					acheter.setItemMeta(Macheter);
					
					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);
					
					ItemStack rslt = new ItemStack(Material.SUNFLOWER, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("§bMédaillon n°1 - Récompense");
					Mrslt.setLore(Arrays.asList("Nécésite 10 crottins"));
					rslt.setItemMeta(Mrslt);
					
					ItemStack rslt1 = new ItemStack(Material.GOLD_INGOT, 1);
					ItemMeta Mrslt1 = rslt1.getItemMeta();
					Mrslt1.setDisplayName("Acheter une Selle");
					Mrslt1.setLore(Arrays.asList("Nécésite 3 émeraudes"));
					rslt1.setItemMeta(Mrslt1);
					
					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§l Fermier :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","Pourrais tu m'appoter","10 crottins de chevaux s'il te plaît ?","Une récompense à la clef !"));
					q.setItemMeta(Mq);

					//Quit
					invshop1.setItem(4, quit);
					
					//Acheter / vendre
					invshop1.setItem(8, acheter);
					invshop1.setItem(4, rslt);
					invshop1.setItem(7, rslt1);
					invshop1.setItem(0, quit);
					invshop1.setItem(1, q);
				 
					
					
					
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
				ItemStack rslt3 = new ItemStack(Material.EMERALD, 4);
				
				ItemStack rslt = new ItemStack(Material.SUNFLOWER, 1);
				ItemMeta Mrslt = rslt.getItemMeta();
				Mrslt.setDisplayName("§bMédaillon n°1");
				Mrslt.setLore(Arrays.asList("§bObtenue en aidant le fermier "));
				Mrslt.addEnchant(Enchantment.ARROW_INFINITE, 200, true);
				Mrslt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				rslt.setItemMeta(Mrslt);
				
				ItemStack rslt1 = new ItemStack(Material.SADDLE, 1);
				ItemMeta Mrslt1 = rslt1.getItemMeta();
				Mrslt1.setDisplayName("Selle du fermier");
				rslt1.setItemMeta(Mrslt1);
				
				
				if(current.getType() ==  Material.IRON_INGOT && current.getItemMeta().getDisplayName().equalsIgnoreCase("Valider la quête")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.BROWN_DYE) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§2crottin de cheval") && player.getInventory().getItemInMainHand().getAmount() == 10) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt);
					    player.getInventory().addItem(rslt3);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
					
					
					if(current.getType() ==  Material.GOLD_INGOT && current.getItemMeta().getDisplayName().equalsIgnoreCase("Acheter une Selle")) {
						event.setCancelled(true);
						if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 3) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt1);
					    player.updateInventory();
						}
						player.closeInventory();
					    
					}
					
				
				
				if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§l Fermier :")) {
					event.setCancelled(true);
					player.closeInventory();
					player.openInventory(invshop1);
				}
				
					
				if(current.getType() ==  Material.SUNFLOWER && current.getItemMeta().getDisplayName().equalsIgnoreCase("§bMédaillon n°1 - Récompense")) {
					event.setCancelled(true);
					player.sendMessage("Pour recevoir clickez sur 'Valider la quête'.");
					player.closeInventory();
					player.openInventory(invshop1);
				
					    }
				
				
				
					}
					

					
	
					
				}//fin de inventory click event
	
