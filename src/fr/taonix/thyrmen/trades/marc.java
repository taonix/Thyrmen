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
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.inventory.InventoryClickEvent;

public class marc implements Listener {



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

				if(chest.getCustomName().equals("been1")) {

					Merchant invshop1 = Bukkit.createMerchant("test");

					
					ItemStack quit = new ItemStack(Material.BARRIER, 1);
					ItemMeta Mquit = quit.getItemMeta();
					Mquit.setDisplayName("§4§lQuitter");
					quit.setItemMeta(Mquit);

					MerchantRecipe quit3 = new MerchantRecipe(quit, 0);

					//Acheter / vendre
					invshop1.setRecipes(Arrays.asList(quit3));




					player.openMerchant(invshop1, true);




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


		if(current.getType() ==  Material.BARRIER && current.getItemMeta().getDisplayName().equalsIgnoreCase("§4Jetter")) {
			event.setCancelled(true);
			player.closeInventory();

		}





	}





}//fin de inventory click event

