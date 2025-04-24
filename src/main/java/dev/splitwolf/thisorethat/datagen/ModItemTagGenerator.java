package dev.splitwolf.thisorethat.datagen;

import dev.splitwolf.thisorethat.ThisOreThat;
import dev.splitwolf.thisorethat.block.MetalBlocks;
import dev.splitwolf.thisorethat.block.OreBlocks;
import dev.splitwolf.thisorethat.block.RawOreBlocks;
import dev.splitwolf.thisorethat.item.IngotItems;
import dev.splitwolf.thisorethat.item.RawOreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ThisOreThat.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        IngotItems.ITEMS.getEntries().forEach(this::tagIngots);
        RawOreItems.ITEMS.getEntries().forEach(this::tagRawMaterials);
//        NuggetItems.ITEMS.getEntries().forEach(this::tagNuggets);
//        DustItems.ITEMS.getEntries().forEach(this::tagDustItems);
//        GearItems.ITEMS.getEntries().forEach(this::tagGearItems);
//        SheetItems.ITEMS.getEntries().forEach(this::tagSheetItems);

        MetalBlocks.BLOCK_ITEMS.getEntries().forEach(this::tagMetalBlockItems);
        OreBlocks.BLOCK_ITEMS.getEntries().forEach(this::tagOres);
        RawOreBlocks.BLOCK_ITEMS.getEntries().forEach(this::tagRawOreBlocks);

        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "silicon"));
        this.tag(tag).add(IngotItems.SILICON_INGOT.get());
    }

    private void tagMetalBlockItems(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "blocks/" + item.getId().getPath().replace("_block","")));
        this.tag(tag).add(item.get());
        TagKey<Item> storage = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "storage_blocks/" + item.getId().getPath().replace("_block","")));
        this.tag(storage).add(item.get());
    }

    private void tagOres(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "ores/" + item.getId().getPath().replace("_ore","").replace("deepslate_","")));
        this.tag(tag).add(item.get());

        tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", "ores"));
        this.tag(tag).add(item.get());

        tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", "ores_in_ground/stone"));
        if(!item.getId().getPath().contains("deepslate"))
            this.tag(tag).add(item.get());

        tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge", "ores_in_ground/deepslate"));
        if(item.getId().getPath().contains("deepslate"))
            this.tag(tag).add(item.get());
    }

    private void tagRawOreBlocks(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "blocks/" + item.getId().getPath().replace("_block","")));
        this.tag(tag).add(item.get());
        TagKey<Item> storage = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "storage_blocks/" + item.getId().getPath().replace("_block","")));
        this.tag(storage).add(item.get());
    }

    private void tagIngots(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "ingots/" + item.getId().getPath().replace("_ingot","")));
        this.tag(tag).add(item.get());
    }

    private void tagNuggets(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "nuggets/" + item.getId().getPath().replace("_nugget","")));
        this.tag(tag).add(item.get());
    }


    private void tagRawMaterials(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "raw_materials/" + item.getId().getPath().replace("raw_","")));
        this.tag(tag).add(item.get());
    }

    private void tagDustItems(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "dusts/" + item.getId().getPath().replace("_dust","")));
        this.tag(tag).add(item.get());
    }

    private void tagGearItems(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "gears/" + item.getId().getPath().replace("_gear","")));
        this.tag(tag).add(item.get());
    }

    private void tagSheetItems(DeferredHolder<Item, ? extends Item> item) {
        TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("neoforge",
                "plates/" + item.getId().getPath().replace("_sheet","")));
        this.tag(tag).add(item.get());
    }
}
