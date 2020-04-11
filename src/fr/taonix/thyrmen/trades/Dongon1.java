package fr.taonix.thyrmen.trades;



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

public class Dongon1 implements Listener {
	
	
	
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
				 
				 if(chest.getCustomName().equals("DMS")) {
					 		 
				 Inventory invshop1 = Bukkit.createInventory(null, 9, "�c�lQu�te du dongon");
				 
					
					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("�4�lQuitter");
					quit.setItemMeta(Mquit);
					
					ItemStack rslt = new ItemStack(Material.IRON_INGOT, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("valid� la qu�te");
					rslt.setItemMeta(Mrslt);
					
					ItemStack rslt3 = new ItemStack(Material.BLUE_DYE, 1);
					ItemMeta Mrslt3 = rslt3.getItemMeta();
					Mrslt3.setDisplayName("�bL'�me de Grand Gulkey - Qu�te");
					Mrslt3.setLore(Arrays.asList("Clicke sur 'valid� la qu�te'"));
					Mrslt3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
					rslt3.setItemMeta(Mrslt3);
					
					ItemStack rslt4 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
					ItemMeta Mrslt4 = rslt4.getItemMeta();
					Mrslt4.setDisplayName("�b L'armure de la protection - shop");
					Mrslt4.setLore(Arrays.asList("5 �me de Grand Gulkey (full stuff cuir protec 1)"));
					rslt4.setItemMeta(Mrslt4);
					
					
					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("�a�lMagicien :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","As tu d�ja entendu","Parl� de L'�me de Grand Gulkey ? ","Si tu m'en donne une, je t'offrirais un r�compense !"));
					q.setItemMeta(Mq);
					
					//Acheter / vendre
					invshop1.setItem(8, rslt);
					invshop1.setItem(0, quit);
					invshop1.setItem(1, q);
					invshop1.setItem(4, rslt3);
					invshop1.setItem(7, rslt4);
				 
					
					
					
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
			
			
				if(current.getType() ==  Material.BARRIER && current.getItemMeta().getDisplayName().equalsIgnoreCase("�4�lQuitter")) {
				event.setCancelled(true);
				player.closeInventory();
				
			}

				ItemStack rslt = new ItemStack(Material.SUNFLOWER, 1);
				ItemMeta Mrslt = rslt.getItemMeta();
				Mrslt.setDisplayName("�bM�daillon n�2");
				Mrslt.setLore(Arrays.asList("�bObtenue au donjon de la mine "));
				Mrslt.addEnchant(Enchantment.ARROW_INFINITE, 200, true);
				Mrslt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				rslt.setItemMeta(Mrslt);
				
				ItemStack rslt1 = new ItemStack(Material.EMERALD, 1);
				
				ItemStack rslt3 = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
				ItemMeta Mrslt3 = rslt3.getItemMeta();
				Mrslt3.setDisplayName("Plastron des �mes");
				Mrslt3.setLore(Arrays.asList("Protec1"));
				Mrslt3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				rslt3.setItemMeta(Mrslt3);
				
				ItemStack rslt4 = new ItemStack(Material.LEATHER_HELMET, 1);
				ItemMeta Mrslt4 = rslt4.getItemMeta();
				Mrslt4.setDisplayName("Casque des �mes");
				Mrslt4.setLore(Arrays.asList("Protec1"));
				Mrslt4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				rslt4.setItemMeta(Mrslt4);
				
				ItemStack rslt5 = new ItemStack(Material.LEATHER_BOOTS, 1);
				ItemMeta Mrslt5 = rslt5.getItemMeta();
				Mrslt5.setDisplayName("Les bottes des �mes");
				Mrslt5.setLore(Arrays.asList("Protec1"));
				Mrslt5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				rslt5.setItemMeta(Mrslt5);
				
				ItemStack rslt7 = new ItemStack(Material.LEATHER_LEGGINGS, 1);
				ItemMeta Mrslt7 = rslt7.getItemMeta();
				Mrslt7.setDisplayName("Les jambi�res des �mes");
				Mrslt7.setLore(Arrays.asList("Protec1"));
				Mrslt7.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
				rslt7.setItemMeta(Mrslt7);
				
				
				if(current.getType() ==  Material.BLUE_DYE && current.getItemMeta().getDisplayName().equalsIgnoreCase("�bL'�me de Grand Gulkey - Qu�te")) {
					event.setCancelled(true);
					player.closeInventory();
					player.openInventory(invshop1);
					
			    }
				
				if(current.getType() ==  Material.IRON_INGOT && current.getItemMeta().getDisplayName().equalsIgnoreCase("valid� la qu�te")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.BLUE_DYE) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("�b�me de Grand Gulkey")) {
					    player.sendMessage("Item achet�");
					    player.getInventory().setItemInMainHand(rslt);
					    player.getInventory().addItem(rslt1);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
				
				
				if(current.getType() ==  Material.LEATHER_CHESTPLATE && current.getItemMeta().getDisplayName().equalsIgnoreCase("�b L'armure de la protection - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.BLUE_DYE) && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("�b�me de Grand Gulkey") && player.getInventory().getItemInMainHand().getAmount() == 5) {
					    player.sendMessage("Item achet�");
					    player.getInventory().setItemInMainHand(rslt3);
					    player.getInventory().addItem(rslt4);
					    player.getInventory().addItem(rslt5);
					    player.getInventory().addItem(rslt7);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
					
					
					
				
				
				if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�a�lMagicien :")) {
					event.setCancelled(true);
					player.closeInventory();
					player.openInventory(invshop1);
				}
				
					
				
				
				
					}
					

					
	
					
				}//fin de inventory click event
