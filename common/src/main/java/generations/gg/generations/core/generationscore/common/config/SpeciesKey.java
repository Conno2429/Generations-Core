package generations.gg.generations.core.generationscore.common.config;

import com.cobblemon.mod.common.api.pokemon.PokemonProperties;
import com.cobblemon.mod.common.pokemon.Pokemon;
import com.cobblemon.mod.common.pokemon.Species;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public record SpeciesKey(ResourceLocation species, Set<String> aspects) {
    public SpeciesKey(String species, Set<String> aspects) {
        this(new ResourceLocation(species), aspects);
    }

    public SpeciesKey(String species) {
        this(species, Set.of());
    }


    public PokemonProperties createProperties() {
        var properties = new PokemonProperties();
        properties.setSpecies(species.getPath());
        properties.setAspects(aspects);
        return properties;
    }


    public PokemonProperties createProperties(int level) {
        var properties = createProperties();
        properties.setLevel(level);
        return properties;
    }

    public Pokemon createPokemon(int level) {
        var properties = createProperties();
        properties.setLevel(level);
         var pokemon = properties.create();
        pokemon.setAspects(aspects());
        return pokemon;
    }


    @Override
    public String toString() {
        String setString = !aspects.isEmpty() ? aspects.stream().collect(Collectors.joining(",", "[", "]")) : "";
        return species.toString() + setString;
    }

    public SpeciesKey(ResourceLocation species) {
        this(species, Collections.emptySet());
    }

    public static SpeciesKey fromPokemon(Pokemon pokemon) {
        Set<String> aspects;

        if (!pokemon.getAspects().isEmpty()) {
            var trackedAspects = GenerationsCore.CONFIG.caught.trackedAspects;
            aspects = pokemon.getAspects().stream().filter(trackedAspects::contains).collect(Collectors.toSet());
        } else {
            aspects = Set.of();
        }

        return new SpeciesKey(pokemon.getSpecies().resourceIdentifier, aspects.isEmpty() ? Set.of() : aspects);
    }

    public static SpeciesKey fromString(String input) {
        String[] parts = input.split("\\[|\\]");

        ResourceLocation species = new ResourceLocation(parts[0]);

        Set<String> aspects = new HashSet<>();
        if (parts.length == 2) {

            String values = parts[1];


            // Check if the values are not null and not empty
            if (values != null && !values.isEmpty()) {
                String[] valueArray = values.split(",");

                aspects.addAll(Arrays.asList(valueArray));
            }
        }
        return new SpeciesKey(species, aspects);
    }

    public static SpeciesKey fromSpecies(@NotNull Species species) {
        return new SpeciesKey(species.getResourceIdentifier());
    }
}
