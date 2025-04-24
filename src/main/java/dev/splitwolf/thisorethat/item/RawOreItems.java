package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RawOreItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> RAW_ALUMINUM = registerItem("raw_aluminum");
    public static final DeferredItem<Item> RAW_LEAD = registerItem("raw_lead");
    public static final DeferredItem<Item> RAW_NICKEL = registerItem("raw_nickel");
    public static final DeferredItem<Item> RAW_PLATINUM = registerItem("raw_platinum");
    public static final DeferredItem<Item> RAW_SALT = registerItem("raw_salt");
    public static final DeferredItem<Item> RAW_SILVER = registerItem("raw_silver");
    public static final DeferredItem<Item> RAW_SULFUR = registerItem("raw_sulfur");
    public static final DeferredItem<Item> RAW_TIN = registerItem("raw_tin");
    public static final DeferredItem<Item> RAW_URANIUM = registerItem("raw_uranium");
    public static final DeferredItem<Item> RAW_ZINC = registerItem("raw_zinc");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
