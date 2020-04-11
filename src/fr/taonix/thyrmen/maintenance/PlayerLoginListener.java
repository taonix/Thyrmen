package fr.taonix.thyrmen.maintenance;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.taonix.thyrmen.Main;

public class PlayerLoginListener implements Listener {

	@EventHandler (priority = EventPriority.HIGH)
	public void onPlayerJoin(PlayerJoinEvent event) {
		final Player player = event.getPlayer();


		if(Main.ENABLED) {
			if(!player.isOp()) {
				player.kickPlayer(Messages.PLAYER_MAINTENACE_KICK.getMessage());
			}
		}
	}
}
