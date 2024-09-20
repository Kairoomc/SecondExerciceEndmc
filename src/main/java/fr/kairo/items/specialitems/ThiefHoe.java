package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItems;
import fr.kairo.items.SpecialItems;
import fr.kairo.items.manager.ItemManager;
import fr.kairo.items.utils.PlayerCooldown;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class ThiefHoe extends CustomItems {

    private final SpecialItems plugin;

    private long lastUsed = 0;


    public ThiefHoe(SpecialItems plugin) {
        this.plugin = plugin;
    }

    @Override
    public void giveItem(Player player) {
        ItemStack hoe = new ItemStack(Material.DIAMOND_HOE);
        hoe = setItemNBT(hoe);
        getItemMeta(hoe);
        player.getInventory().addItem(hoe);
    }

    @Override
    public void onRightClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        long currentTime = System.currentTimeMillis();
        PlayerCooldown playerCooldown = new PlayerCooldown(plugin, "houe");
        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("ThifHoe")) {
        if (playerCooldown.isOnCooldown(player)) {
            lastUsed = currentTime;

            new BukkitRunnable() {
                @Override
                public void run() {
                    player.sendMessage("Le joueur le plus riche est à proximité !");
                }
            }.runTaskLater(plugin, 0L);
            playerCooldown.setCooldown(player, 10);
        } else {
            player.sendMessage("Houe du voleur encore en cooldown " + playerCooldown.getRemainingTime(player, false));
        }

        }


    }

    @Override
    public ItemStack setItemNBT(ItemStack item) {

        return item;
    }

    public ItemMeta getItemMeta(ItemStack item) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("ThifHoe");
        item.setItemMeta(meta);
        return meta;
    }

    @Override
    public void loadItemNBT(ItemStack item) {

    }
}

