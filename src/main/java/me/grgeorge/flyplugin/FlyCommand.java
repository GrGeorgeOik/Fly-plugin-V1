package me.grgeorge.flyplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> list_of_flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                flyMethod(player);
            }else if(args.length == 1){
                Player target = Bukkit.getPlayer(args[0]);
                flyMethod(target);
            }
        }

        return true;
    }

    private void flyMethod(Player player){
        if(player.hasPermission("flyplugin.fly")){
            if (list_of_flying_players.contains(player)){
                list_of_flying_players.remove(player);
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.RED + "You can not fly anymore!");
            }else if(!list_of_flying_players.contains(player)){
                list_of_flying_players.add(player);
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.AQUA + "You are now able to fly!");
            }
        }
    }
}
