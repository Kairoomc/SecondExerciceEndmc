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

public abstract class CustomItem {
        protected ItemStack item;

        public CustomItem(ItemStack item) {
                this.item = item;
        }

        public abstract void onBlockBreak(Player player);

        public abstract void onEntityHit(Player player);

        public abstract void onRightClick(Player player);

        public ItemStack getItem() {
                return item;
        }
}