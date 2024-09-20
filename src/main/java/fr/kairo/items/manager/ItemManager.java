package fr.kairo.items.manager;

import fr.kairo.items.CustomItems;
import fr.kairo.items.SpecialItems;
import fr.kairo.items.specialitems.HeroSword;
import fr.kairo.items.specialitems.KamikazeAxe;
import fr.kairo.items.specialitems.ThiefHoe;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {

    private final Map<String, CustomItems> items = new HashMap<>();

    /**
     * Constructeur de la classe ItemManager.
     * Initialise et enregistre les items spéciaux dans la map.
     *
     */
    public ItemManager(SpecialItems plugin) {
        items.put("KamikazAxe", new KamikazeAxe(plugin));
        items.put("HeroSword", new HeroSword());
        items.put("ThiefHoe", new ThiefHoe(plugin));
    }

    /**
     * Récupère un item à partir de son name.
     *
     * @param name Le nom de l'item recherché
     * @return L'item correspondant au nom, ou null s'il n'existe pas
     */
    public CustomItems getItemByName(String name) {
        return items.get(name);
    }

    /**
     * Retourne tous les items
     *
     * @return La map contenant tous les items
     */
    public Map<String, CustomItems> getItems() {
        return items;
    }
}
