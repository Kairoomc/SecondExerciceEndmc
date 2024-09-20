package fr.kairo.items;

import fr.kairo.items.commands.ItemsCommands;
import fr.kairo.items.listeners.ItemEventListener;
import fr.kairo.items.manager.ItemManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SpecialItems extends JavaPlugin {

    private static SpecialItems instance;
    private ItemManager itemManager;

    @Override
    public void onEnable() {
        instance = this;
        this.itemManager = new ItemManager(this);
        this.registerCommands();
        this.registerListeners();
    }

    @Override
    public void onDisable() {
    }

    public static SpecialItems getInstance() {
        return instance;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }

    private void registerCommands() {
        this.getCommand("givespecialitem").setExecutor(new ItemsCommands(itemManager));
    }

    private void registerListeners() {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new ItemEventListener(itemManager), this);
    }
}
