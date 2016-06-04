package es.wiky.chat;

import org.bukkit.ChatColor;

public class Mensajes {
	private Main plugin;
	public static String noperm = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.noperm"));
	public static String nick = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick"));
	public static String nick_change_usage = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick_change_usage"));
	public static String successful_change_nick = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.successful_change_nick"));
	public static String nick_changed = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick_changed"));
	public static String player_dont_exist = ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_dont_exist"));
	public static String nick_set_usage = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String playerSetReciever(String name){
		return ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_set_reciever").replaceAll("%NICK%", Main.config.getString("Users." + name + ".cnick")));
		}
	public static String playerNewNick(String name){
		return ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.new_nick").replaceAll("%NICK%", Main.config.getString("Users." + name + ".cnick")));
		}
	public static String playerSet(String name){
		return ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_set").replaceAll("%PLAYER%", name));
		}
	public static String playerDisplayName(String name){
		return ChatColor.translateAlternateColorCodes('&',Main.config.getString("format").replaceAll("%DISPLAYNAME%", name));
		}
	public static String help_change = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String help_set = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String help_remove = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String help_admin = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String help_motd = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));





}
