package eu.pixelgriefer.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDu must ein Spieler sein.");
            return true;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("pvp.gm")){
            p.sendMessage("§l§3PvP | §c Dazu hast du keine Rechte.");
        return true;
    }
        if (args.length == 0) {
            p.sendMessage("§c/gm §f<0/1/2/3>");
            return true;
        }
        if (args.length == 3) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null);
        }
        if (args.length == 2) {
            p.sendMessage("§l§3PvP | §c Bitte benutze /gm §f<0/1/2/3>");
            return true;
        }
        int gm;
        try {
            gm = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            p.sendMessage("§c" + args[0] + "ist keine gültige Zahl.");
            return true;
        }
        if (gm < 0 || gm > 3) {
            p.sendMessage("§cGib eine Zahl zwischen 0 und 3 an.");
            return true;
        }
        if (gm == 0) {
            p.setGameMode(GameMode.SURVIVAL);
        } else if (gm == 1) {
            p.setGameMode(GameMode.CREATIVE);
        } else if (gm == 2) {
            p.setGameMode(GameMode.ADVENTURE);
        } else if (gm == 3) {
            p.setGameMode(GameMode.SPECTATOR);
        }
        p.sendMessage("§aDu bist jetzt im GameMode §9" + gm);
        return false;
    }
}
