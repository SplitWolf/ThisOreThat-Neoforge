package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class DustItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> ALUMINUM_DUST = registerItem("aluminum_dust");
    public static final DeferredItem<Item> BRASS_DUST = registerItem("brass_dust");
    public static final DeferredItem<Item> BRONZE_DUST = registerItem("bronze_dust");
    public static final DeferredItem<Item> COAL_DUST =registerItem("coal_dust");
    public static final DeferredItem<Item> COPPER_DUST = registerItem("copper_dust");
    public static final DeferredItem<Item> DIAMOND_DUST = registerItem("diamond_dust");
    public static final DeferredItem<Item> ELECTRUM_DUST = registerItem("electrum_dust");
    public static final DeferredItem<Item> EMERALD_DUST = registerItem("emerald_dust");
    public static final DeferredItem<Item> GOLD_DUST = registerItem("gold_dust");
    public static final DeferredItem<Item> INVAR_DUST = registerItem("invar_dust");
    public static final DeferredItem<Item> IRON_DUST = registerItem("iron_dust");
    public static final DeferredItem<Item> LAPIS_LAZULI_DUST = registerItem("lapis_lazuli_dust");
    public static final DeferredItem<Item> LEAD_DUST = registerItem("lead_dust");
    public static final DeferredItem<Item> NETHERITE_DUST = registerItem("netherite_dust");
    public static final DeferredItem<Item> NICKEL_DUST = registerItem("nickel_dust");
    public static final DeferredItem<Item> PLATINUM_DUST = registerItem("platinum_dust");
    public static final DeferredItem<Item> QUARTZ_DUST = registerItem("quartz_dust");
    public static final DeferredItem<Item> SALT_DUST = registerItem("salt_dust");
    public static final DeferredItem<Item> SILICON_DUST = registerItem("silicon_dust");
    public static final DeferredItem<Item> SILVER_DUST = registerItem("silver_dust");
    public static final DeferredItem<Item> STEEL_DUST = registerItem("steel_dust");
    public static final DeferredItem<Item> SULFUR_DUST = registerItem("sulfur_dust");
    public static final DeferredItem<Item> TIN_DUST = registerItem("tin_dust");
    public static final DeferredItem<Item> URANIUM_DUST = registerItem("uranium_dust");
    public static final DeferredItem<Item> ZINC_DUST = registerItem("zinc_dust");
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
