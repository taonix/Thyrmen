package fr.taonix.thyrmen.maintenance;

public enum Messages {
	
	COMMAND_INVALID("§6 Vous vouliez dire on ou off ?"),
	
	MAINTENANCE_ENABLED("§6§lLa maintenance est activé"),
	MAINTENANCE_DISABLED("§6§lLa maintenance est désactivé"),
	
	PLAYER_NOT_OP("Vous n'avez pas les permissions pour utiliser cett commande !"),
	
	
	PLAYER_MAINTENACE_KICK("Maintenance en cours");

	private final String Message;
	
	Messages(String message) {
		this.Message = message;
	}
	
	public String getMessage() {
		return Message;
	}

}
