package fr.taonix.thyrmen;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.SkullType;
import org.bukkit.block.Skull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.google.common.graph.ElementOrder.Type;

public class CommandStat implements Listener, CommandExecutor {



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;

			String bv = Bukkit.getBukkitVersion();
			String ip = Bukkit.getMotd();
			String gw = player.getWorld().getName();		
			int Online_player = Bukkit.getOnlinePlayers().size();
			Inventory stat = Bukkit.createInventory(null, 9, "§cMenu de statistiques");


			String onpl = "";
			onpl = Integer.toString(Online_player);
			



			ItemStack m = new ItemStack(Material.IRON_BLOCK, 1);
			ItemMeta Mm = m.getItemMeta();
			Mm.setDisplayName("Mode maintenace Activé");
			m.setItemMeta(Mm);

			ItemStack n = new ItemStack(Material.GOLD_BLOCK, 1);
			ItemMeta Mn = n.getItemMeta();
			Mn.setDisplayName("§6Mode maintenace Désactivé");
			n.setItemMeta(Mn);


			ItemStack g = new ItemStack(Material.PLAYER_HEAD, 1);
			ItemMeta Mg = g.getItemMeta();
			Mg.setDisplayName("§a" + onpl + " joueur(s) conecté(s)");
			g.setItemMeta(Mg);


			ItemStack w = new ItemStack(Material.LAPIS_BLOCK, 1);
			ItemMeta Mw = w.getItemMeta();
			Mw.setDisplayName("§aVous êtes sur " + gw);
			w.setItemMeta(Mw);
			
			ItemStack ipi = new ItemStack(Material.TRIPWIRE_HOOK, 1);
			ItemMeta Mipi = ipi.getItemMeta();
			Mipi.setDisplayName("§aVous êtes sur le serveur : " + ip);
			ipi.setItemMeta(Mipi);
			
			ItemStack bu = new ItemStack(Material.BUCKET, 1);
			ItemMeta Mbu = bu.getItemMeta();
			Mbu.setDisplayName("§aCe serveur tourne sous bukkit " + bv);
			bu.setItemMeta(Mbu);





			if(Main.ENABLED) {
				stat.setItem(0, m);
			} else {
				stat.setItem(0, n);
			}

			stat.setItem(2, g);
			stat.setItem(4, w);
			stat.setItem(6, ipi);
			stat.setItem(8, bu);




			player.openInventory(stat);





		}
		return false;
	}

}
