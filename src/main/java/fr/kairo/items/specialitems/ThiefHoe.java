package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItem;
import fr.kairo.items.ItemBehavior;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ThiefHoe extends CustomItem implements ItemBehavior {
    private long lastUsed = 0;

    public ThiefHoe() {
        super(new ItemStack(Material.DIAMOND_HOE));
    }

    @Override
    public void onBlockBreak(Player player) {
    }

    @Override
    public void onEntityHit(Player player) {
    }

    @Override
    public void onRightClick(Player player) {
        long cooldown = 600000; // 10 minutes en millisecondes
        if ((System.currentTimeMillis() - lastUsed) >= cooldown) {
            lastUsed = System.currentTimeMillis();
        } else {
            player.sendMessage("La houe est en cooldown. Veuillez patienter.");
        }
    }
}