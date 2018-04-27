package eu.pixelgriefer.pvp.main;

import de.lobby.hund.commands.setspawn_cmd;
import de.lobby.hund.commands.spawntp_cmd;
import de.lobby.hund.listener.JoinListener;
import de.lobby.hund.listener.NavigatorInv;
import de.lobby.hund.listener.PlayerHiderListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public class Main
        extends JavaPlugin
{
    public static String prefix = "�7[�6Lobby�7] �7";
    public static String noperms = "�7[�6Lobby�7] �cDazu hast du keine Permissions";
    public static Scoreboard sbside;

    public void onEnable()
    {
        System.out.println("[Lobby] Das Plugin wurde aktiviert");

        oninit();
    }

    public void oninit()
    {
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new NavigatorInv(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHiderListener(), this);
        Bukkit.getPluginCommand("setspawn").setExecutor(new setspawn_cmd());
        Bukkit.getPluginCommand("Spawn").setExecutor(new spawntp_cmd());
    }
}
