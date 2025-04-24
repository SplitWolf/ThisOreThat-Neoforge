package dev.splitwolf.thisorethat.datagen;

import com.mojang.logging.LogUtils;
import dev.splitwolf.thisorethat.ThisOreThat;
import dev.splitwolf.thisorethat.block.MetalBlocks;
import dev.splitwolf.thisorethat.block.OreBlocks;
import dev.splitwolf.thisorethat.block.RawOreBlocks;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jline.utils.Log;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ThisOreThat.MODID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        MetalBlocks.BLOCKS.getEntries().forEach(this::metalBlockState);
        OreBlocks.BLOCKS.getEntries().forEach(this::oreBlockState);
        RawOreBlocks.BLOCKS.getEntries().forEach(this::rawOreBlockState);
    }

    private void metalBlockState(DeferredHolder<Block, ? extends Block> block) {
        blockWithItemAndTexture(block, MetalBlockTexture(block.get()));
    }
    private void oreBlockState(DeferredHolder<Block, ? extends Block>block) {
        blockWithItemAndTexture(block, OreTexture(block.get()));
    }

    private void rawOreBlockState(DeferredHolder<Block, ? extends Block> block) {
        blockWithItemAndTexture(block, RawOreBlockTexture(block.get()));
    }


    private ResourceLocation MetalBlockTexture(Block block) {
        ResourceLocation name = key(block);
        return modLoc(ModelProvider.BLOCK_FOLDER + "/metal/" + name.getPath());
    }

    private ResourceLocation OreTexture(Block block) {
        ResourceLocation name = key(block);
        return modLoc(ModelProvider.BLOCK_FOLDER + "/ore/" + name.getPath());
    }

    private ResourceLocation RawOreBlockTexture(Block block) {
        ResourceLocation name = key(block);
        return modLoc(ModelProvider.BLOCK_FOLDER + "/raw_ore_block/" + name.getPath());
    }

    private void blockWithItemAndTexture(DeferredHolder<Block, ? extends Block> deferredBlock, ResourceLocation texture) {
        simpleBlockWithItem(deferredBlock.get(), this.cubeAll(deferredBlock.get(), texture));
    }

    public ModelFile cubeAll(Block block, ResourceLocation texture) {
        return models().cubeAll(name(block), texture);
    }

    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

}
