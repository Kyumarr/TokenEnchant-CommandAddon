package me.kyumar.teaddon;

import com.vk2gpz.tokenenchant.TokenEnchant;
import me.kyumar.teaddon.commands.TokenCMD;
import me.kyumar.teaddon.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private Utils utils;
    public static Main instance;

    public void onEnable(){
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerCommands();
        this.utils = new Utils(this);
        instance = this;
    }

    public void registerCommands(){
        getCommand("tokens").setExecutor(new TokenCMD());
    }

    public static Main getInstance(){
        return instance;
    }

    public Utils getUtils(){
        return this.utils;
    }
}
