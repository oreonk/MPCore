package com.oreonk.commands;



import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Main implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
        if (arguments.length == 0){
            if (sender instanceof Player){
                Player player = (Player) sender;
                Msg.send(player, ChatColor.LIGHT_PURPLE  + "/mp rank *ник* *привилегия* <30d/60d>" + ChatColor.WHITE + " - выдать игроку привилегию. Без указания времени привилегия будет выдана навсегда.");
                return true;
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE  + "/mp rank *ник* *привилегия* <30d/60d>" + ChatColor.WHITE + " - выдать игроку привилегию. Без указания времени привилегия будет выдана навсегда.");
                return true;
            }
        } else if(arguments.length == 4 && arguments[0].equals("rank") && (Bukkit.getPlayer(arguments[1]) == null || !MinePotionsCore.getInstance().priv.contains(arguments[2]) || !arguments[3].equals("30d") || !arguments[3].equals("60d"))){
            if (sender instanceof Player){
                Player player = (Player) sender;
                Msg.send(player, ChatColor.RED + "Данные введенны неверно, список привилегий: " + ChatColor.WHITE + MinePotionsCore.getInstance().priv);
                return true;
            }
        }
        return true;
    }
}
