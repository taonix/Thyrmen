package fr.taonix.thyrmen.maintenance;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.taonix.thyrmen.Main;

public class CommandMaintenance  implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {


		if(label.equalsIgnoreCase("maintenance")) {


			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("on")) {

					if(sender.isOp()) {

						Main.ENABLED = true;
						ServerManagment.KickAllNonOp();
						sender.sendMessage(Messages.MAINTENANCE_ENABLED.getMessage());
					} else {

						sender.sendMessage(Messages.PLAYER_NOT_OP.getMessage());
					}

				} else if(args[0].equalsIgnoreCase("off")) {

					if(sender.isOp()) {

						Main.ENABLED = false;
						sender.sendMessage(Messages.MAINTENANCE_DISABLED.getMessage());
					} else {

						sender.sendMessage(Messages.PLAYER_NOT_OP.getMessage());
					}
				}

			} else {
				sender.sendMessage(Messages.COMMAND_INVALID.getMessage());
			}

		}



		return true;

	}

}
