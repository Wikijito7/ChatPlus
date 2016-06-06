package es.wiky.chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class ChatPlus implements CommandExecutor {
	private Main plugin;
	public ChatPlus(Main main) {
		this.plugin = main;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("chatplus")){
			if(args.length == 0){
				p.sendMessage(org.bukkit.ChatColor.GREEN + "This command is divided in 3 subcommands:");
				p.sendMessage(org.bukkit.ChatColor.GOLD + "/chatplus help " + Mensajes.chatplus_help);
				p.sendMessage(org.bukkit.ChatColor.RED + "/chatplus admin " + Mensajes.chatplus_admin);
				p.sendMessage(org.bukkit.ChatColor.GOLD + "/chatplus info " + Mensajes.chatplus_info);
			}
			
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("help")){
					p.sendMessage(org.bukkit.ChatColor.GRAY + "<------------------------------------------->");
					p.sendMessage(" ");
					p.sendMessage(org.bukkit.ChatColor.GREEN + "Welcome to the help section.");
					p.sendMessage(" ");
					p.sendMessage(org.bukkit.ChatColor.GOLD + "/cnick change <nick> " + Mensajes.help_change);
					p.sendMessage(org.bukkit.ChatColor.GOLD + "/motd see " + Mensajes.help_motd);
					if(p.hasPermission("chatplus.admin")){
						p.sendMessage(org.bukkit.ChatColor.RED + "/chatplus admin " + Mensajes.help_admin);
					}
					p.sendMessage(" ");
					p.sendMessage(org.bukkit.ChatColor.GRAY + "<------------------------------------------->");
						
				}
				if(args[0].equalsIgnoreCase("admin")){
					if(p.hasPermission("chatplus.admin")){
						p.sendMessage(org.bukkit.ChatColor.GRAY + "<------------------------------------------->");
						p.sendMessage(" ");
						p.sendMessage(org.bukkit.ChatColor.RED + "Welcome to the admin's help section");
						p.sendMessage(" ");
						p.sendMessage(org.bukkit.ChatColor.GOLD + "/cnick set <name> <nick> " +Mensajes.help_set);
						p.sendMessage(org.bukkit.ChatColor.GOLD + "/cnick remove <name> " +Mensajes.help_remove);
						p.sendMessage(" ");
						p.sendMessage(org.bukkit.ChatColor.GRAY + "<------------------------------------------->");
					}else{
						p.sendMessage(Mensajes.noperm);
					}
				}
				if(args[0].equalsIgnoreCase("info")){
					p.sendMessage(org.bukkit.ChatColor.GREEN + "Welcome to the info section");
					p.sendMessage(org.bukkit.ChatColor.GOLD + "Author: " + org.bukkit.ChatColor.GREEN + "Wikijito7");
					p.sendMessage(org.bukkit.ChatColor.GOLD + "Contributor: " + org.bukkit.ChatColor.GREEN + "cadox8");
					p.sendMessage(org.bukkit.ChatColor.GOLD + "Version: " + org.bukkit.ChatColor.GREEN + this.plugin.getDescription().getVersion());
					
					
				}
			}
			
			
			if(args.length >= 2){
				p.sendMessage(Mensajes.help);
				}
			
		}
		return false;
	}

}
