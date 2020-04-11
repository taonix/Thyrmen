package fr.taonix.thyrmen;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

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
import org.bukkit.scoreboard.Score;
import org.bukkit.event.inventory.InventoryClickEvent;

public class BoxM implements Listener {



	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack it = event.getItem();

		if(it == null) return;

		if(it.getType() == Material.COMPASS && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§2§lBox §a§lMystère")) {


			Inventory menup = Bukkit.createInventory(null, 27, "§2§lBox §a§lMystère");


			String np = player.getName();

			final Score sb = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("MB").getScore(np);
			final Score mbg = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("MBG").getScore(np);

			ItemStack quit = new ItemStack(Material.BARRIER, 1);
			ItemMeta Mquit = quit.getItemMeta();
			Mquit.setDisplayName("§4§lSortir");
			quit.setItemMeta(Mquit);

			ItemStack dms = new ItemStack(Material.JUNGLE_SAPLING, 1);
			ItemMeta Mdms = dms.getItemMeta();
			Mdms.setDisplayName("§c.");
			dms.setItemMeta(Mdms);

			ItemStack dm = new ItemStack(Material.VINE, 1);
			ItemMeta Mdm = dm.getItemMeta();
			Mdm.setDisplayName("§c.");
			dm.setItemMeta(Mdm);

			ItemStack gr = new ItemStack(Material.GRASS, 1);
			ItemMeta Mgr = gr.getItemMeta();
			Mgr.setDisplayName("§c.");
			gr.setItemMeta(Mgr);

			ItemStack sgr = new ItemStack(Material.GRASS, 1);
			ItemMeta Msgr = sgr.getItemMeta();
			Msgr.setDisplayName("§c.");
			sgr.setItemMeta(Msgr);

			ItemStack fr = new ItemStack(Material.FERN, 1);
			ItemMeta Mfr = fr.getItemMeta();
			Mfr.setDisplayName("§c.");
			fr.setItemMeta(Mfr);

			ItemStack tr = new ItemStack(Material.GOLD_BLOCK, 1);
			ItemMeta Mtr = tr.getItemMeta();
			Mtr.setDisplayName("§2Nombres de box : " + mbg.getScore() + "/3");
			Mtr.setLore(Arrays.asList("(nombres de box restantes)"));
			tr.setItemMeta(Mtr);
			
			ItemStack tr1 = new ItemStack(Material.CHEST, 1);
			ItemMeta Mtr1 = tr1.getItemMeta();
			Mtr1.setDisplayName("§2Ouvrir une box");
			tr1.setItemMeta(Mtr1);
			
			ItemStack tr2 = new ItemStack(Material.CHEST, 1);
			ItemMeta Mtr2= tr2.getItemMeta();
			Mtr2.setDisplayName("§cAucune box disponible");
			tr2.setItemMeta(Mtr2);

			ItemStack rand1 = new ItemStack(Material.CRAFTING_TABLE, 1);
			ItemMeta Mrand1 = rand1.getItemMeta();
			Mrand1.setDisplayName("§2Ouvrir la box");
			rand1.setItemMeta(Mrand1);

			ItemStack rand2 = new ItemStack(Material.BARRIER, 1);
			ItemMeta Mrand2 = rand2.getItemMeta();
			Mrand2.setDisplayName("§2Il reste " + sb.getScore() + " minutes");
			Mrand2.setLore(Arrays.asList("§2avant la prochaîne box."));
			rand2.setItemMeta(Mrand2);



			//Acheter / vendre
			menup.setItem(0, dm);
			menup.setItem(1, fr);
			menup.setItem(2, dm);
			menup.setItem(3, sgr);
			menup.setItem(4, fr);
			menup.setItem(5, gr);
			menup.setItem(6, sgr);
			menup.setItem(7, dms);
			menup.setItem(8, dm);

			menup.setItem(9, dm);
			menup.setItem(17, dm);

			menup.setItem(18, dm);
			menup.setItem(19, dms);
			menup.setItem(20, fr);
			menup.setItem(21, gr);
			menup.setItem(22, dms);
			menup.setItem(23, gr);
			menup.setItem(24, fr);
			menup.setItem(25, sgr);
			menup.setItem(26, dm);

			
			menup.setItem(11, tr);
			
			if(mbg.getScore() == 1) {
				menup.setItem(15, tr1);
				
			} else if(mbg.getScore() == 2) {
				menup.setItem(15, tr1);
				
			} else if(mbg.getScore() == 3) {
				menup.setItem(15, tr1);
				
			} else if(mbg.getScore() == 0) {
				menup.setItem(15, tr2);
				
			}



			if(sb.getScore() == 10000) {
				menup.setItem(13, rand1);
			} else {
				menup.setItem(13, rand2);
			}





			player.openInventory(menup);





		}




	}//fin player interact

	@EventHandler
	public void onClick(InventoryClickEvent event) {


		//Inventory acheter1 = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		ItemStack current = event.getCurrentItem();


		String np = player.getName();

		final Score sb = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("MB").getScore(np);
		final Score mbg = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("MBG").getScore(np);





		if(current == null) return;


		if(current.getType() ==  Material.BARRIER && current.getItemMeta().getLore().equals(Arrays.asList("§2avant la prochaîne box."))) {
			event.setCancelled(true);
			player.closeInventory();

		}
		
		if(current.getType() ==  Material.GOLD_BLOCK && current.getItemMeta().getLore().equals(Arrays.asList("(nombres de box restantes)"))) {
			event.setCancelled(true);
			player.closeInventory();
		}



		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("§a§lGuide :")) {
			event.setCancelled(true);
			player.closeInventory();

		}

		if(current.getItemMeta().getDisplayName().equalsIgnoreCase("§c.")) {
			event.setCancelled(true);

		}

		//Deuxième menu

		Inventory menuo = Bukkit.createInventory(null, 9, "§2§lBox §a§lMystère a");

		ItemStack t1 = new ItemStack(Material.CHEST, 1);
		ItemMeta Mt1 = t1.getItemMeta();
		Mt1.setDisplayName("§2rand1");
		Mt1.setLore(Arrays.asList("random n°1"));
		t1.setItemMeta(Mt1);

		ItemStack t2 = new ItemStack(Material.STONE, 1);
		ItemMeta Mt2 = t2.getItemMeta();
		Mt2.setDisplayName("§2rand2");
		Mt2.setLore(Arrays.asList("random n°2"));
		t2.setItemMeta(Mt2);

		ItemStack t3 = new ItemStack(Material.DIAMOND, 1);
		ItemMeta Mt3 = t3.getItemMeta();
		Mt3.setDisplayName("§2rand3");
		Mt3.setLore(Arrays.asList("random n°3"));
		t3.setItemMeta(Mt3);
		
		ItemStack R1 = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
		ItemMeta RM1 = R1.getItemMeta();
		RM1.setDisplayName("§2randg1");
		R1.setItemMeta(RM1);

		Random r = new Random();
		int n = r.nextInt(2);





		//Fin deuxième menu

		if(current.getType() ==  Material.CRAFTING_TABLE && current.getItemMeta().getDisplayName().equalsIgnoreCase("§2Ouvrir la box")) {
			event.setCancelled(true);
			sb.setScore(30);
			player.closeInventory();
			player.openInventory(menuo); 

				Random rt = new Random();
				int nt = rt.nextInt(3);

				if(nt == 0) {
					menuo.setItem(4, t1);

				} else if(nt == 1) {
					
					menuo.setItem(4, t2);
					
				} else if(nt == 2) {
					
					menuo.setItem(4, t3);
					
				}
		}
		
		
		
				
				if(current.getType() ==  Material.CHEST && current.getItemMeta().getDisplayName().equalsIgnoreCase("§2Ouvrir une box")) {
					event.setCancelled(true);
					
					
					
					if(mbg.getScore() == 1) {
						mbg.setScore(0);
					} else if(mbg.getScore() == 2) {
						mbg.setScore(1);
					} else if(mbg.getScore() == 3) {
						mbg.setScore(2);
					}
					
						
					player.closeInventory();
					player.openInventory(menuo);
					

						Random rt1 = new Random();
						int nt1 = rt1.nextInt(3);
						
						
						for(int i = 1; i <= 10; i++)
						{
							Random rt2 = new Random();
							int nt2 = rt2.nextInt(2);
							
							if(nt2 == 0) {
								menuo.setItem(0, R1);

							} else if(nt2 == 1) {
								
								menuo.setItem(0, t2);
								
							} else if(nt2 == 2) {
								
								menuo.setItem(0, t3);
								
							}
							
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
						
						

						if(nt1 == 0) {
							menuo.setItem(4, t1);

						} else if(nt1 == 1) {
							
							menuo.setItem(4, t2);
							
						} else if(nt1 == 2) {
							
							menuo.setItem(4, t3);
							
						}
					
			
			



			/*if(n == 0) {
							menuo.setItem(4, t1);

						} else if(n == 1) {
							menuo.setItem(4, t2);
						} else {
							menuo.setItem(4, t3);
						}*/


		}

	





	}


}//fin de inventory click event

