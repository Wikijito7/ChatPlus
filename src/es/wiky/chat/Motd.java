package es.wiky.chat;

import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class Motd implements CommandExecutor{

	
	
	private Main plugin;

	public Motd(Main main) {
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("motd")){
			if(args.length == 0){
				p.sendMessage("WIP" + " Soy el comando MOTD");
			}
			
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("help")){
				p.sendMessage("Hola, soy un mensaje de ayuda, quiéreme.");
			}
			
			if(args[0].equalsIgnoreCase("see")){
				p.sendMessage("a");
			}
			
		}
			
		if(args.length == 2){
			if(args[0].equalsIgnoreCase("change")){
				Main.clang.set("motd.message", args);
				try {
	                Main.clang.save(Main.lang);
	                Main.clang.load(Main.lang);
	            } catch (IOException | InvalidConfigurationException e) {
	                e.printStackTrace();
	            	}
			}
		}
			
			
			
			
			
			
			
		}
		return false;
	}
		
		
		
}
