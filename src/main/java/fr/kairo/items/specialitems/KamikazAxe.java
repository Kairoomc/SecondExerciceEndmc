package fr.kairo.items.specialitems;

import fr.kairo.items.CustomItem;
import fr.kairo.items.ItemBehavior;
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

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class KamikazAxe extends CustomItem implements ItemBehavior {

    public KamikazAxe() {
        super(new ItemStack(Material.DIAMOND_AXE));
    }

    @Override
    public void onBlockBreak(Player player) {
        player.getWorld().createExplosion(player.getLocation(), 2.0F);
    }

    @Override
    public void onEntityHit(Player player) {
    }

    @Override
    public void onRightClick(Player player) {
    }
}

