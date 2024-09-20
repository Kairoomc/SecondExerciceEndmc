package fr.kairo.items.utils;

import org.apache.commons.lang.time.DurationFormatUtils;

public abstract class Cooldown<T> {
    protected final String identifier;

    public Cooldown(String identifier) {
        this.identifier = identifier;
    }

    public abstract void setCooldown(T paramT, long paramLong);

    public abstract long getCooldown(T paramT);

    public abstract boolean isOnCooldown(T paramT);

    public String getRemainingTime(T object, boolean showHours) {
        String format;
        if (showHours) {
            format = "HH'h' mm'm' ss's'";

        } else {
            format = "mm'm' ss's'";
        }
        long difference = getCooldown(object) - System.currentTimeMillis();
        return DurationFormatUtils.formatDuration(difference, format);
    }
}
