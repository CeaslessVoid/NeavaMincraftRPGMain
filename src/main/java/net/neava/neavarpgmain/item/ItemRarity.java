package net.neava.neavarpgmain.item;
import net.minecraft.network.chat.TextColor;

public enum ItemRarity {
    COMMON("Common", TextColor.fromRgb(0xAAAAAA), 1),
    UNCOMMON("Uncommon", TextColor.fromRgb(0x55FF55), 1.1),
    RARE("Rare", TextColor.fromRgb(0x5555FF), 1.25),
    EPIC("Epic", TextColor.fromRgb(0xAA00FF), 1.45),
    LEGENDARY("Legendary", TextColor.fromRgb(0xFFFF55), 1.7);

    private final String name;
    private final TextColor color;
    private final double modifier;

    ItemRarity(String name, TextColor color, double modifier) {
        this.name = name;
        this.color = color;
        this.modifier = modifier;
    }

    public String getName() {
        return name;
    }

    public TextColor getColor() {
        return color;
    }

    public double getModifier() {
        return modifier;
    }

    public static ItemRarity fromString(String name) {
        for (ItemRarity rarity : values()) {
            if (rarity.name.equalsIgnoreCase(name)) {
                return rarity;
            }
        }
        return COMMON; // Default to COMMON if invalid
    }
}

