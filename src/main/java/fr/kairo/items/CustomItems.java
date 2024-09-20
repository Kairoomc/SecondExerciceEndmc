package fr.kairo.items;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public abstract class CustomItems {

        public abstract void giveItem(Player player);

        public void onBlockBreak(BlockBreakEvent event) {}

        public void onRightClick(PlayerInteractEvent event) {}

        public void onEntityHit(EntityDamageByEntityEvent event) {}

        public abstract ItemStack setItemNBT(ItemStack item);

        public abstract void loadItemNBT(ItemStack item);

}
