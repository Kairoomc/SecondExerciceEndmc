package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItem;
import fr.kairo.items.ItemBehavior;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HeroSword extends CustomItem implements ItemBehavior {
    private Player owner = null;

    public HeroSword() {
        super(new ItemStack(Material.DIAMOND_SWORD));
    }

    @Override
    public void onBlockBreak(Player player) {
    }

    @Override
    public void onEntityHit(Player player) {
        if (owner == null) {
            owner = player;
        } else if (!owner.equals(player)) {
            player.sendMessage("Seul le joueur " + owner.getName() + " peut utiliser cette épée !");
        }
    }

    @Override
    public void onRightClick(Player player) {
    }
}
