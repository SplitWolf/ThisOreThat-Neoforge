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

public class MetalBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredBlock<Block> ALUMINIUM_BLOCK = addMetalBlock("aluminum_block");
    public static final DeferredBlock<Block> BRASS_BLOCK = addMetalBlock("brass_block");
    public static final DeferredBlock<Block> BRONZE_BLOCK = addMetalBlock("bronze_block");
    public static final DeferredBlock<Block> ELECTRUM_BLOCK = addMetalBlock("electrum_block");
    public static final DeferredBlock<Block> INVAR_BLOCK = addMetalBlock("invar_block");
    public static final DeferredBlock<Block> LEAD_BLOCK = addMetalBlock("lead_block");
    public static final DeferredBlock<Block> NICKEL_BLOCK = addMetalBlock("nickel_block");
    public static final DeferredBlock<Block> PLATINUM_BLOCK = addMetalBlock("platinum_block");
    public static final DeferredBlock<Block> SALT_BLOCK = addMetalBlock("salt_block");
    public static final DeferredBlock<Block> SILICON_BLOCK = addMetalBlock("silicon_block");
    public static final DeferredBlock<Block> SILVER_BLOCK = addMetalBlock("silver_block");
    public static final DeferredBlock<Block> STEEL_BLOCK = addMetalBlock("steel_block");
    public static final DeferredBlock<Block> SULFUR_BLOCK = addMetalBlock("sulfur_block");
    public static final DeferredBlock<Block> TIN_BLOCK = addMetalBlock("tin_block");
    public static final DeferredBlock<Block> URANIUM_BLOCK = addMetalBlock("uranium_block");
    public static final DeferredBlock<Block> ZINC_BLOCK = addMetalBlock("zinc_block");

    private static DeferredBlock<Block> addMetalBlock(String name) {
       DeferredBlock<Block> addedBlock = BLOCKS.register(name, registryName ->
               new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
        DeferredItem<BlockItem> blockItem = BLOCK_ITEMS.register(name, registryName -> new BlockItem(addedBlock.get(), new Item.Properties()));
       return  addedBlock;
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ITEMS.register(modEventBus);
    }

}
