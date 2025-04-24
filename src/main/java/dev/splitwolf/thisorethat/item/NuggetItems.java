package dev.splitwolf.thisorethat.item;

import dev.splitwolf.thisorethat.ThisOreThat;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class NuggetItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ThisOreThat.MODID);

    public static final DeferredItem<Item> ALUMINUM_NUGGET = registerItem("aluminum_nugget");
    public static final DeferredItem<Item> BRASS_NUGGET = registerItem("brass_nugget");
    public static final DeferredItem<Item> BRONZE_NUGGET = registerItem("bronze_nugget");
    public static final DeferredItem<Item> COPPER_NUGGET = registerItem("copper_nugget");
    public static final DeferredItem<Item> DIAMOND_NUGGET = registerItem("diamond_nugget");
    public static final DeferredItem<Item> ELECTRUM_NUGGET = registerItem("electrum_nugget");
    public static final DeferredItem<Item> EMERALD_NUGGET = registerItem("emerald_nugget");
    public static final DeferredItem<Item> INVAR_NUGGET = registerItem("invar_nugget");
    public static final DeferredItem<Item> LAPIS_LAZULI_NUGGET = registerItem("lapis_lazuli_nugget");
    public static final DeferredItem<Item> LEAD_NUGGET = registerItem("lead_nugget");
    public static final DeferredItem<Item> NETHERITE_NUGGET = registerItem("netherite_nugget");
    public static final DeferredItem<Item> NICKEL_NUGGET = registerItem("nickel_nugget");
    public static final DeferredItem<Item> PLATINUM_NUGGET = registerItem("platinum_nugget");
    public static final DeferredItem<Item> QUARTZ_NUGGET = registerItem("quartz_nugget");
    public static final DeferredItem<Item> SILICON_NUGGET = registerItem("silicon_nugget");
    public static final DeferredItem<Item> SILVER_NUGGET = registerItem("silver_nugget");
    public static final DeferredItem<Item> STEEL_NUGGET = registerItem("steel_nugget");
    public static final DeferredItem<Item> TIN_NUGGET = registerItem("tin_nugget");
    public static final DeferredItem<Item> URANIUM_NUGGET = registerItem("uranium_nugget");
    public static final DeferredItem<Item> ZINC_NUGGET = registerItem("zinc_nugget");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    private static DeferredItem<Item> registerItem(String itemID) {
        return ITEMS.register(itemID,
                () -> new Item(new Item.Properties())
        );
    }
}
