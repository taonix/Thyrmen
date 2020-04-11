package fr.taonix.thyrmen;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandsSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			player.sendMessage("§6téléportation au spawn dans 10 secondes");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Location spawn = new Location(player.getWorld(), -818, 76, -748);
			player.sendMessage("§l§6Bienvenue sur le spawn du Monde !");
			player.teleport(spawn);
		}
		
		return false;
	}

}
