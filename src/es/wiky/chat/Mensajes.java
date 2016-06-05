package es.wiky.chat;





public class Mensajes {
	private Main plugin;
	public Mensajes (Main Main){
	this.plugin = Main;
		}
	public static String noperm = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.noperm"));
	public static String nick = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick"));
	public static String nick_change_usage = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick_change_usage"));
	public static String successful_change_nick = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.successful_change_nick"));
	public static String nick_changed = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick_changed"));
	public static String player_dont_exist = org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_dont_exist"));
	public static String remove_usage = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.remove_usage"));
	public static String nick_set_usage = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_set_usage"));
	public static String nick_not_changed = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_not_changed"));
	public static String playerSetReciever(String name){
		return org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_set_reciever").replaceAll("%NICK%", Main.user.getString("Users." + name + ".cnick")));
		}
	public static String playerNewNick(String name){
		return org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.new_nick").replaceAll("%NICK%", Main.user.getString("Users." + name + ".cnick")));
		}
	public static String playerSet(String name){
		return org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.player_set").replaceAll("%PLAYER%", name));
		}
	public static String help_change = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_change"));
	public static String help_set = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_set"));
	public static String help_remove = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_remove"));
	public static String help_admin = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_admin"));
	public static String help_motd = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.help_motd"));
	public static String nick_remove = org.bukkit.ChatColor.translateAlternateColorCodes('&', Main.clang.getString("lang.nick_remove"));
	public static String playerRemovedNick(String name){
		return org.bukkit.ChatColor.translateAlternateColorCodes('&',Main.clang.getString("lang.nick_removed").replaceAll("%PLAYER%", name));
		}
}
