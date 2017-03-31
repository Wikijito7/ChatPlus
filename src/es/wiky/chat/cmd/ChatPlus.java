package es.wiky.chat.cmd;

import es.wiky.chat.Main;
import es.wiky.chat.utils.Mensajes;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatPlus implements CommandExecutor {
	private Main plugin;

	public ChatPlus(Main main){
		this.plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("chatplus")){
			if(args.length == 0){
				p.sendMessage(ChatColor.GREEN + "This command is divided in 3 subcommands:");
				p.sendMessage(ChatColor.GOLD + "/chatplus help " + Mensajes.chatplus_help);
				p.sendMessage(ChatColor.RED + "/chatplus admin " + Mensajes.chatplus_admin);
				p.sendMessage(ChatColor.GOLD + "/chatplus info " + Mensajes.chatplus_info);
			}

			if(args.length == 1){
				if(args[0].equalsIgnoreCase("help")){
					p.sendMessage(ChatColor.GRAY + "<------------------------------------------->");
					p.sendMessage(" ");
					p.sendMessage(ChatColor.GREEN + "Welcome to the help section.");
					p.sendMessage(" ");
					p.sendMessage(ChatColor.GOLD + "/cnick change <nick> " + Mensajes.help_change);
					p.sendMessage(ChatColor.GOLD + "/motd see " + Mensajes.help_motd);
					if(p.hasPermission("chatplus.admin")){
						p.sendMessage(ChatColor.RED + "/chatplus admin " + Mensajes.help_admin);
					}
					p.sendMessage(" ");
					p.sendMessage(ChatColor.GRAY + "<------------------------------------------->");

				}
				if(args[0].equalsIgnoreCase("admin")){
					if(p.hasPermission("chatplus.admin")){
						p.sendMessage(ChatColor.GRAY + "<------------------------------------------->");
						p.sendMessage(" ");
						p.sendMessage(ChatColor.RED + "Welcome to the admin's help section");
						p.sendMessage(" ");
						p.sendMessage(ChatColor.GOLD + "/cnick set <name> <nick> " + Mensajes.help_set);
						p.sendMessage(ChatColor.GOLD + "/cnick remove <name> " + Mensajes.help_remove);
						p.sendMessage(" ");
						p.sendMessage(ChatColor.GRAY + "<------------------------------------------->");
					}else{
						p.sendMessage(Mensajes.noperm);
					}
				}
				if(args[0].equalsIgnoreCase("info")){
					p.sendMessage(ChatColor.GREEN + "Welcome to the info section");
					p.sendMessage(ChatColor.GOLD + "Author: " + org.bukkit.ChatColor.GREEN + "Wikijito7");
					p.sendMessage(ChatColor.GOLD + "Contributor: " + org.bukkit.ChatColor.GREEN + "cadox8");
					p.sendMessage(ChatColor.GOLD + "Version: " + org.bukkit.ChatColor.GREEN + this.plugin.getDescription().getVersion());

				}
			}

			if(args.length >= 2){
				p.sendMessage(Mensajes.help);
			}

		}
		return false;
	}

}
