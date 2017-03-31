package es.wiky.chat.cmd;

import java.io.IOException;

import es.wiky.chat.Main;
import es.wiky.chat.utils.Mensajes;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;

public class Cnick implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("cnick")){
			if(args.length == 0){
				p.sendMessage(Mensajes.help);
			}
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("change") || args[0].equalsIgnoreCase("set")){
					if(args[0].equalsIgnoreCase("change")){
						if(p.hasPermission("chatplus.change")){
							p.sendMessage(Mensajes.nick_change_usage);
						}else{
							p.sendMessage(Mensajes.noperm);
						}
					}
					if(args[0].equalsIgnoreCase("set")){
						if(p.hasPermission("chatplus.set")){
							p.sendMessage(Mensajes.nick_set_usage);
						}else{
							p.sendMessage(Mensajes.noperm);
						}
					}
				}else{
					p.sendMessage(Mensajes.help);
				}
			}
			if(args.length == 2){
				if(args[0].equalsIgnoreCase("change") || args[0].equalsIgnoreCase("set") || args[0].equalsIgnoreCase("remove")){
					if(args[0].equalsIgnoreCase("change")){
						if(p.hasPermission("chatplus.change")){
							if(Main.user.getString("Users." + p.getName() + ".cnick").equalsIgnoreCase("none")){
								Main.user.set("Users." + p.getName() + ".cnick", args[1]);

								p.sendMessage(Mensajes.successful_change_nick + " " + Mensajes.playerNewNick(p.getName()));
								try{
									Main.user.save(Main.users);
									Main.user.load(Main.users);
								}catch(IOException | InvalidConfigurationException e){
									e.printStackTrace();
								}
							}else{
								p.sendMessage(Mensajes.nick_changed);
							}
							p.setDisplayName(Main.user.getString("Users." + p.getName() + ".cnick"));

						}else{
							p.sendMessage(Mensajes.noperm);
						}
					}

					if(args[0].equalsIgnoreCase("set")){
						if(p.hasPermission("chatplus.set")){
							p.sendMessage(Mensajes.nick_set_usage);
						}else{
							p.sendMessage(Mensajes.noperm);
						}
					}

					if(args[0].equalsIgnoreCase("remove")){
						if(p.hasPermission("chatplus.remove")){
							Player pl = Bukkit.getPlayerExact(args[1]);
							if(pl != null){
								Main.user.set("Users." + pl.getName() + ".cnick", "none");
								try{
									Main.user.save(Main.users);
									Main.user.load(Main.users);
								}catch(IOException | InvalidConfigurationException e){
									e.printStackTrace();
								}
								pl.sendMessage(Mensajes.playerRemovedNick(pl.getName()));
								p.sendMessage(Mensajes.nick_remove);
							}else{
								p.sendMessage(Mensajes.player_dont_exist);
							}
						}else{
							p.sendMessage(Mensajes.noperm);
						}
					}
				}else{
					p.sendMessage(Mensajes.help);
				}
			}

			if(args.length == 3){
				if(args[0].equalsIgnoreCase("set")){
					if(p.hasPermission("chatplus.set")){
						Player pl = Bukkit.getPlayerExact(args[1]);
						if(pl != null){
							if(args[2].equalsIgnoreCase("none")){
								pl.setDisplayName(pl.getName());
								p.sendMessage(Mensajes.playerSet(pl.getName()));
								pl.sendMessage(Mensajes.playerSetReciever(pl.getName()));
							}else{
								Main.user.set("Users." + pl.getName() + ".cnick", args[2]);
								try{
									Main.user.save(Main.users);
									Main.user.load(Main.users);
								}catch(IOException | InvalidConfigurationException e){
									e.printStackTrace();
								}
								p.sendMessage(Mensajes.playerSet(p.getName()));
								pl.sendMessage(Mensajes.playerSetReciever(pl.getName()));
								pl.setDisplayName(Main.user.getString("Users." + pl.getName() + ".cnick"));
							}
						}else{
							p.sendMessage(Mensajes.player_dont_exist);
						}
					}else{
						p.sendMessage(Mensajes.noperm);
					}
				}else{
					p.sendMessage(Mensajes.help);
				}
			}
			if(args.length >= 4){
				p.sendMessage(Mensajes.help);
			}
		}
		return false;

	}
}
