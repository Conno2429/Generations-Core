package generations.gg.generations.core.generationscore.forge.datagen;

import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.forge.datagen.generators.blocks.BlockDatagen;
import generations.gg.generations.core.generationscore.forge.datagen.generators.blocks.GenerationsBlockStateProvider;
import generations.gg.generations.core.generationscore.forge.datagen.generators.blocks.UltraBlockModelDataGen;
import generations.gg.generations.core.generationscore.forge.datagen.generators.items.ItemDatagen;
import generations.gg.generations.core.generationscore.forge.datagen.generators.lang.GeneralLang;
import generations.gg.generations.core.generationscore.forge.datagen.generators.loot.LootTableDatagen;
import generations.gg.generations.core.generationscore.forge.datagen.generators.recipe.*;
import generations.gg.generations.core.generationscore.forge.datagen.generators.tags.TagsDatagen;
import generations.gg.generations.core.generationscore.forge.datagen.generators.worldgen.WorldGenProvider;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsBlockSet;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsUltraBlockSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CompletableFuture;

/**
 * This class is used to register the data generators for the mod.
 * @see GatherDataEvent
 * @author Joseph T. McQuigg (JT122406)
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = GenerationsCore.MOD_ID)
class DataGeneratorsRegister {

    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        GenerationsBlockSet.generateAllBlockFamilies();
        GenerationsUltraBlockSet.updateUltraBlockFamilies();
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        TagsDatagen.init(generator, output, lookupProvider, existingFileHelper);
        generator.addProvider(true, new GeneralLang(output, "en_us"));
        generator.addProvider(true, new GenerationsBlockStateProvider(output, existingFileHelper, BlockDatagen::new, UltraBlockModelDataGen::new));
        generator.addProvider(true, new ItemDatagen(output, existingFileHelper));

        generator.addProvider(true, new GenerationsRecipeProvider(output,
                ItemRecipeDatagen::new,
                BuildingBlockRecipeDatagen::new,
                GenerationsArmorToolRecipeDatagen::new,
                MachineDecorationsRecipeDatagen::new,
                WoodRecipes::new,
                //PokeBallRecipeDatagen::new,
                FurnaceRecipeProvider::new,
                RksRecipeProvider::new));
        generator.addProvider(true, new LootTableDatagen(output));

//        generator.addProvider(true, new GenerationsPokemonModelsProvider(output));

//        generator.addProvider(true, new DialogueDataGen(event.getGenerator().getPackOutput()));

        generator.addProvider(true, new WorldGenProvider(output, lookupProvider));
    }
}