package es.wiky.chat;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {
	@SuppressWarnings("unused")
	private Main plugin;
	public Comandos(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("nick")){
			if(args.length == 0){
				p.sendMessage(Mensajes.nick);
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("change")){
					p.sendMessage(Mensajes.nick_change_usage);
					}
				if(args[0].equalsIgnoreCase("help")){
					p.sendMessage("WIP");
				}
				if(args[0].equalsIgnoreCase("set")){
					p.sendMessage("asdasd");
				}	
				
			}
			
			if(args.length == 2){
					if(Main.config.getString("Users." + p.getName() + ".cnick").equalsIgnoreCase("none")) {
						if(args[0].equalsIgnoreCase("change")){
							Main.config.set("Users." + p.getName() + ".cnick", args[1]);
							p.sendMessage(Mensajes.successful_change_nick + " " + Mensajes.playerNewNick(p.getName()));
							p.setDisplayName(Main.config.getString("Users." + p.getName() + ".cnick"));
							 try {
				                Main.config.save(Main.file);
				                Main.config.load(Main.file);
				            } catch (IOException | InvalidConfigurationException e) {
				                e.printStackTrace();
					            	}
							}
				}else{
					p.sendMessage(Mensajes.nick_changed);
					}
				if(args[0].equalsIgnoreCase("set")){
						p.sendMessage("WIP");
					}
					}
			
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("set")){
					Player pl = Bukkit.getPlayerExact(args[1]);
					if(pl != null){
						Main.config.set("Users." + pl.getName() + ".cnick", args[2]);
						try {
			                Main.config.save(Main.file);
			                Main.config.load(Main.file);
			            } catch (IOException | InvalidConfigurationException e) {
			                e.printStackTrace();
			            	}
						p.setDisplayName(Main.config.getString("Users." + pl.getName() + ".cnick"));
						p.sendMessage(Mensajes.playerSet(p.getName()));
						pl.sendMessage(Mensajes.playerSetReciever(pl.getName()));
					 }else{
							p.sendMessage(Mensajes.player_dont_exist + " " + args[1]);
					 		}
					}
				}
			}	
					
			return false;

}
}
