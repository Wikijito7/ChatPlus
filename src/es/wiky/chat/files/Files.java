package es.wiky.chat.files;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Files {

    public static File file = new File("plugins/ChatPlus", "config.yml");
    public static File lang = new File("plugins/ChatPlus/lang", "lang.yml");
    public static File users = new File("plugins/ChatPlus/users", "users.yml");
    public static YamlConfiguration clang = YamlConfiguration.loadConfiguration(lang);
    public static YamlConfiguration user = YamlConfiguration.loadConfiguration(users);



}
