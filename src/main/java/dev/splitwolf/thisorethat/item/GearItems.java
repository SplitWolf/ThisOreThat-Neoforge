package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GearItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> BRASS_GEAR = registerItem("brass_gear");
    public static final DeferredItem<Item> BRONZE_GEAR = registerItem("bronze_gear");
    public static final DeferredItem<Item> COPPER_GEAR = registerItem("copper_gear");
    public static final DeferredItem<Item> DIAMOND_GEAR = registerItem("diamond_gear");
    public static final DeferredItem<Item> ELECTRUM_GEAR = registerItem("electrum_gear");
    public static final DeferredItem<Item> EMERALD_GEAR = registerItem("emerald_gear");
    public static final DeferredItem<Item> GOLD_GEAR = registerItem("gold_gear");
    public static final DeferredItem<Item> INVAR_GEAR = registerItem("invar_gear");
    public static final DeferredItem<Item> IRON_GEAR = registerItem("iron_gear");
    public static final DeferredItem<Item> LEAD_GEAR = registerItem("lead_gear");
    public static final DeferredItem<Item> NETHERITE_GEAR = registerItem("netherite_gear");
    public static final DeferredItem<Item> NICKEL_GEAR = registerItem("nickel_gear");
    public static final DeferredItem<Item> PLATINUM_GEAR = registerItem("platinum_gear");
    public static final DeferredItem<Item> SILICON_GEAR = registerItem("silicon_gear");
    public static final DeferredItem<Item> SILVER_GEAR = registerItem("silver_gear");
    public static final DeferredItem<Item> STEEL_GEAR = registerItem("steel_gear");
    public static final DeferredItem<Item> TIN_GEAR = registerItem("tin_gear");
    public static final DeferredItem<Item> URANIUM_GEAR = registerItem("uranium_gear");
    public static final DeferredItem<Item> ZINC_GEAR = registerItem("zinc_gear");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
