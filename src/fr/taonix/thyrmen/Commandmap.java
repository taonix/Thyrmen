package fr.taonix.thyrmen;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Commandmap implements Listener, CommandExecutor {



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;


			Inventory invmap = Bukkit.createInventory(null, 9, "§aL'exploreur de poche !");

			ItemStack s = new ItemStack(Material.WRITABLE_BOOK, 1);
			ItemMeta Ms = s.getItemMeta();
			Ms.setDisplayName("§c Donjons visités : ");
			s.setItemMeta(Ms);
			
			ItemStack dj1 = new ItemStack(Material.BLUE_DYE, 1);
			ItemMeta Mdj1 = dj1.getItemMeta();
			Mdj1.setDisplayName("§9Donjon n°1");
			Mdj1.setLore(Arrays.asList("Astuce :" + " Clicke pour te tp !"));
			Mdj1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
			dj1.setItemMeta(Mdj1);
			
			ItemStack dj1n = new ItemStack(Material.BLUE_DYE, 1);
			ItemMeta Mdj1n = dj1n.getItemMeta();
			Mdj1n.setDisplayName("§9§kDonjon n°1");
			Mdj1n.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true);
			dj1n.setItemMeta(Mdj1n);

			invmap.setItem(0, s);
			
			
			String np = player.getName();

			final Score sb = Bukkit.getScoreboardManager().getMainScoreboard().getObjective("expl").getScore(np);
			
			if(sb.getScore() == 1) {
				
				invmap.setItem(2, dj1);
			} else {
				invmap.setItem(2, dj1n);
			}
			
			
			
			
			
			
			
			player.openInventory(invmap);



		}
		return false;
	}
}