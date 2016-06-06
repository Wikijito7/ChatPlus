package es.wiky.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
				p.sendMessage(Mensajes.help);
			}
			
		if(args.length == 1){
			if(args[0].equalsIgnoreCase("see")){
				if(p.hasPermission("chatplus.motd")){
				p.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("motd.message")));
				}else{
					p.sendMessage(Mensajes.noperm);
				}
			}else{
				p.sendMessage(Mensajes.help);
			}
			
		}
			
		if(args.length >= 2){
			p.sendMessage(Mensajes.help);
				}	
		}
		return false;
	}
		
		
		
}
