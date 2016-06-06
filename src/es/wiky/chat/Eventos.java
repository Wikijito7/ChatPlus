package es.wiky.chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();

		if (!Main.user.contains("Users." + p.getName())) {
			List<String> h = new ArrayList<String>();
			h.add(p.getName());
			
			Main.user.set("Users", h);
			Main.user.set("Users." + p.getName() + ".cnick", "none");
			try {
				Main.user.save(Main.users);
                Main.user.load(Main.users);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            	}
            }
		
			p.sendMessage(Mensajes.nick_not_changed);
			p.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("motd.message").replaceAll("%PLAYER%", p.getDisplayName())));
		}
		
		@EventHandler(priority = EventPriority.LOWEST)
		public void onLeave(PlayerQuitEvent event){
			Player p = event.getPlayer();
			Main.user.set("Users." + p.getName() + ".cnick", p.getDisplayName());
			try {
				Main.user.save(Main.users);
                Main.user.load(Main.users);
            } catch (IOException | InvalidConfigurationException e) {
                e.printStackTrace();
            	}
		}
	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event){
		Player p = event.getPlayer();

		 	if (Main.user.getString("Users." + p.getName() + ".cnick").equalsIgnoreCase("none")) {
		 			 event.setFormat(this.plugin.getConfig().getString("format").replaceAll("%DISPLAYNAME%", p.getName()) + " "  + org.bukkit.ChatColor.translateAlternateColorCodes('&', event.getMessage()));
		 		} else {
		 			event.setFormat(this.plugin.getConfig().getString("format").replaceAll("%DISPLAYNAME%", org.bukkit.ChatColor.translateAlternateColorCodes('&', p.getDisplayName() + org.bukkit.ChatColor.RESET)) + " " + org.bukkit.ChatColor.translateAlternateColorCodes('&', event.getMessage()));
		 		}
		  	

		

	}
}
