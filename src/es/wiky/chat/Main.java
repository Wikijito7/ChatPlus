package es.wiky.chat;

import java.io.File;
import java.io.IOException;

import es.wiky.chat.cmd.ChatPlus;
import es.wiky.chat.cmd.Cnick;
import es.wiky.chat.cmd.Motd;
import es.wiky.chat.cmd.Party;
import es.wiky.chat.events.Eventos;
import es.wiky.chat.files.Files;
import lombok.Getter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private PluginManager Plugin = this.getServer().getPluginManager();
	@Getter private static Main instance;
	@Getter private Files files;

	@Override
	public void onEnable(){
		System.out.println("Chat+ has been enabled");
		registrarCommandos();
		registrarEventos();
		files.saveFiles();
	}

	@Override
	public void onDisable(){
		System.out.println("Chat+ has been disabled");
	}

	private void registrarCommandos(){
		getCommand("cnick").setExecutor(new Cnick());
		getCommand("motd").setExecutor(new Motd(this));
		getCommand("chatplus").setExecutor(new ChatPlus(this));
		getCommand("party").setExecutor(new Party(this));
	}

	private void registrarEventos(){
		Plugin.registerEvents(new Eventos(this), this);
	}
}
