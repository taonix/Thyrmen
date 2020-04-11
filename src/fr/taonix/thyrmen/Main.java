package fr.taonix.thyrmen;


import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import fr.taonix.thyrmen.commands.CommandsMain;
import fr.taonix.thyrmen.maintenance.CommandMaintenance;
import fr.taonix.thyrmen.maintenance.PlayerLoginListener;
import fr.taonix.thyrmen.trades.Dongon1;
import fr.taonix.thyrmen.trades.Forge;
import fr.taonix.thyrmen.trades.Magie;
import fr.taonix.thyrmen.trades.Peche;
import fr.taonix.thyrmen.trades.been;
import fr.taonix.thyrmen.trades.cuir;
import fr.taonix.thyrmen.trades.marc;
import fr.taonix.thyrmen.trades.stuff;

public class Main extends JavaPlugin implements Listener {
	
	
	public static boolean ENABLED = false;
	public static int a = 1;
	
	private PluginManager pluginManager;
	
	@Override
	public void onEnable() {
		

		
		pluginManager = getServer().getPluginManager();
		pluginManager.registerEvents(new PlayerLoginListener(), this);
		System.out.println("Le plugin Thyrmen vient de s'activer.");
		getCommand("info").setExecutor(new CommandsMain());
		getCommand("bc").setExecutor(new CommandsMain());
		getCommand("npcb").setExecutor(new CommandsMain());
		getCommand("hub").setExecutor(new CommandsMain());
		getCommand("spawn").setExecutor(new CommandsSpawn());
		getCommand("invsee").setExecutor(new CommandInvsee());
		getCommand("dim").setExecutor(new CommandDim());
		getCommand("stat").setExecutor(new CommandStat());
		getCommand("map").setExecutor(new Commandmap());
		getCommand("legende").setExecutor(new Commandlegende());
		getCommand("maintenance").setExecutor(new CommandMaintenance());
		getServer().getPluginManager().registerEvents(new MenuLobby(), this);
		getServer().getPluginManager().registerEvents(new Menu(), this);
		getServer().getPluginManager().registerEvents(new BoxM(), this);
		getServer().getPluginManager().registerEvents(new Forge(), this);
		getServer().getPluginManager().registerEvents(new Magie(), this);
		getServer().getPluginManager().registerEvents(new Dongon1(), this);
		getServer().getPluginManager().registerEvents(new Peche(), this);
		getServer().getPluginManager().registerEvents(new cuir(), this);
		getServer().getPluginManager().registerEvents(new stuff(), this);
		getServer().getPluginManager().registerEvents(new been(), this);
		getServer().getPluginManager().registerEvents(new marc(), this);
	}
	
	
	
	
	@Override
	public void onDisable() {
		System.out.println("Le plugin Thyrmen vient de se désactiver.");
	}
	

	
	

}
