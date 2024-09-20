package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItems;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class HeroSword extends CustomItems {

    private String ownerUUID = null;

    @Override
    public void giveItem(Player player) {
        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
        sword = setItemNBT(sword);
        player.getInventory().addItem(sword);
    }

    @Override
    public void onEntityHit(EntityDamageByEntityEvent event) {
        Player attacker = (Player) event.getDamager();
        ItemStack itemInHand = attacker.getInventory().getItemInMainHand();

        if (itemInHand.getType() == Material.DIAMOND_SWORD) {
            if (ownerUUID == null) {
                ownerUUID = attacker.getUniqueId().toString();
                setItemNBT(itemInHand);
            } else if (!attacker.getUniqueId().toString().equals(ownerUUID)) {
                event.setCancelled(true);
                attacker.sendMessage("§cVous n'êtes pas le propriétaire de cette épée !");
            }
        }
    }

    @Override
    public ItemStack setItemNBT(ItemStack item) {
        return item;
    }

    @Override
    public void loadItemNBT(ItemStack item) {
    }
}

