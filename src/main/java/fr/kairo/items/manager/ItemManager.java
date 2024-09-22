package fr.kairo.items.manager;

import com.google.common.reflect.Reflection;
import fr.kairo.items.CustomItem;
import fr.kairo.items.SpecialItems;
import fr.kairo.items.specialitems.HeroSword;
import fr.kairo.items.specialitems.KamikazAxe;
import fr.kairo.items.specialitems.ThiefHoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private Map<String, CustomItem> items = new HashMap<>();
    private JavaPlugin plugin;

    public ItemManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void registerItem(String name, CustomItem item) {
        if (item != null && name != null && !name.isEmpty()) {
            items.put(name, item);
            plugin.getLogger().info("Item registered: " + name);
        } else {
            plugin.getLogger().warning("Failed to register item: " + name);
        }
    }

    public CustomItem getItem(String name) {
        return items.getOrDefault(name, null);
    }
}
