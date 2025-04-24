package dev.splitwolf.thisorethat.datagen;

import dev.splitwolf.thisorethat.ThisOreThat;
import dev.splitwolf.thisorethat.block.MetalBlocks;
import dev.splitwolf.thisorethat.block.OreBlocks;
import dev.splitwolf.thisorethat.block.RawOreBlocks;
import dev.splitwolf.thisorethat.item.*;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ThisOreThat.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        registerMetalItems();
    }

    private void registerMetalItems() {
        IngotItems.ITEMS.getEntries().forEach(this::ingotItem);
        RawOreItems.ITEMS.getEntries().forEach(this::rawOreItem);
        NuggetItems.ITEMS.getEntries().forEach(this::nuggetItem);
        DustItems.ITEMS.getEntries().forEach(this::dustItem);
        GearItems.ITEMS.getEntries().forEach(this::gearItem);
        SheetItems.ITEMS.getEntries().forEach(this::sheetItem);
        MetalBlocks.BLOCK_ITEMS.getEntries().forEach(this::blockItem);
        OreBlocks.BLOCK_ITEMS.getEntries().forEach(this::blockItem);
        RawOreBlocks.BLOCK_ITEMS.getEntries().forEach(this::blockItem);
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder blockItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),modLoc("block/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder ingotItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/ingot/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder dustItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/dust/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder gearItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/gear/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder sheetItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/sheet/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder rawOreItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/raw_ore/" + item.getId().getPath()));
    }

    @SuppressWarnings("UnusedReturnValue")
    private ItemModelBuilder nuggetItem(DeferredHolder<Item, ? extends Item> item) {
        return withExistingParent(item.getId().getPath(),
                mcLoc("item/generated"))
                .texture("layer0",
                        modLoc("item/nugget/" + item.getId().getPath()));
    }

}
