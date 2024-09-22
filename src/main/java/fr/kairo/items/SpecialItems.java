package fr.kairo.items;

import fr.kairo.items.commands.ItemsCommands;
import fr.kairo.items.manager.ItemManager;
import fr.kairo.items.specialitems.HeroSword;
import fr.kairo.items.specialitems.KamikazAxe;
import fr.kairo.items.specialitems.ThiefHoe;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class SpecialItems extends JavaPlugin {

    private static SpecialItems instance;
    private ItemManager itemManager;

    @Override
    public void onEnable() {
        instance = this;
        this.itemManager = new ItemManager(this);
        itemManager.registerItem("kamikaz", new KamikazAxe());
        itemManager.registerItem("hero", new HeroSword());
        itemManager.registerItem("thief", new ThiefHoe());
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
    }

    private void registerItem(CustomItem item) {
    }
}
