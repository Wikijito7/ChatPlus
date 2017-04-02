package es.wiky.chat.files;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Files {

    public static File file = new File("plugins/ChatPlus/", "config.yml");
    public static File lang = new File("plugins/ChatPlus/", "lang.yml");
    public static File users = new File("plugins/ChatPlus/", "users.yml");
    public static YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
    public static YamlConfiguration clang = YamlConfiguration.loadConfiguration(lang);
    public static YamlConfiguration user = YamlConfiguration.loadConfiguration(users);

    public void setupFiles(){
        if(!file.exists()){
            file.mkdir();
            config.set("format", "<%DISPLAYNAME%>");
            config.set("op-color", "&c");
            config.set("party.color", "&b");
            config.set("party.activated", true);
            config.createSection("motd");
            config.createSection("motd.message");
            config.createSection("motd.activated");
            config.set("motd.message", "&3Welcome to the server &6%PLAYER%");
        }

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

        }

		if(!users.exists()){
            users.mkdir();
            user.createSection("Users");
        }
        saveFiles();
    }

    public void saveFiles(){
        try{
            clang.save(lang);
            clang.load(lang);
            user.save(users);
            user.load(users);
        }catch(IOException | InvalidConfigurationException e){
            e.printStackTrace();
        }
    }

}
