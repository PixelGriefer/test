package eu.pixelgriefer.pvp.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatclearCommand implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("pvp.chatclear")) {
                if (args.length == 0) {

                    for (int i = 0; i < 175; i++) {
                        Bukkit.broadcastMessage("  ");
                    }
                    Bukkit.broadcastMessage("§l§3PvP | §a Der Chat wurde vom §3" + p.getName() + " §ageleert.");

                } else
                    p.sendMessage("§l§3PvP | §c Bitte benutze §f/ChatClear");
            } else
                p.sendMessage("§l§3PvP | §c Dazu hast du keine Rechte.");
        } else
            sender.sendMessage("§l§3PvP | §cDazu musst du ein Spieler sein.");
        return false;
    }
}
