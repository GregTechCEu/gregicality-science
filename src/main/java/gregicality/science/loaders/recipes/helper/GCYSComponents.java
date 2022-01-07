package gregicality.science.loaders.recipes.helper;

import com.google.common.collect.ImmutableMap;
import gregtech.api.GTValues;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.loaders.recipe.CraftingComponent;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static gregicality.science.api.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class GCYSComponents {

    public static CraftingComponent.Component GEAR;
    public static CraftingComponent.Component CABLE_DOUBLE;
    public static CraftingComponent.Component PLATE_DENSE;

    public static void register() {

        // TODO Wire

        CraftingComponent.CABLE_QUAD.appendIngredients(ImmutableMap.of(
                9, new UnificationEntry(cableGtQuadruple, AbyssalAlloy),
                10, new UnificationEntry(cableGtQuadruple, TitanSteel),
                11, new UnificationEntry(cableGtQuadruple, BlackTitanium),
                12, new UnificationEntry(cableGtQuadruple, Neutronium),
                13, new UnificationEntry(cableGtQuadruple, Neutronium)));
        CraftingComponent.CABLE_QUAD.appendIngredients(ImmutableMap.of(14, new UnificationEntry(wireGtQuadruple, MarkerMaterials.Tier.Super)));

        CraftingComponent.PIPE_NORMAL.appendIngredients(ImmutableMap.of(
                6, new UnificationEntry(pipeNormalFluid, Enderium),
                7, new UnificationEntry(pipeNormalFluid, Naquadah),
                8, new UnificationEntry(pipeNormalFluid, Ultimet),
                9, new UnificationEntry(pipeNormalFluid, Zeron100),
                10, new UnificationEntry(pipeNormalFluid, Lafium)));
        CraftingComponent.PIPE_NORMAL.appendIngredients(ImmutableMap.of(GTValues.FALLBACK, new UnificationEntry(pipeNormalFluid, Neutronium)));

        // TODO Pipe Large

        // Grinder, no changes needed yet

        // Diamond, no changes needed yet

        CraftingComponent.COIL_HEATING.appendIngredients(ImmutableMap.of(
                GTValues.FALLBACK, new UnificationEntry(wireGtDouble, EnrichedNaquadahAlloy)
        ));

        CraftingComponent.COIL_HEATING_DOUBLE.appendIngredients(ImmutableMap.of(
                GTValues.FALLBACK, new UnificationEntry(wireGtQuadruple, EnrichedNaquadahAlloy)
        ));

        CraftingComponent.COIL_ELECTRIC.appendIngredients(ImmutableMap.<Integer, Object>builder()
                .put(1, new UnificationEntry(wireGtDouble, Copper))
                .put(2, new UnificationEntry(wireGtQuadruple, Cupronickel))
                .put(3, new UnificationEntry(wireGtQuadruple, Electrum))
                .put(4, new UnificationEntry(wireGtQuadruple, AnnealedCopper))
                .put(5, new UnificationEntry(wireGtQuadruple, Graphene))
                .put(6, new UnificationEntry(wireGtQuadruple, NiobiumTitanium))
                .put(7, new UnificationEntry(wireGtQuadruple, VanadiumGallium))
                .put(8, new UnificationEntry(wireGtOctal, VanadiumGallium)) // set this to override CEu's entry
                .put(GTValues.FALLBACK, new UnificationEntry(wireGtOctal, VanadiumGallium))
                .build()
        );

        // Stick Magnetic, no changes needed yet

        // Stick Distillation, no changes needed yet

        // Stick Electromagnetic, no changes needed yet

        // TODO Pipe Reactor

        // TODO Hermetic Casings?

        // New Components
        GEAR = new CraftingComponent.Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(gear, Steel)},
                {1, new UnificationEntry(gear, Steel)},
                {2, new UnificationEntry(gear, Aluminium)},
                {3, new UnificationEntry(gear, StainlessSteel)},
                {4, new UnificationEntry(gear, Titanium)},
                {5, new UnificationEntry(gear, TungstenSteel)},
                {6, new UnificationEntry(gear, RhodiumPlatedPalladium)},
                {7, new UnificationEntry(gear, HSSS)},
                {8, new UnificationEntry(gear, Tritanium)},
                {9, new UnificationEntry(gear, Seaborgium)},
                {10, new UnificationEntry(gear, Bohrium)},
                {11, new UnificationEntry(gear, Quantum)},
                {GTValues.FALLBACK, new UnificationEntry(gear, Neutronium)},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        PLATE_DENSE = new CraftingComponent.Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(plateDense, Steel)},
                {1, new UnificationEntry(plateDense, Steel)},
                {2, new UnificationEntry(plateDense, Aluminium)},
                {3, new UnificationEntry(plateDense, StainlessSteel)},
                {4, new UnificationEntry(plateDense, Titanium)},
                {5, new UnificationEntry(plateDense, TungstenSteel)},
                {6, new UnificationEntry(plateDense, RhodiumPlatedPalladium)},
                {7, new UnificationEntry(plateDense, HSSS)},
                {8, new UnificationEntry(plateDense, Tritanium)},
                {9, new UnificationEntry(plateDense, Seaborgium)},
                {10, new UnificationEntry(plateDense, Bohrium)},
                {11, new UnificationEntry(plateDense, Quantum)},
                {GTValues.FALLBACK, new UnificationEntry(plateDense, Neutronium)},

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));

        CABLE_DOUBLE = new CraftingComponent.Component(Stream.of(new Object[][]{

                {0, new UnificationEntry(cableGtDouble, Lead)},
                {1, new UnificationEntry(cableGtDouble, Tin)},
                {2, new UnificationEntry(cableGtDouble, Copper)},
                {3, new UnificationEntry(cableGtDouble, Gold)},
                {4, new UnificationEntry(cableGtDouble, Aluminium)},
                {5, new UnificationEntry(cableGtDouble, Platinum)},
                {6, new UnificationEntry(cableGtDouble, NiobiumTitanium)},
                {7, new UnificationEntry(cableGtDouble, Naquadah)},
                {8, new UnificationEntry(cableGtDouble, NaquadahAlloy)},
                {9, new UnificationEntry(cableGtDouble, AbyssalAlloy)},
                {10, new UnificationEntry(cableGtDouble, TitanSteel)},
                {11, new UnificationEntry(cableGtDouble, BlackTitanium)},
                {12, new UnificationEntry(cableGtDouble, Neutronium)},
                {13, new UnificationEntry(cableGtDouble, Neutronium)},
                {14, new UnificationEntry(cableGtDouble, MarkerMaterials.Tier.Super)}

        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> data[1])));
    }
}
