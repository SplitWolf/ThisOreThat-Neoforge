package dev.splitwolf.thisorethat.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static dev.splitwolf.thisorethat.ThisOreThat.MODID;

public class RawOreBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredBlock<Block> RAW_ALUMINUM_BLOCK = addRawOreBlock("raw_aluminum_block");
    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = addRawOreBlock("raw_lead_block");
    public static final DeferredBlock<Block> RAW_NICKEL_BLOCK = addRawOreBlock("raw_nickel_block");
    public static final DeferredBlock<Block> RAW_PLATINUM_BLOCK = addRawOreBlock("raw_platinum_block");
    public static final DeferredBlock<Block> RAW_SALT_BLOCK = addRawOreBlock("raw_salt_block");
    public static final DeferredBlock<Block> RAW_SILVER_BLOCK = addRawOreBlock("raw_silver_block");
    public static final DeferredBlock<Block> RAW_SULFUR_BLOCK = addRawOreBlock("raw_sulfur_block");
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = addRawOreBlock("raw_tin_block");
    public static final DeferredBlock<Block> RAW_URANIUM_BLOCK = addRawOreBlock("raw_uranium_block");
    public static final DeferredBlock<Block> RAW_ZINC_BLOCK = addRawOreBlock("raw_zinc_block");


    private static DeferredBlock<Block> addRawOreBlock(String name) {
        DeferredBlock<Block> addedBlock = BLOCKS.register(name, registryName ->
                new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));
        DeferredItem<BlockItem> blockItem = BLOCK_ITEMS.register(name, registryName -> new BlockItem(addedBlock.get(), new Item.Properties()));
        return  addedBlock;
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ITEMS.register(modEventBus);
    }
}
