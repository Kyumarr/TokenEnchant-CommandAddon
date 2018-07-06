package me.kyumar.teaddon.utils;

import me.kyumar.teaddon.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages {

    private Main main;
    private String prefix;
    public Messages(Main main){
        this.main = main;
        
        this.prefix = main.getConfig().getString("prefix");
    }


    public void sendUsage(CommandSender p){
        Main.getInstance().getConfig().getStringList("Messages.usage").forEach(stringa -> p.sendMessage(Main.getInstance().getUtils().translate(stringa)));
    }

    public void sendMsg(CommandSender p, String path){
        p.sendMessage(getMsg(path));
    }
    
    public String getMsg(String path){
        return            
                ChatColor.translateAlternateColorCodes(
                '&',
                prefix + " " + main.getConfig().getString("Messages." + path)
        );
    }
}
