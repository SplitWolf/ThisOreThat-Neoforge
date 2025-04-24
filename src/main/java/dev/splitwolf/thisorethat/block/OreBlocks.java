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

public class OreBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MODID);

    public static final DeferredBlock<Block> ALUMINIUM_ORE = addOre("aluminum_ore");
    public static final DeferredBlock<Block> DEEPSLATE_ALUMINIUM_ORE = addOre("deepslate_aluminum_ore");

    public static final DeferredBlock<Block> LEAD_ORE = addOre("lead_ore");
    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = addOre("deepslate_lead_ore");


    public static final DeferredBlock<Block> NICKEL_ORE = addOre("nickel_ore");
    public static final DeferredBlock<Block> DEEPSLATE_NICKEL_ORE = addOre("deepslate_nickel_ore");

    public static final DeferredBlock<Block> PLATINUM_ORE = addOre("platinum_ore");
    public static final DeferredBlock<Block> DEEPSLATE_PLATINUM_ORE = addOre("deepslate_platinum_ore");

    public static final DeferredBlock<Block> SALT_ORE = addOre("salt_ore");
    public static final DeferredBlock<Block> DEEPSLATE_SALT_ORE = addOre("deepslate_salt_ore");

    public static final DeferredBlock<Block> SILVER_ORE = addOre("silver_ore");
    public static final DeferredBlock<Block> DEEPSLATE_SILVER_ORE = addOre("deepslate_silver_ore");

    public static final DeferredBlock<Block> SULFUR_ORE = addOre("sulfur_ore");
    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = addOre("deepslate_sulfur_ore");

    public static final DeferredBlock<Block> TIN_ORE = addOre("tin_ore");
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = addOre("deepslate_tin_ore");

    public static final DeferredBlock<Block> URANIUM_ORE = addOre("uranium_ore");
    public static final DeferredBlock<Block> DEEPSLATE_URANIUM_ORE = addOre("deepslate_uranium_ore");

    public static final DeferredBlock<Block> ZINC_ORE = addOre("zinc_ore");
    public static final DeferredBlock<Block> DEEPSLATE_ZINC_ORE = addOre("deepslate_zinc_ore");

    private static DeferredBlock<Block> addOre(String name) {
        DeferredBlock<Block> addedBlock;
        if(name.contains("deepslate")) {
            addedBlock = BLOCKS.register(name, registryName ->
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)));
        } else {
           addedBlock = BLOCKS.register(name, registryName ->
                    new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)));
        }
        DeferredItem<BlockItem> blockItem = BLOCK_ITEMS.register(name, registryName -> new BlockItem(addedBlock.get(), new Item.Properties()));
        return addedBlock;
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ITEMS.register(modEventBus);
    }

}
