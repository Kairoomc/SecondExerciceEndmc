package fr.kairo.items.commands;

import fr.kairo.items.CustomItem;
import fr.kairo.items.SpecialItems;
import fr.kairo.items.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class  ItemsCommands implements CommandExecutor {
    private ItemManager itemManager;

    public ItemsCommands(SpecialItems plugin) {
        this.itemManager = ((SpecialItems) plugin).getItemManager();
        plugin.getCommand("givecustomitem").setExecutor(this);
    }
    /**
     * Le constructeur reçoit le gestionnaire d'items (ItemManager)
     * qui sera utilisé pour gérer les items spéciaux.
     *
     * @param itemManager Le gestionnaire d'items
     */
    public ItemsCommands(ItemManager itemManager) {
        this.itemManager = itemManager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Cette commande peut seulement être utilisée par un joueur.");
            return true;
        }

        Player player = (Player) sender;
        if (!player.hasPermission("endmc.admin")) {
            player.sendMessage("§cVous n'avez pas la permission d'utiliser cette commande.");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("§c/givecustomitem <item>");
            return false;
        }

        String itemName = args[0].toLowerCase();
        CustomItem item = itemManager.getItem(itemName);

        if (item == null) {
            player.sendMessage("L'item spécifié n'existe pas.");
            return true;
        }

        player.getInventory().addItem(item.getItem());
        player.sendMessage("Vous avez reçu l'item: " + itemName);

        return true;
    }
}
