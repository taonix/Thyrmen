package fr.taonix.thyrmen.trades;



import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Location;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.scoreboard.Score;

import fr.taonix.thyrmen.Main;

import org.bukkit.event.inventory.InventoryClickEvent;

public class been implements Listener {
	



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

				if(chest.getCustomName().equals("been")) {


					
					Inventory invshop1 = Bukkit.createInventory(null, 45, "�cPoubelle");

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



		Inventory invshop2 = Bukkit.createInventory(null, 45, "�cPoubelle");


		ItemStack quit = new ItemStack(Material.BARRIER, 1);
		ItemMeta Mquit = quit.getItemMeta();
		Mquit.setDisplayName("�4Jetter");
		Mquit.setLore(Arrays.asList("Attention ! M�me en quittant","ce coffre avec Echap,","le stuff sera supr."));
		quit.setItemMeta(Mquit);


		//Ici, il y a aussi le dim

		Inventory invdimpts = Bukkit.createInventory(null, 9, "�cMenu de tp admin PTS");
		Inventory invdimth = Bukkit.createInventory(null, 9, "�6Menu de tp admin Thyrmen");

		ItemStack b = new ItemStack(Material.COMPASS, 1);
		ItemMeta Mb = b.getItemMeta();
		Mb.setDisplayName("�6Spawn PTS");
		b.setItemMeta(Mb);
		
		ItemStack c = new ItemStack(Material.COMPASS, 1);
		ItemMeta Mc = c.getItemMeta();
		Mc.setDisplayName("�6Spawn Thyrmen");
		c.setItemMeta(Mc);
		
		ItemStack p = new ItemStack(Material.FISHING_ROD, 1);
		ItemMeta Mp = p.getItemMeta();
		Mp.setDisplayName("�c P�che");
		p.setItemMeta(Mp);
		
		ItemStack d = new ItemStack(Material.BLUE_DYE, 1);
		ItemMeta Md = d.getItemMeta();
		Md.setDisplayName("�aTp donjon 1");
		d.setItemMeta(Md);

		invdimth.setItem(0, c);
		invdimth.setItem(2, p);
		invdimth.setItem(4, d);
		invdimpts.setItem(0, b);

		Location spawnpts = new Location(player.getWorld(), -97, 4, -230);
		Location spawnth = new Location(player.getWorld(), -817, 75, -747);
		Location dj1 = new Location(player.getWorld(), -847, 71, -1028);
		Location peche = new Location(player.getWorld(), -1048, 64, -791);

		if(current.getType() ==  Material.COMPASS && current.getItemMeta().getDisplayName().equalsIgnoreCase("�6Spawn PTS")) {
			event.setCancelled(true);
			player.closeInventory();
			player.sendMessage("t�leportation...");
			player.teleport(spawnpts);

		}
		
		if(current.getType() ==  Material.COMPASS && current.getItemMeta().getDisplayName().equalsIgnoreCase("�6Spawn Thyrmen")) {
			event.setCancelled(true);
			player.closeInventory();
			player.sendMessage("t�leportation...");
			player.teleport(spawnth);

		}
		
		if(current.getType() ==  Material.FISHING_ROD && current.getItemMeta().getDisplayName().equalsIgnoreCase("�c P�che")) {
			event.setCancelled(true);
			player.closeInventory();
			player.sendMessage("t�leportation...");
			player.teleport(peche);

		}
		
		if(current.getType() ==  Material.BLUE_DYE && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9Tp donjon 1")) {
			event.setCancelled(true);
			player.closeInventory();
			player.sendMessage("t�leportation...");
			player.teleport(dj1);

		}

		if(current.getType() ==  Material.LIME_TERRACOTTA && current.getItemMeta().getDisplayName().equalsIgnoreCase("�aPTS")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openInventory(invdimpts);

		}
		
		if(current.getType() ==  Material.YELLOW_TERRACOTTA && current.getItemMeta().getDisplayName().equalsIgnoreCase("�6Thyrmen")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openInventory(invdimth);

		}

		if(current.getType() ==  Material.GOLD_BLOCK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�6Mode maintenace D�sactiv�")) {
			event.setCancelled(true);
			player.closeInventory();
			Main.ENABLED = true;

		}

		if(current.getType() ==  Material.IRON_BLOCK && current.getItemMeta().getDisplayName().equalsIgnoreCase("Mode maintenace Activ�")) {
			event.setCancelled(true);
			player.closeInventory();
			Main.ENABLED = false;
			
		}
		
		if(current.getType() ==  Material.BLUE_DYE && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9Donjon n�1")) {
			event.setCancelled(true);
			player.sendMessage("veuillez patientez 10 secondes");
			player.closeInventory();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			player.teleport(dj1);

		}

		if(current.getType() ==  Material.PLAYER_HEAD) {
			event.setCancelled(true);
		}
		
		if(current.getType() ==  Material.LAPIS_BLOCK) {
			event.setCancelled(true);
		}
		
		if(current.getType() ==  Material.TRIPWIRE_HOOK) {
			event.setCancelled(true);
		}
		
		if(current.getType() ==  Material.BUCKET) {
			event.setCancelled(true);
		}
		
		if(current.getType() ==  Material.BLUE_DYE) {
			event.setCancelled(true);
		}
		
		if(current.getType() ==  Material.WRITABLE_BOOK) {
			event.setCancelled(true);
		}

		
		
		
		String n = "\n";
		
		ItemStack book = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta bm = (BookMeta) book.getItemMeta();
		bm.setAuthor("Qu�tes et l�gendes");
		bm.setTitle("L'eau de dieu #001");
		bm.addPage("�9�lL'eau de dieu :" + n + n + "�7La l�gende raconte qu'un mage aurrait bouch� cette eau pour la rendre pur afin de soign� le village de �r�4la grande peste");
		book.setItemMeta(bm);
		
		
		ItemStack bb = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta Mbb = (BookMeta) bb.getItemMeta();
		Mbb.setAuthor("Qu�tes et l�gendes");
		Mbb.setTitle("L'eau de dieu #001");
		Mbb.addPage("�9�lLa cricke des pirates" + n + n + "�7On dit que cette cricke recelle de grands secrets. Un jour des pirates chantaient en ceur " + n + "�r�2�o'A ma crike ! Soyez astucieux ! le b�tail ne sert pas seulment � manger ! Mais si vous �tes deux ! un seul triomphera !'");
		bb.setItemMeta(Mbb);
		
		ItemStack cc = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta Mcc = (BookMeta) cc.getItemMeta();
		Mcc.setAuthor("Qu�tes et l�gendes");
		Mcc.setTitle("L'eau de dieu #001");
		Mcc.addPage("�9�lLes z�plins " + n + n + "�7�oIls se dressent au dessus de nous," + n + "�7�oIls ont un ceur de fer" + n + "�7�oUne fois � bort de cette oiseau de fer" + n + "�7�oUn sanctuaire tout est d�sert" + n + "�7    Alphin Baudet");
		cc.setItemMeta(Mcc);
		
		ItemStack dd = new ItemStack(Material.WRITTEN_BOOK, 1);
		BookMeta Mdd = (BookMeta) dd.getItemMeta();
		Mdd.setAuthor("Qu�tes et l�gendes");
		Mdd.setTitle("L'eau de dieu #001");
		Mdd.addPage("�9�lIntroduction � Thyrmen :" + n + n + "�6L'origine de Thyrmen" + n + n + "�r�7La l�gende raconte que Thyrmen aurait �t� cr�� par Tenfroky, dieu des 'miracles et de la chance'.Il l'aurait cr�� pour Afroky, son fr�re, qui trouvait que la terre �tait vide.");
		Mdd.addPage("�r�7Pendant 8700 ans, le continent s'est fertilis�, la vie y est apparue, au d�but ce n'�tait que de la v�g�tation, Kyogu et Lyogu, respectivement : dieux des climats et dieux des �l�ments, y ont vari� les paysages. Allant de magnifiques for�ts luxuriantes aux impressionnants pics");
		Mdd.addPage("�7enneig�s, en passant par les plaines d�sertiques et les vastes prairies de verdure. Puis, Juri D�esse de la vari�t� cr�a 3 continents voisins � Thyrmen : Thenkym, Lykym et Nerthem. Les dieux satisfaits de leur travail, ont laiss� Tenfroky finir leur �uvre.");
		Mdd.addPage("�7Celui-ci cr�a le dernier miracle, se faisant, cet instant fut baptis� : le jour miraculeux, le 27 aout, les elfes apparurent sur Thyrmen, les humain sur Thenkym, les d�mons et les anges sur Nerthem, et les f�es sur Lykym, celui-ci laissa aussi, au monde, la gemme du miracle...");
		Mdd.addPage("�7Personne ne sait o� il l'a mit, mais elle permet l'�volution de leur monde, et l'apparition de nouvelle tribu, donnant vie au monde. Une f�te, r�unissant tous les villages du monde en l'honneur de Tenfroky, a lieu tous les ans, le 27 aout.");
		Mdd.addPage("�7Ils c�l�brent le miracle de leur existence, la vie que leur a offert celui-ci.L'an 0 correspond � l'apparition des �tres vivants. En l'an 877, apr�s presque 900 ans de paix sur Thyrmen, le premier �change lieu entre les continents,");      
		Mdd.addPage("�7ce sont des nomades qui d�barquent sur Thyrmen. Arrivant par l'Ouest, ils d�barqu�rent dans les grandes plaines d'Elkym. Les Elfes, quant � eux, vivant dans la for�t d'Ukyl, voient ce d�barquement de  diff�rentes fa�ons, certains sont contre l'arriv�e des nomades,");
		Mdd.addPage("�7 d'autres pensent au bien que cela va leur apporter, leur permettre d'instaurer des routes de commerces, et de varier les cultures de leur peuple." + n + n + "En l'an 965, 88 ans apr�s le d�barquement, les nomades ce sont s�par�s en 2 royaumes :");
		Mdd.addPage("�7ce qui sont rest�s sur les plaines d'Elkym, et d'autres qui sont descendus dans les plaines d'Akar au sud de la for�t d'Ukyl, les nomades rest�s sur place sont devenus agressifs et n'ont plus entretenu de contact avec ceux qui sont");
		Mdd.addPage("�7 partit b�tir leur civilisation dans les plaines d'Akar, car �tant contre l'id�e d'explorer les terres. Durant les 100ans qui on suivit, les nomades install�s dans les plaines d'Akar se sont appel� les Hakyeniens, et ont abandonn� leur vie de nomade,");              
		Mdd.addPage("�7vivant en paix avec les Elfes du sud de la for�t d'Ukyl,les 2 peuples s'entraidant et b�tissant  un royaume, pendant ce temps les nomades install�s dans la plaine d'Elkym se pr�paraient � la guerre, ils lan�aient parfois de petites attaques sur le royaume");
		Mdd.addPage("�7des Hakyeniens et sur la partie nord de la for�t des Elfes. Cela eu pour effet d'amplifier le racisme des Elfes du nord d'Ukyl, car ayant seulement des contacts avec les nomades des prairies d'Elkym, ils ne connaissaient pas grand chose � la vie et � la paix");
		Mdd.addPage("�7des Elfes du sud avec les Hakyeniens." + n + n + "�r�6    Extrait de l'histoire de Thyrmen" + n + n + "�r�7�oSuite disponible ici :  https://discord.gg/GTTbpat");
		dd.setItemMeta(Mdd);
		
		
		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9L'eau de dieu #001")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openBook(book);
			
		}
		
		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9La cricke des pirates #002")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openBook(bb);
			
		}
		
		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9Les z�plins #003")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openBook(cc);
			
		}
		
		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("�9Introduction � Thyrmen #000")) {
			event.setCancelled(true);
			player.closeInventory();
			player.openBook(dd);
			
		}
		
		if(current.getType() ==  Material.BOOK && current.getItemMeta().getDisplayName().equalsIgnoreCase("1")) {
			event.setCancelled(true);
			player.closeInventory();
			
			
			
		}
		
		String np = player.getName();

		final Score sb = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("enduranceS").getScore(np);
		
		if(sb.getScore() >= 100) {
			player.sendMessage("1");
		} else {
			
		}
		
		
	


	}//fin de onclick





}//fin de inventory click event



