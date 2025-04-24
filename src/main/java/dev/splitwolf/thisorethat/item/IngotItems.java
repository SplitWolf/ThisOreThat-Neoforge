package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class IngotItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> ALUMINUM_INGOT = registerItem("aluminum_ingot");
    public static final DeferredItem<Item> BRASS_INGOT = registerItem("brass_ingot");
    public static final DeferredItem<Item> BRONZE_INGOT = registerItem("bronze_ingot");
    public static final DeferredItem<Item> ELECTRUM_INGOT = registerItem("electrum_ingot");
    public static final DeferredItem<Item> INVAR_INGOT = registerItem("invar_ingot");
    public static final DeferredItem<Item> LEAD_INGOT = registerItem("lead_ingot");
    public static final DeferredItem<Item> NICKEL_INGOT = registerItem("nickel_ingot");
    public static final DeferredItem<Item> PLATINUM_INGOT = registerItem("platinum_ingot");
    public static final DeferredItem<Item> SILICON_INGOT = registerItem("silicon_ingot");
    public static final DeferredItem<Item> SILVER_INGOT = registerItem("silver_ingot");
    public static final DeferredItem<Item> STEEL_INGOT = registerItem("steel_ingot");
    public static final DeferredItem<Item> TIN_INGOT = registerItem("tin_ingot");
    public static final DeferredItem<Item> URANIUM_INGOT = registerItem("uranium_ingot");
    public static final DeferredItem<Item> ZINC_INGOT = registerItem("zinc_ingot");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
