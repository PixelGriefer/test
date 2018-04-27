package eu.pixelgriefer.pvp.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class Items
{
    public static void run(Player p)
    {
        ItemStack navigator = new ItemStack(Material.COMPASS);
        ItemMeta mnavigator = navigator.getItemMeta();
        mnavigator.setDisplayName("�7� �cNavigator �7(Rechtsklick)");
        navigator.setItemMeta(mnavigator);

        ItemStack spieler = new ItemStack(Material.BLAZE_ROD);
        ItemMeta mspieler = spieler.getItemMeta();
        mspieler.setDisplayName("�7� �3Spielersichtbarkeit �7(Rechtsklick)");
        spieler.setItemMeta(mspieler);

        ItemStack gadgets = new ItemStack(Material.ENDER_CHEST);
        ItemMeta mgadgets = gadgets.getItemMeta();
        mgadgets.setDisplayName("�7� �3Gadgets �7(Rechtsklick)");
        gadgets.setItemMeta(mgadgets);

        ItemStack server = new ItemStack(Material.NETHER_STAR);
        ItemMeta mserver = server.getItemMeta();
        mserver.setDisplayName("�7� �3Server �7(Rechtsklick)");
        server.setItemMeta(mserver);

        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta meta = (SkullMeta)head.getItemMeta();
        meta.setOwner(p.getName());
        meta.setDisplayName("�7� �3Profil �7(Rechtsklick)");
        head.setItemMeta(meta);

        p.getInventory().setItem(0, navigator);
        p.getInventory().setItem(1, spieler);
        p.getInventory().setItem(4, gadgets);
        p.getInventory().setItem(7, server);
        p.getInventory().setItem(8, head);
    }
}
