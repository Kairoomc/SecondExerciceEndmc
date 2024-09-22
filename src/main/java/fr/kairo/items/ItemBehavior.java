package fr.kairo.items;

import org.bukkit.entity.Player;

public interface ItemBehavior {
    void onBlockBreak(Player player);
    void onEntityHit(Player player);
    void onRightClick(Player player);
}
