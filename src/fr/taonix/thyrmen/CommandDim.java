package fr.taonix.thyrmen;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandDim implements Listener, CommandExecutor {



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;


			Inventory invdim = Bukkit.createInventory(null, 9, "§cMenu de tp admin");


			ItemStack s = new ItemStack(Material.LIME_TERRACOTTA, 1);
			ItemMeta Ms = s.getItemMeta();
			Ms.setDisplayName("§aPTS");
			s.setItemMeta(Ms);
			
			ItemStack a = new ItemStack(Material.YELLOW_TERRACOTTA, 1);
			ItemMeta Ma = a.getItemMeta();
			Ma.setDisplayName("§6Thyrmen");
			a.setItemMeta(Ma);
			
			
			invdim.setItem(3, s);
			invdim.setItem(5, a);






			player.openInventory(invdim);


		}
		return true;

	}


}
