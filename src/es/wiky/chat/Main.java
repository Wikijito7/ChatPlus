package es.wiky.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import es.wiky.chat.Comandos;
import es.wiky.chat.Eventos;

public class Main extends JavaPlugin {
	public static File file = new File("plugins/Chat+", "config.yml");
	public static File lang = new File("plugins/Chat+/lang", "lang.yml");
    public static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static YamlConfiguration clang = YamlConfiguration.loadConfiguration(lang);
	private PluginManager Plugin = this.getServer().getPluginManager();
	public void onEnable(){
		System.out.println("Chat+ has been enabled");
		registrarCommandos();
		registrarEventos();
		  if (!file.exists()) {
	            file.mkdir();
	            config.set("commands.activated", true);
	            try {
	                config.save(file);
	                config.load(file);
	            } catch (IOException | InvalidConfigurationException e) {
	                e.printStackTrace();
	            	}
	            }
		  if (!lang.exists()) {
	            lang.mkdir();
	            Messages();
	            try {
	                clang.save(lang);
	                clang.load(lang);
	            } catch (IOException | InvalidConfigurationException e) {
	                e.printStackTrace();
	            	}
	            }
			}	
	
	
	
	public void onDisable(){
		System.out.println("Chat+ has been disabled");
		try{
		config.save(file);
		clang.save(lang);
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	
	
	public String Color(char altColorChar, String textToTranslate) {
		return null;
	}
	 
		private void registrarCommandos() {
			getCommand("nick").setExecutor(new Comandos(this));
			
		}
		
		private void registrarEventos() {
			Plugin.registerEvents(new Eventos(this), this);
		}

		private void Messages(){
			clang.set("lang.noperm", "&4Sorry, but you don't have permission to do that.");
			clang.set("lang.nick","&aTo use this command type &6/nick help");
			clang.set("lang.nick_change_usage", "&aTo use this command you need to type &6/nick change <nick>");
			clang.set("lang.successful_change_nick", "&aYou have changed your nick successfully.");
			clang.set("lang.new_nick",  "&aYour new nick is: &6%NICK%");
			clang.set("lang.nick_changed", "&4You have changed your nick, you can't chat it again.");
			clang.set("lang.player_dont_exist", "&4Player not found. Does it exists?");
			clang.set("lang.player_set", "&6%PLAYER%&a's nick has been changed sucessfully.");
			clang.set("lang.player_set_reciever", "&aYour nick has been changed into &6%NICK%");
		}
}
