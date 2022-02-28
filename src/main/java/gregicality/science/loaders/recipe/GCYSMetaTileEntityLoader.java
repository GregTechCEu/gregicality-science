package gregicality.science.loaders.recipe;

import gregicality.multiblocks.api.unification.GCYMMaterials;
import gregicality.science.common.metatileentities.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.recipes.ModHandler;
import gregtech.api.unification.material.MarkerMaterials;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.api.unification.stack.UnificationEntry;
import gregtech.common.metatileentities.MetaTileEntities;
import gregtech.loaders.recipe.CraftingComponent;
import gregtech.loaders.recipe.MetaTileEntityLoader;

public class GCYSMetaTileEntityLoader {

    public static void init() {
        // Singleblock Machines
        MetaTileEntityLoader.registerMachineRecipe(GCYSMetaTileEntities.DRYER, "WCW", "SHS", "WCW", 'W', CraftingComponent.CABLE, 'C', CraftingComponent.CIRCUIT, 'S', CraftingComponent.SPRING, 'H', CraftingComponent.HULL);

        // Multiblock Machines
        ModHandler.addShapedRecipe("crystallization_crucible", GCYSMetaTileEntities.CRYSTALLIZATION_CRUCIBLE.getStackForm(),
                "CMC", "LHL", "PCP",
                'C', new UnificationEntry(OrePrefix.circuit, MarkerMaterials.Tier.Elite),
                'M', new UnificationEntry(OrePrefix.plateDouble, GCYMMaterials.MolybdenumDisilicide),
                'L', new UnificationEntry(OrePrefix.pipeNormalFluid, Materials.Titanium),
                'H', MetaTileEntities.HULL[GTValues.EV].getStackForm(),
                'P', new UnificationEntry(OrePrefix.plate, Materials.Titanium)
        );
    }
}
