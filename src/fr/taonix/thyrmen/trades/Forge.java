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

public class Forge implements Listener {
	
	
	
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
				 
				 if(chest.getCustomName().equals("F1S")) {
					 		 
				 Inventory invshop1 = Bukkit.createInventory(null, 9, "§3§lMagasin du forgeron");
				 
					
					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);
					
					ItemStack rslt = new ItemStack(Material.STONE_SWORD, 1);
					ItemMeta Mrslt = rslt.getItemMeta();
					Mrslt.setDisplayName("§aL'épée de soldat - shop");
					Mrslt.setLore(Arrays.asList("Nécésite 10 emeraudes"));
					rslt.setItemMeta(Mrslt);
					
					ItemStack acheter = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
					ItemMeta Macheter = acheter.getItemMeta();
					Macheter.setDisplayName("§a Les bottes de soldats - shop");
					Macheter.setLore(Arrays.asList("Nécésite 10 emeraudes"));
					acheter.setItemMeta(Macheter);
					
					ItemStack rslt1 = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
					ItemMeta Mrslt1 = rslt1.getItemMeta();
					Mrslt1.setDisplayName("§aJambière du soldat - shop");
					Mrslt1.setLore(Arrays.asList("Nécésite 10 émeraudes"));
					rslt1.setItemMeta(Mrslt1);
					
					ItemStack rslt2 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
					ItemMeta Mrslt2 = rslt2.getItemMeta();
					Mrslt2.setDisplayName("§aPlastron du soldat - shop");
					Mrslt2.setLore(Arrays.asList("Nécésite 10 émeraudes"));
					rslt2.setItemMeta(Mrslt2);
					
					ItemStack rslt3 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
					ItemMeta Mrslt3 = rslt2.getItemMeta();
					Mrslt3.setDisplayName("§aLe casque de soldats - shop");
					Mrslt3.setLore(Arrays.asList("Nécésite 10 émeraudes"));
					rslt3.setItemMeta(Mrslt3);
					
					
					ItemStack q = new ItemStack(Material.BOOK, 1);
					ItemMeta Mq = q.getItemMeta();
					Mq.setDisplayName("§a§lForgeron :");
					Mq.setLore(Arrays.asList("Bonjour voyageur !","Ici tu pouras","m'achetez toutes sortes","D'armes ou d'armures"));
					q.setItemMeta(Mq);

					//Quit
					invshop1.setItem(4, quit);
					
					//Acheter / vendre
					invshop1.setItem(8, acheter);
					invshop1.setItem(4, rslt);
					invshop1.setItem(7, rslt1);
					invshop1.setItem(0, quit);
					invshop1.setItem(1, q);
					invshop1.setItem(6, rslt2);
					invshop1.setItem(5, rslt3);
				 
					
					
					
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
				ItemStack rslt3 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
				ItemMeta Mrslt3 = rslt3.getItemMeta();
				Mrslt3.setDisplayName("§aJambière du soldat");
				Mrslt3.addEnchant(Enchantment.DURABILITY, 9999, true);
				Mrslt3.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Mrslt3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
				Mrslt3.setLore(Arrays.asList("§aEnchantement protection un"));
				rslt3.setItemMeta(Mrslt3);
				
				ItemStack rslt = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
				ItemMeta Mrslt = rslt.getItemMeta();
				Mrslt.setDisplayName("§aJambière du soldat");
				Mrslt.addEnchant(Enchantment.DURABILITY, 9999, true);
				Mrslt.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Mrslt.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
				Mrslt.setLore(Arrays.asList("§aEnchantement protection un"));
				rslt.setItemMeta(Mrslt);
				
				ItemStack rslt4 = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
				ItemMeta Mrslt4 = rslt4.getItemMeta();
				Mrslt4.setDisplayName("§aPlastron du soldat");
				Mrslt4.addEnchant(Enchantment.DURABILITY, 9999, true);
				Mrslt4.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Mrslt4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
				Mrslt4.setLore(Arrays.asList("§aEnchantement protection un"));
				rslt4.setItemMeta(Mrslt4);
				
				ItemStack rslt5 = new ItemStack(Material.CHAINMAIL_HELMET, 1);
				ItemMeta Mrslt5 = rslt5.getItemMeta();
				Mrslt5.setDisplayName("§aCasque du soldat");
				Mrslt5.addEnchant(Enchantment.DURABILITY, 9999, true);
				Mrslt5.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				Mrslt5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false);
				Mrslt5.setLore(Arrays.asList("§aEnchantement protection un"));
				rslt5.setItemMeta(Mrslt5);
				
				ItemStack rslt1 = new ItemStack(Material.STONE_SWORD, 1);
				ItemMeta Mrslt1 = rslt1.getItemMeta();
				Mrslt1.setDisplayName("§aEpée de soldat");
				Mrslt1.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
				Mrslt1.setLore(Arrays.asList("§a Une bonne épée pour un débutant !"));
				rslt1.setItemMeta(Mrslt1);
				
				
				if(current.getType() ==  Material.CHAINMAIL_CHESTPLATE && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aPlastron du soldat - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 10) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt4);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
				
				if(current.getType() ==  Material.CHAINMAIL_BOOTS && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a Les bottes de soldats - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 10) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt3);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
				
				if(current.getType() ==  Material.CHAINMAIL_HELMET && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aLe casque de soldats - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 10) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt5);
					    player.updateInventory();
					}
					player.closeInventory();
					
			    }
					
					
					if(current.getType() ==  Material.CHAINMAIL_LEGGINGS && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aJambière du soldat - shop")) {
						event.setCancelled(true);
						if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 10) {
					    player.sendMessage("Item acheté");
					    player.getInventory().setItemInMainHand(rslt);
					    player.updateInventory();
						}
						player.closeInventory();
					    
					}
					
				
				
				if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lForgeron :")) {
					event.setCancelled(true);
					player.closeInventory();
					player.openInventory(invshop1);
				}
				
					
				if(current.getType() ==  Material.STONE_SWORD && current.getItemMeta().getDisplayName().equalsIgnoreCase("§aL'épée de soldat - shop")) {
					event.setCancelled(true);
					if(player.getInventory().getItemInMainHand().getType().equals(Material.EMERALD) && player.getInventory().getItemInMainHand().getAmount() == 10) {
					player.sendMessage("Item acheté");
				    player.getInventory().setItemInMainHand(rslt1);
				
					}
					
					    }
				
				
				
					}
					

					
	
					
				}//fin de inventory click event
