package me.kyumar.teaddon.utils;


import me.kyumar.teaddon.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;


public class Utils {

    private Main main;

    public Utils(Main main){
        this.main = main;
    }

    public String translate(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public String prefix = translate(Main.getInstance().getConfig().getString("prefix"));

    public void sendUsage(CommandSender p){
        ArrayList<String> string = new ArrayList<>();
        Main.getInstance().getConfig().getStringList("Messages.usage").forEach(stringa -> p.sendMessage(translate(stringa)));
    }

    public boolean checkArg(String arg) {
        try {
            Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
