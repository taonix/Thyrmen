package fr.taonix.thyrmen;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Commandlegende implements Listener, CommandExecutor {



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			Inventory invlegende = Bukkit.createInventory(null, 27, "§9Légendes et comptes");
			
			ItemStack intro = new ItemStack(Material.BOOK, 1);
			ItemMeta Mintro = intro.getItemMeta();
			Mintro.setDisplayName("§9Introduction à Thyrmen #000");
			intro.setItemMeta(Mintro);
			
			ItemStack a = new ItemStack(Material.BOOK, 1);
			ItemMeta Ma = a.getItemMeta();
			Ma.setDisplayName("§9L'eau de dieu #001");
			a.setItemMeta(Ma);
			
			ItemStack b = new ItemStack(Material.BOOK, 1);
			ItemMeta Mb = b.getItemMeta();
			Mb.setDisplayName("§9La cricke des pirates #002");
			b.setItemMeta(Mb);
			
			ItemStack c = new ItemStack(Material.BOOK, 1);
			ItemMeta Mc = c.getItemMeta();
			Mc.setDisplayName("§9Les zéplins #003");
			c.setItemMeta(Mc);
			
			invlegende.setItem(3, c);
			invlegende.setItem(2, b);
			invlegende.setItem(1, a);
			invlegende.setItem(0, intro);
			
			player.openInventory(invlegende);
			
			PotionEffect pe = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 1);
			
		}
		return false;
	}

}
