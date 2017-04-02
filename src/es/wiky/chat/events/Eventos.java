package es.wiky.chat.events;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.wiky.chat.Main;
import es.wiky.chat.files.Files;
import es.wiky.chat.utils.Mensajes;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Eventos implements Listener {
	private Main plugin;

	public Eventos(Main instance){
		this.plugin = instance;
	}
	private Files files = Main.getInstance().getFiles();

	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();

		if(!files.user.contains("Users." + p.getName())){
			List<String> h = new ArrayList<String>();
			h.add(p.getName());

			files.user.set("Users", h);
			files.user.set("Users." + p.getName() + ".cnick", "none");
			files.user.set("Users." + p.getName() + ".party", "none");
			try{
				files.user.save(files.users);
				files.user.load(files.users);
			}catch(IOException | InvalidConfigurationException e){
				e.printStackTrace();
			}
		}

		if(files.user.get("Users." + p.getName() + ".cnick").equals("none")){
			p.sendMessage(Mensajes.nick_not_changed);
		}

		p.sendMessage(ChatColor.translateAlternateColorCodes('&', files.config.getString("motd.message").replaceAll("%PLAYER%", p.getDisplayName())));
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onLeave(PlayerQuitEvent event){
		Player p = event.getPlayer();
		files.user.set("Users." + p.getName() + ".cnick", p.getDisplayName());
		try{
			files.user.save(files.users);
			files.user.load(files.users);
		}catch(IOException | InvalidConfigurationException e){
			e.printStackTrace();
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event){
		Player p = event.getPlayer();

		if(p.hasPermission("chatplus.color")){
			switch(files.user.getString("Users." + p.getName() + ".cnick")){
				case "none":
					event.setFormat(files.config.getString("format").replaceAll("%DISPLAYNAME%", p.getName()) + " " + org.bukkit.ChatColor.translateAlternateColorCodes('&', event.getMessage()));
					break;
				default:
					event.setFormat(files.config.getString("format").replaceAll("%DISPLAYNAME%", org.bukkit.ChatColor.translateAlternateColorCodes('&', p.getDisplayName() + org.bukkit.ChatColor.RESET)) + " " + org.bukkit.ChatColor.translateAlternateColorCodes('&', event.getMessage()));
					break;
			}
		}else{
			switch(files.user.getString("Users." + p.getName() + ".cnick")){
				case "none":
					event.setFormat(files.config.getString("format").replaceAll("%DISPLAYNAME%", p.getName()) + " " + event.getMessage());
					break;
				default:
					event.setFormat(files.config.getString("format").replaceAll("%DISPLAYNAME%", org.bukkit.ChatColor.translateAlternateColorCodes('&', p.getDisplayName() + org.bukkit.ChatColor.RESET)) + " " + event.getMessage());
					break;
			}
		}

	}
}
