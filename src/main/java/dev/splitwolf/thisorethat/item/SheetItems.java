package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SheetItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> ALUMINUM_SHEET = registerItem("aluminum_sheet");
    public static final DeferredItem<Item> BRASS_SHEET = registerItem("brass_sheet");
    public static final DeferredItem<Item> BRONZE_SHEET = registerItem("bronze_sheet");
    public static final DeferredItem<Item> COPPER_SHEET = registerItem("copper_sheet");
    public static final DeferredItem<Item> DIAMOND_SHEET = registerItem("diamond_sheet");
    public static final DeferredItem<Item> ELECTRUM_SHEET = registerItem("electrum_sheet");
    public static final DeferredItem<Item> EMERALD_SHEET = registerItem("emerald_sheet");
    public static final DeferredItem<Item> GOLD_SHEET = registerItem("gold_sheet");
    public static final DeferredItem<Item> INVAR_SHEET = registerItem("invar_sheet");
    public static final DeferredItem<Item> IRON_SHEET = registerItem("iron_sheet");
    public static final DeferredItem<Item> LAPIS_LAZULI_SHEET = registerItem("lapis_lazuli_sheet");
    public static final DeferredItem<Item> LEAD_SHEET = registerItem("lead_sheet");
    public static final DeferredItem<Item> NETHERITE_SHEET = registerItem("netherite_sheet");
    public static final DeferredItem<Item> NICKEL_SHEET = registerItem("nickel_sheet");
    public static final DeferredItem<Item> PLATINUM_SHEET = registerItem("platinum_sheet");
    public static final DeferredItem<Item> QUARTZ_SHEET = registerItem("quartz_sheet");
    public static final DeferredItem<Item> SILICON_SHEET = registerItem("silicon_sheet");
    public static final DeferredItem<Item> SILVER_SHEET = registerItem("silver_sheet");
    public static final DeferredItem<Item> STEEL_SHEET = registerItem("steel_sheet");
    public static final DeferredItem<Item> TIN_SHEET = registerItem("tin_sheet");
    public static final DeferredItem<Item> URANIUM_SHEET = registerItem("uranium_sheet");
    public static final DeferredItem<Item> ZINC_SHEET = registerItem("zinc_sheet");
    
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
