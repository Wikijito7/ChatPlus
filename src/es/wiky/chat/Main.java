package es.wiky.chat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import es.wiky.chat.Comandos;
import es.wiky.chat.Eventos;

public class Main extends JavaPlugin {
	public static File file = new File("plugins/ChatPlus", "config.yml");
	public static File lang = new File("plugins/ChatPlus/lang", "lang.yml");
	public static File users = new File("plugins/ChatPlus/users" , "users.yml");
    //public static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static YamlConfiguration clang = YamlConfiguration.loadConfiguration(lang);
    public static YamlConfiguration user = YamlConfiguration.loadConfiguration(users);
	private PluginManager Plugin = this.getServer().getPluginManager();
	
	public void onEnable(){
		System.out.println("Chat+ has been enabled");
		registrarCommandos();
		registrarEventos();
		  FileConfiguration nconfig = getConfig();
	        nconfig.options().copyDefaults(true);
	        saveDefaultConfig();

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
		  
		  if (!users.exists()) {
	            users.mkdir();
	            user.createSection("Users");
	            try {
	                user.save(users);
	                user.load(users);
	            } catch (IOException | InvalidConfigurationException e) {
	                e.printStackTrace();
	            	}
	            }
			}	
	

	public void onDisable(){
		System.out.println("Chat+ has been disabled");
		try{
		//config.save(file);
		clang.save(lang);
		user.save(users);
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	 
		private void registrarCommandos() {
			getCommand("cnick").setExecutor(new Comandos(this));
			
		}
		
		private void registrarEventos() {
			Plugin.registerEvents(new Eventos(this), this);
		}
		
		private void Messages(){
			clang.set("lang.noperm", "&4Sorry, but you don't have permission to do that.");
			clang.set("lang.nick","&aTo use this command type &6/cnick help");
			clang.set("lang.nick_change_usage", "&aTo use this command you need to type &6/cnick change <nick>");
			clang.set("lang.successful_change_nick", "&aYou have changed your nick successfully.");
			clang.set("lang.new_nick",  "&aYour new nick is: &6%NICK%");
			clang.set("lang.nick_changed", "&4You have changed your nick, you can't change it again.");
			clang.set("lang.player_dont_exist", "&4Player not found. Does it exists?");
			clang.set("lang.player_set", "&6%PLAYER%&a's nick has been changed sucessfully.");
			clang.set("lang.player_set_reciever", "&aYour nick has been changed into &6%NICK%");
			clang.set("lang.nick_set_usage", "&8To use this command you need to type &a/cnick set <name> <nick>");
		}
}
