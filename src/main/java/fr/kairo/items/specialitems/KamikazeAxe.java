package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItems;
import fr.kairo.items.SpecialItems;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class KamikazeAxe extends CustomItems {


    private final SpecialItems plugin;

    public KamikazeAxe(SpecialItems plugin) {
        this.plugin = plugin;
    }

    @Override
    public void giveItem(Player player) {
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        axe = setItemNBT(axe);
        player.getInventory().addItem(axe);
    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.DIAMOND_AXE) {
            World world = event.getBlock().getWorld();
            world.createExplosion(event.getBlock().getLocation(), 4.0f);
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
