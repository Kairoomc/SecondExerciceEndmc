package fr.kairo.items.listeners;

import fr.kairo.items.manager.ItemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemEventListener implements Listener {

    private final ItemManager itemManager;

    /**
     * Constructeur qui initialise le gestionnaire d'items (ItemManager).
     *
     * @param itemManager Le gestionnaire des items spéciaux
     */
    public ItemEventListener(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    /**
     * Événement appelé lorsque le joueur casse un bloc.
     * Ici, on vérifie si l'item "KamikazAxe" est en jeu et agit en conséquence.
     *
     * @param event L'événement de casse de bloc
     */
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        itemManager.getItemByName("KamikazAxe").onBlockBreak(event);
    }

    /**
     * Événement appelé lorsqu'un joueur interagit (clic) avec un bloc ou un objet.
     * L'item "ThiefHoe" a un effet lors de ce type d'interaction.
     *
     * @param event L'événement d'interaction du joueur
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        itemManager.getItemByName("ThiefHoe").onRightClick(event);
    }

    /**
     * Événement appelé lorsqu'une entité est frappée par un joueur ou une autre entité.
     * L'item "HeroSword" a un effet lorsqu'il frappe une entité.
     *
     * @param event L'événement de dommage infligé par une entité
     */
    @EventHandler
    public void onEntityHit(EntityDamageByEntityEvent event) {
        itemManager.getItemByName("HeroSword").onEntityHit(event);
    }
}
