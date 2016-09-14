package es.wiky.chat;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static File file = new File("plugins/ChatPlus", "config.yml");
	public static File lang = new File("plugins/ChatPlus/lang", "lang.yml");
	public static File users = new File("plugins/ChatPlus/users", "users.yml");
	public static YamlConfiguration clang = YamlConfiguration.loadConfiguration(lang);
	public static YamlConfiguration user = YamlConfiguration.loadConfiguration(users);
	private PluginManager Plugin = this.getServer().getPluginManager();

	@Override
	public void onEnable(){
		System.out.println("Chat+ has been enabled");
		registrarCommandos();
		registrarEventos();
		FileConfiguration nconfig = getConfig();
		nconfig.options().copyDefaults(true);
		saveDefaultConfig();

		if(!lang.exists()){
			lang.mkdir();
			//Messages of lang file
			clang.set("lang.noperm", "&4Sorry, but you don't have permission to do that.");
			clang.set("lang.nick_removed", "&aYou have removed the nick of %PLAYER%.");
			clang.set("lang.nick_remove", "&aYour nick has been removed.");
			clang.set("lang.nick_not_changed", "&7You haven't change your nick yet, to do it type &b/cnick change <nick>.");
			clang.set("lang.help", "&aTo use this command type &6/chatplus help.");
			clang.set("lang.nick_change_usage", "&aTo use this command you need to type &6/cnick change <nick>.");
			clang.set("lang.successful_change_nick", "&aYou have changed your nick successfully.");
			clang.set("lang.new_nick", "&aYour new nick is: &6%NICK%.");
			clang.set("lang.nick_changed", "&4You have changed your nick, you can't change it again.");
			clang.set("lang.player_dont_exist", "&4Player not found. Does it exists?");
			clang.set("lang.player_set", "&6%PLAYER%&a's nick has been changed sucessfully.");
			clang.set("lang.player_set_reciever", "&aYour nick has been changed into &6%NICK%.");
			clang.set("lang.nick_set_usage", "&aTo use this command you need to type &6/cnick set <name> <nick>.");
			clang.set("lang.help_admin", "&aUsing this command you see the administrator's commands.");
			clang.set("lang.help_change", "&aUsing this command you change your custom nick.");
			clang.set("lang.help_motd", "&aUsing this command you change the message that users see when they enter.");
			clang.set("lang.help_remove", "&aUsing this command you remove the nick of a player.");
			clang.set("lang.help_set", "&aUsing this command you set to a player a custom nick.");
			clang.set("lang.remove_usage", "&aTo use this command, you need to type &6/nick remove <name>");
			clang.set("lang.motd_usage", "&aTo use this command, you need to type &6/motd help");
			clang.set("lang.see_motd_usage", "&aTo use this command, you need to type &6/motd see");
			clang.set("lang.see_motd_help", "&aUsing this command, you see the motd that is currently in the server.");
			clang.set("lang.chatplus_help", "&aUsing this command, you see the help section.");
			clang.set("lang.chatplus_info", "&aUsing this command, you see the info of the plugin");
			clang.set("lang.chatplus_admin", "&aUsing this command, you see the admin's help section.");
			try{
				clang.save(lang);
				clang.load(lang);
			}catch(IOException | InvalidConfigurationException e){
				e.printStackTrace();
			}
		}

		if(!users.exists()){
			users.mkdir();
			user.createSection("Users");
			try{
				user.save(users);
				user.load(users);
			}catch(IOException | InvalidConfigurationException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onDisable(){
		System.out.println("Chat+ has been disabled");
		try{
			clang.save(lang);
			user.save(users);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	private void registrarCommandos(){
		getCommand("cnick").setExecutor(new Cnick());
		getCommand("motd").setExecutor(new Motd(this));
		getCommand("chatplus").setExecutor(new ChatPlus(this));
	}

	private void registrarEventos(){
		Plugin.registerEvents(new Eventos(this), this);
	}

	//TODO: Implement
	@SuppressWarnings("unused")
	private void motd(){
		clang.createSection("motd");
		clang.createSection("motd.message");
		clang.createSection("motd.activated");
		clang.set("motd.message", "&3Welcome to the server &6%PLAYER%");
	}

}
