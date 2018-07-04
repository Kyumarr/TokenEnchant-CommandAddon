package me.kyumar.teaddon.utils;

import me.kyumar.teaddon.Main;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Messages {

    private Main main;
    public Messages(Main main){
        this.main = main;
    }


    public void sendUsage(CommandSender p){
        Main.getInstance().getConfig().getStringList("Messages.usage").forEach(stringa -> p.sendMessage(Main.getInstance().getUtils().translate(stringa)));
    }

    public void sendMsg(Player p, String string){
        p.sendMessage(Main.getInstance().getUtils().translate(Main.getInstance().getConfig().getString("prefix")) + " " + Main.getInstance().getUtils().translate(string));
    }
}
