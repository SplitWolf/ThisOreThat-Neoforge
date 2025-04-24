package dev.splitwolf.thisorethat.datagen;

import dev.splitwolf.thisorethat.block.MetalBlocks;
import dev.splitwolf.thisorethat.block.RawOreBlocks;
import dev.splitwolf.thisorethat.item.IngotItems;
import dev.splitwolf.thisorethat.item.NuggetItems;
import dev.splitwolf.thisorethat.item.RawOreItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(pOutput, lookupProvider);
    }

    //TODO: Salt and sulfur block recipes

    @Override
    protected void buildRecipes(@NotNull RecipeOutput  pWriter) {
        registerMetalBlockRecipes(pWriter);
//        registerSmeltingRecipes(pWriter);
        registerNuggetRecipes(pWriter);
        registerRawOreBlockRecipes(pWriter);
    }
    private void registerMetalBlockRecipes(RecipeOutput pWriter) {
        MetalBlocks.BLOCKS.getEntries().forEach(block -> {
            String materialType = block.getId().getPath().replace("_block","");
            Optional<DeferredHolder<Item, ? extends Item>> optUnpackedItem = IngotItems.ITEMS.getEntries().stream().filter(item -> item.getId().getPath().startsWith(materialType)).findFirst();
            optUnpackedItem.ifPresent(unpackedItem ->
                    ninePackingUnpackingRecipes(RecipeCategory.BUILDING_BLOCKS, block.get(), "from/ingot/", RecipeCategory.BUILDING_BLOCKS, unpackedItem.get(), "from/block/", pWriter));
        });
    }

    private void registerNuggetRecipes(RecipeOutput pWriter) {
        NuggetItems.ITEMS.getEntries().forEach(nugget -> {
            String materialType = nugget.getId().getPath().replace("_nugget","");
            Optional<DeferredHolder<Item, ? extends Item>> optPackedItem = IngotItems.ITEMS.getEntries().stream().filter(item -> item.getId().getPath().startsWith(materialType)).findFirst();
            optPackedItem.ifPresent(packedItem ->
                    ninePackingUnpackingRecipes(RecipeCategory.BUILDING_BLOCKS, packedItem.get(), "from/nugget/", RecipeCategory.BUILDING_BLOCKS,nugget.get(),"from/ingot/", pWriter));
        });
    }

    private void registerRawOreBlockRecipes(RecipeOutput pWriter) {
        RawOreItems.ITEMS.getEntries().forEach(rawOre -> {
            String materialType = rawOre.getId().getPath().replace("raw_","");
            Optional<DeferredHolder<Block, ? extends Block>> optPackedItem = RawOreBlocks.BLOCKS.getEntries().stream().filter(item -> item.getId().getPath().replace("raw_","").startsWith(materialType)).findFirst();
            optPackedItem.ifPresent(packedItem ->
                    ninePackingUnpackingRecipes(RecipeCategory.BUILDING_BLOCKS, packedItem.get(), "from/raw_ore/", RecipeCategory.BUILDING_BLOCKS,rawOre.get(),"from/raw_ore_block/", pWriter));
        });
    }

//    private void registerSmeltingRecipes(RecipeOutput pWriter) {
//        //TODO: blasting
//        OreBlocks.BLOCK_ITEMS.getEntries().forEach(item -> {
//            String materialType = item.getId().getPath().replace("_ore","").replace("deepslate_","");
//            if(materialType.equals("salt") || materialType.equals("sulfur"))
//                return;
//            Optional<RegistryObject<Item>> optIngotItem = IngotItems.ITEMS.getEntries().stream().filter(ingItem -> ingItem.getId().getPath().startsWith(materialType+"_")).findFirst();
//            //TODO: Update Time and Exp
//            optIngotItem.ifPresent(ingotItem -> oreCook(pWriter, RecipeSerializer.SMELTING_RECIPE, List.of(item.get()), RecipeCategory.BUILDING_BLOCKS, ingotItem.get(), 0.35f, 200, "smelting"));
//        });
//
//        RawOreItems.ITEMS.getEntries().forEach(item -> {
//            String materialType = item.getId().getPath().replace("raw_","");
//            if(materialType.equals("salt") || materialType.equals("sulfur"))
//                return;
//            Optional<RegistryObject<Item>> optIngotItem = IngotItems.ITEMS.getEntries().stream().filter(ingItem -> ingItem.getId().getPath().startsWith(materialType)).findFirst();
//            optIngotItem.ifPresent(ingotItem -> oreCook(pWriter, RecipeSerializer.SMELTING_RECIPE, List.of(item.get()), RecipeCategory.BUILDING_BLOCKS, ingotItem.get(), 0.35f, 200, "smelting"));
//        });
//
//    }

//    private static class ReturnRecipe implements Consumer<FinishedRecipe> {
//        FinishedRecipe toReturn;
//
//        @Override
//        public void accept(FinishedRecipe finishedRecipe) {
//            toReturn = finishedRecipe;
//        }
//
//        public FinishedRecipe getLast() {
//            return toReturn;
//        }
//    }

//    @SuppressWarnings("SameParameterValue")
//    private void oreCook(RecipeOutput pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pRecipeName) {
//        ReturnRecipe recipeReturner = new ReturnRecipe();
//        for(ItemLike itemlike : pIngredients) {
//            SimpleCookingRecipeBuilder.generic(
//                            Ingredient.of(itemlike),
//                            pCategory,
//                            pResult,
//                            pExperience,
//                            pCookingTime,
//                            pCookingSerializer
//                    )
//                    .unlockedBy(getHasName(itemlike), has(itemlike))
//                    .save(recipeReturner, new ResourceLocation(ThisOreThat.MOD_ID, pRecipeName + "/" + getItemName(pResult) + "_from_" + getItemName(itemlike)));
//
//            ConditionalRecipe.builder().addCondition(SmeltingEnabledCondition.INSTANCE)
//                    .addRecipe(recipeReturner.getLast())
//                    .build(pFinishedRecipeConsumer,recipeReturner.getLast().getId());
//
//        }
//    }

    @SuppressWarnings("SameParameterValue")
    private void ninePackingUnpackingRecipes(RecipeCategory packedCategory, ItemLike packedItem, String packedPath, RecipeCategory unpackedCategory, ItemLike unpackedItem, String unpackedPath, RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(packedCategory, packedItem)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', unpackedItem)
                .unlockedBy(getHasName(unpackedItem), has(unpackedItem))
                .save(consumer, ResourceLocation.parse(packedPath + getItemName(packedItem)));
        ShapelessRecipeBuilder.shapeless(unpackedCategory, unpackedItem, 9)
                .requires(packedItem)
                .unlockedBy(getHasName(packedItem),has(packedItem))
                .save(consumer,ResourceLocation.parse(unpackedPath + getItemName(unpackedItem)));
    }
}
