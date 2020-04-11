package fr.taonix.thyrmen.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_14_R1.entity.CraftEntity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import net.minecraft.server.v1_14_R1.Entity;

public class CommandsMain implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
		
			
			if(cmd.getName().equalsIgnoreCase("info")) {
				player.sendMessage("Plugin cree par : Taonix");
				player.sendMessage("version : 1.0");
				player.sendMessage("Language : francais");
				return true;
				
			}//fin commande info
			
			if(cmd.getName().equalsIgnoreCase("bc")) {
				
				//bc == 0 args
				
				if(args.length == 0) {
					player.sendMessage("Ooops ! Une erreur de syntaxe c'est produite ! Essaye avec /alert <message>");
				}//Fin bc 0 args
				
				//bc = 1arg ou plus
				
				if(args.length >= 1) {
					
					StringBuilder bc = new StringBuilder();
					for(String part : args) {
						bc.append(part + " ");
					}//fin Sb
					
					Bukkit.broadcastMessage("§l§4 [Information(s)] §r§l§6" + bc.toString());
					
					
				}//fin bc 1arg ou plus
				
			}//fin de bc
			
			if(cmd.getName().equalsIgnoreCase("ji")) {
				
				 String Online_player = Bukkit.getOnlinePlayers().toString();
				 
				String op = String.valueOf(Online_player);
				
				 player.sendMessage(op + " joueurs en ligne en ce moment");
				 
				}
			
			if(cmd.getName().equalsIgnoreCase("hub")) {
				
				Location hubloc = new Location(Bukkit.getWorld("Zelenox12"), 2752.47, 58.00, 2648.50);
				player.sendMessage("§l§6Bienvenue sur le hub du Monde !");
				player.teleport(hubloc);
			}
			
		}//Fin test player
		
		
		return false;
	}//Fin public boolean

}//fin CommandsMain
