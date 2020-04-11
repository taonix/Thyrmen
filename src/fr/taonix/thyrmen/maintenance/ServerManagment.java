package fr.taonix.thyrmen.maintenance;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.taonix.thyrmen.Main;

public class ServerManagment {

	public static void KickAllNonOp() {

		for(Player player : Bukkit.getOnlinePlayers()) {
			if(!player.isOp() && Main.ENABLED) {

				player.kickPlayer(Messages.PLAYER_MAINTENACE_KICK.getMessage());
			}


		}
	}
}
