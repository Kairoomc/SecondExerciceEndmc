package fr.kairo.items.utils;

import fr.kairo.items.SpecialItems;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;

import java.util.List;

public class PlayerCooldown extends Cooldown<Player> {
    private final SpecialItems specialItems;

    public PlayerCooldown(SpecialItems specialItems, String identifier) {
        super(identifier);
        this.specialItems = specialItems;
    }

    public void setCooldown(Player player, long end) {
        player.setMetadata(getFormattedIdentifier(), (MetadataValue)new FixedMetadataValue((Plugin)this.specialItems, Long.valueOf(end)));
    }

    public long getCooldown(Player player) {
        List<MetadataValue> metadataValues = player.getMetadata(getFormattedIdentifier());
        if (metadataValues.size() == 0)
            return 0L;
        return ((Long)((MetadataValue)metadataValues.get(0)).value()).longValue();
    }

    public boolean isOnCooldown(Player player) {
        return (System.currentTimeMillis() <= getCooldown(player));
    }

    private String getFormattedIdentifier() {
        return this.identifier;
    }
}
