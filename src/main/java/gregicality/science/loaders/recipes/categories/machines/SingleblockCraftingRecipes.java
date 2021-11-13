package gregicality.science.loaders.recipes.categories.machines;

import gregicality.science.common.GAMetaTileEntities;

import static gregicality.science.loaders.recipes.helper.GACraftingComponents.*;
import static gregtech.loaders.recipe.CraftingComponent.*;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;

public class SingleblockCraftingRecipes {

    public static void init() {

        registerMachineRecipe(GAMetaTileEntities.DEHYDRATOR,
                "WCW", "MHM", "GAG",
                'C', CIRCUIT,
                'M', CABLE_QUAD,
                'H', HULL,
                'G', GEAR,
                'A', ROBOT_ARM,
                'W', COIL_HEATING_DOUBLE);

        registerMachineRecipe(GAMetaTileEntities.DECAY_CHAMBER,
                "RCR", "FMF", "QCQ",
                'M', HULL,
                'Q', CABLE_DOUBLE,
                'C', CIRCUIT,
                'F', FIELD_GENERATOR,
                'R', STICK_RADIOACTIVE);

        registerMachineRecipe(GAMetaTileEntities.GREEN_HOUSE,
                "GGG", "AMA", "CQC",
                'M', HULL,
                'Q', CABLE,
                'C', CIRCUIT,
                'G', GLASS,
                'A', ROBOT_ARM);

        registerMachineRecipe(GAMetaTileEntities.NAQUADAH_REACTOR,
                "RCR", "FMF", "QCQ",
                'M', HULL,
                'Q', CABLE_QUAD,
                'C', BETTER_CIRCUIT,
                'F', FIELD_GENERATOR,
                'R', STICK_RADIOACTIVE);

        registerMachineRecipe(GAMetaTileEntities.ROCKET_GENERATOR,
                "PCP", "MHM", "GAG",
                'C', CIRCUIT,
                'M', MOTOR,
                'H', HULL,
                'G', PLATE_DENSE,
                'A', CABLE_DOUBLE,
                'P', PISTON);
    }
}
