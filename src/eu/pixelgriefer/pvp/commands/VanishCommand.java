package eu.pixelgriefer.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor{

    ArrayList<String> vanish = new ArrayList<String>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p =(Player)sender;

        if (p.hasPermission("pvp.vanish")) {
            if (args.length == 0) {
                if (vanish.contains(p.getName())) {
                    vanish.remove(p.getName());
                    p.sendMessage("§3 Du bist nun fuer alle Spieler §csichtbar.");
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.showPlayer(p);
                    }
                }else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.hidePlayer(p);
                    }
                    vanish.add(p.getName());
                    p.sendMessage("§3 Du bist nun für alle Spieler §cunsichbar.");
                }
            } else if (args.length == 1) {

            }else {
                p.sendMessage("Falscher Syntax.");
            }
        } else  {
            p.sendMessage("§cDazu hast du keine Rechte.");
        }
        return false;
    }
}