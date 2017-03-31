package es.wiky.chat.utils;

import es.wiky.chat.Main;
import org.bukkit.ChatColor;

public class Mensajes {
	public static String noperm = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.noperm"));
	public static String help = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help"));
	public static String nick_change_usage = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_change_usage"));
	public static String successful_change_nick = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.successful_change_nick"));
	public static String nick_changed = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_changed"));
	public static String player_dont_exist = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.player_dont_exist"));
	public static String remove_usage = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.remove_usage"));
	public static String nick_set_usage = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String nick_not_changed = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_not_changed"));

	public static String playerSetReciever(String name){
		return ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.player_set_reciever").replaceAll("%NICK%", Main.user.getString("Users." + name + ".cnick")));
	}

	public static String playerNewNick(String name){
		return ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.new_nick").replaceAll("%NICK%", Main.user.getString("Users." + name + ".cnick")));
	}

	public static String playerSet(String name){
		return ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.player_set").replaceAll("%PLAYER%", name));
	}

	public static String help_change = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_change"));
	public static String help_set = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_set"));
	public static String help_remove = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_remove"));
	public static String help_admin = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_admin"));
	public static String help_motd = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_motd"));
	public static String nick_remove = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_remove"));
	public static String chatplus_help = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.chatplus_help"));
	public static String chatplus_info = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.chatplus_info"));
	public static String chatplus_admin = ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.chatplus_admin"));

	public static String playerRemovedNick(String name){
		return ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_removed").replaceAll("%PLAYER%", name));
	}
}
