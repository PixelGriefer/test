package eu.pixelgriefer.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

        if (!(cs instanceof Player)) return true;

        Player p = (Player)cs;

        if (!p.hasPermission("pvp.fly.self")) {
            p.sendMessage("1");
            return true;
        }

        if (args.length == 0){

            if (p.getAllowFlight()){
                p.setAllowFlight(false);
                p.sendMessage("§l§3PvP |  §fDein Flugmodus wurde: §cdeaktiviert.");
                return true;
            }else {
                p.setAllowFlight(true);
                p.sendMessage("§l§3PvP |  §fDein Flugmodus wurde: §aAktiviert.");
            }

            return true;
        }

        if (args.length == 1){

            Player t = Bukkit.getPlayer(args[0]);

            if (t == null){
                if (p.hasPermission("pvp.fly.others"))
                    p.sendMessage("§l§3PvP |  §3" + args[0]+ "§c  ist nicht return true");
                else {
                    p.sendMessage("1");
                    return true;
                }
            }
            if (t.getAllowFlight()){
                t.setAllowFlight(false);
                p.sendMessage("§l§3PvP | §f Du hast §3" + t.getName()+ " §fden Flugmodus entfernt.");
                return true;
            }else {
                t.setAllowFlight(true);
                p.sendMessage("§l§3PvP | §f Du hast §3" + t.getName() + " §fin den Flugmodus gesetzt.");

            }
            return false;
        }


        return false;
    }
}