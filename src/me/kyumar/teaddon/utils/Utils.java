package me.kyumar.teaddon.utils;

import me.kyumar.teaddon.Main;
import org.bukkit.ChatColor;


public class Utils {

    private Main main;
    public Utils(Main main){
        this.main = main;
    }

    public String translate(String text){
        return ChatColor.translateAlternateColorCodes('&', text);
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
