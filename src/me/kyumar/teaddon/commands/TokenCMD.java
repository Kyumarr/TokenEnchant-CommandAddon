package me.kyumar.teaddon.commands;

import com.vk2gpz.tokenenchant.TokenEnchant;
import com.vk2gpz.tokenenchant.api.TokenEnchantAPI;
import me.kyumar.teaddon.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenCMD implements CommandExecutor {


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(Main.getInstance().getConfig().getString("prefix") + " " + Main.getInstance().getUtils().translate(Main.getInstance().getConfig().getString("Messages.no-player")));
            return true;
        }
        Player p = (Player)sender;
        if(!(p.hasPermission("tokenenchantaddon.use"))){
            Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.no-permission"));
            return true;
                }
        switch (args.length){
            default:
                    Main.getInstance().getMessage().sendUsage(p);
                    break;
            case 3:
                switch (args[0].toLowerCase()){
                    case "send":
                        if(Main.getInstance().getUtils().checkArg(args[2])) {
                            int tokens = (int) TokenEnchant.getInstance().getTokens(p);
                            Player t = Bukkit.getPlayer(args[1]);
                            int amount = Integer.parseInt(args[2]);
                            if (tokens < amount) {
                                Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.insufficient-tokens"));
                            } else if (tokens >= amount) {
                                if (t == null) {
                                    Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.player-not-found"));
                                    return true;
                                }
                                if (t == p) {
                                    Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.error"));
                                    return true;
                                }

                                TokenEnchant.getInstance().addTokens(t, amount);
                                TokenEnchant.getInstance().removeTokens(p, amount);

                                Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.tokens-sended").replaceAll("%tokens", Double.toString(amount)).replaceAll("%target", t.getName()));
                                Main.getInstance().getMessage().sendMsg(t, Main.getInstance().getConfig().getString("Messages.tokens-received").replaceAll("%tokens", Double.toString(amount)).replaceAll("%receiver", p.getName()));
                                }
                            } else {
                                Main.getInstance().getMessage().sendMsg(p, Main.getInstance().getConfig().getString("Messages.must-be-int"));
                        }
                            break;
                }
        }
        return false;
    }
}
