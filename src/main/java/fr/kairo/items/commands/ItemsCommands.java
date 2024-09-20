package fr.kairo.items.commands;

import fr.kairo.items.CustomItems;
import fr.kairo.items.SpecialItems;
import fr.kairo.items.manager.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemsCommands implements CommandExecutor {
    private final ItemManager itemManager;

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

        if (itemManager == null) {
            sender.sendMessage(ChatColor.RED + "Erreur interne : gestionnaire d'items non initialisé.");
            return false;
        }

        if (args.length != 2) {
            sender.sendMessage(ChatColor.RED + "Utilisation correcte : /giveitem <joueur> <nom_item>");
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(ChatColor.RED + "Erreur : le joueur '" + args[0] + "' est introuvable.");
            return false;
        }

        String itemName = args[1];
        CustomItems customItem = itemManager.getItemByName(itemName);
        if (customItem == null) {
            sender.sendMessage(ChatColor.GOLD + "Liste des items disponibles :");
            sender.sendMessage(ChatColor.GOLD + itemManager.getItems().toString());
            return false;
        }

        customItem.giveItem(target);
        sender.sendMessage(ChatColor.GREEN + "Vous avez donné l'item " + ChatColor.AQUA + itemName + ChatColor.GREEN + " à " + ChatColor.AQUA + target.getName() + ChatColor.GREEN + ".");
        target.sendMessage(ChatColor.GREEN + "Vous avez reçu l'item " + ChatColor.AQUA + itemName + ChatColor.GREEN + " de la part de " + sender.getName() + ".");

        return true;
    }
}
