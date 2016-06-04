package es.wiky.chat;

import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class Comandos implements CommandExecutor {
	private Main plugin;
	public Comandos(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cnick")){
			if(args.length == 0){
				p.sendMessage(Mensajes.nick);
			}
			if(args.length == 1){
			  if(args[0].equalsIgnoreCase("change") || args[0].equalsIgnoreCase("help")|| args[0].equalsIgnoreCase("set")){		
				if(args[0].equalsIgnoreCase("change")){
					p.sendMessage(Mensajes.nick_change_usage);
						}
				if(args[0].equalsIgnoreCase("help")){
					p.sendMessage("WIP");
						}
				if(args[0].equalsIgnoreCase("set")){
					p.sendMessage(Mensajes.nick_set_usage);
						}	
				
			  		}else{
			  			p.sendMessage(Mensajes.nick);
			  		}
				}
			
			
			if(args.length == 2){
						if(args[0].equalsIgnoreCase("change")){
							if(Main.user.getString("Users." + p.getName() + ".cnick").equalsIgnoreCase("none")) {
							Main.user.set("Users." + p.getName() + ".cnick", args[1]);
							p.sendMessage(Mensajes.successful_change_nick + " " + Mensajes.playerNewNick(p.getName()));
							this.plugin.saveDefaultConfig();	
							}else{
								p.sendMessage(Mensajes.nick_changed);
							 	}
						}
						
					if(args[0].equalsIgnoreCase("set")){
						p.sendMessage(Mensajes.nick_set_usage);
							}
					
					if(args[0].equalsIgnoreCase("remove")){
						Player pl = Bukkit.getPlayerExact(args[1]);
						Main.user.set("Users." + pl.getName() + ".cnick", "none");
						try {
			                Main.user.save(Main.file);
			                Main.user.load(Main.file);
			            } catch (IOException | InvalidConfigurationException e) {
			                e.printStackTrace();
			            	}
						pl.sendMessage("Done");
						p.sendMessage("Eliminated");
								}
					}
			
			
			if(args.length == 3){
				if(args[0].equalsIgnoreCase("set")){
					Player pl = Bukkit.getPlayerExact(args[1]);
					if(pl != null){
						if(args[2].equalsIgnoreCase("none")){
							pl.setDisplayName(pl.getName());
							p.sendMessage(Mensajes.playerSet(p.getName()));
							pl.sendMessage(Mensajes.playerSetReciever(pl.getName()));
						}else{
						Main.user.set("Users." + pl.getName() + ".cnick", args[2]);
						try {
			                Main.user.save(Main.file);
			                Main.user.load(Main.file);
			            } catch (IOException | InvalidConfigurationException e) {
			                e.printStackTrace();
			            	}
						p.sendMessage(Mensajes.playerSet(p.getName()));
						pl.sendMessage(Mensajes.playerSetReciever(pl.getName()));
							}
					}else{
						p.sendMessage(Mensajes.player_dont_exist + " " + args[1]);
					 	}
					}
				}
			}
					
			return false;

		}
}
