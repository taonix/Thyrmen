package fr.taonix.thyrmen;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandInvsee implements CommandExecutor {



	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		// TODO Auto-generated method stub

		if(sender instanceof Player) {
			Player player = (Player) sender;

			if(cmd.getName().equalsIgnoreCase("invsee")) {

				if(args.length == 1) {
					if(args[0].equalsIgnoreCase("on")) {

						player.canSee(player);

					}
				}

			}
		}

	return false;


}

}


