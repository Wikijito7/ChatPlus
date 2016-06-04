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

public class Eventos implements Listener {
	private Main plugin;

	public Eventos(Main instance){

	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onJoin(PlayerJoinEvent event){
		Player p = event.getPlayer();

		if (!Main.user.contains("User." + p.getName())) {
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
		}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onChat(AsyncPlayerChatEvent event){
		Player p = event.getPlayer();

				String form1 = Mensajes.playerDisplayName(p.getName()) + org.bukkit.ChatColor.RESET + " " + event.getMessage();
		 		String form2 = ChatColor.translateAlternateColorCodes('&', Mensajes.playerDisplayName(Main.user.getString("Users." + p.getName() + ".cnick")) + org.bukkit.ChatColor.RESET + " " + event.getMessage());
				  
		 	if (Main.user.getString("Users." + p.getName() + ".cnick").equalsIgnoreCase("none")) {
		 			event.setFormat(form1);
		 		} else {
		 			event.setFormat(form2);
		 		}
		  	

		

	}
}
