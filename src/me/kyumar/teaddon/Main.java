package me.kyumar.teaddon;

import me.kyumar.teaddon.commands.TokenCMD;
import me.kyumar.teaddon.utils.Messages;
import me.kyumar.teaddon.utils.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private Utils utils;
    private Messages messages;
    public static Main instance;

    public void onEnable(){
        setup();
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        registerCommands();
        this.messages = new Messages(this);
        this.utils = new Utils(this);
        instance = this;
    }

    public void setup(){
        if(this.getServer().getPluginManager().getPlugin("TokenEnchant") == null){
            getServer().getConsoleSender().sendMessage("§6TEAddon §7- §cTokenEnchant not installed ...");
            this.getServer().getPluginManager().disablePlugin(this);
        } else {
            getServer().getConsoleSender().sendMessage("§6TEAddon §7- §cTokenEnchant found !");
        }
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

    public Messages getMessage(){ return this.messages; }
}
