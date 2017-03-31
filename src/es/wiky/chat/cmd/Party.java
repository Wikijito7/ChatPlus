package es.wiky.chat.cmd;

import java.io.IOException;

import es.wiky.chat.Main;
import es.wiky.chat.utils.Mensajes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class Party implements CommandExecutor {
	private Main plugin;
	
	public Party(Main main){
		this.plugin = main;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("party")){
			if(args.length == 0){
				p.sendMessage("Illo, que esto funsiona, no te raie");
				}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("create")){
					p.sendMessage("Recuerda k pa sto tiene k aser akello miarma, e desi, koje i pon krea con tu bida");	
				}else{
					p.sendMessage(Mensajes.help);
				}
				
			}
			if(args.length == 2){
			if(args[0].equalsIgnoreCase("create") || args[0].equalsIgnoreCase("invite")){	
				if(args[0].equalsIgnoreCase("create")){
					if(Main.user.getString("Users." + p.getName() + ".party").equalsIgnoreCase("none")){
							Main.user.set("Users." + p.getName() + ".party", args[1]);
						
							try{
								Main.user.save(Main.users);
								Main.user.load(Main.users);
							}catch(IOException | InvalidConfigurationException e){
								e.printStackTrace();
							}
						
							p.sendMessage("party cre� miarma " + args[1]);
						
					}else{
							p.sendMessage("Ueputa, k ia tiene un party exo, k no m trolee");
						 
						}
					}
				if(args[0].equalsIgnoreCase("invite")){
					
					
					}
				}
			}
		}
		
		
		return false;
	}

}
