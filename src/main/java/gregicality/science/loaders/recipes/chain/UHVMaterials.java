package gregicality.science.loaders.recipes.chain;

import static gregicality.machines.api.recipes.GCYMRecipeMaps.ALLOY_BLAST_RECIPES;
import static gregicality.science.api.GCYSMaterials.*;
import static gregicality.science.common.item.GCYSMetaItems.*;
import static gregicality.science.loaders.recipes.GCYSRecipeMaps.PLASMA_CONDENSER_RECIPES;
import static gregtech.api.recipes.RecipeMaps.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.ore.OrePrefix.*;

public class UHVMaterials {
    public static void init() { //todo

//        ASSEMBLY_LINE_RECIPES.recipeBuilder()
//                .input(dust, Naquadria)
//                .inputs(GELLED_TOLUENE.getStackForm(2))
//                .input(plate, Uranium238)
//                .input(bolt, Osmium, 1)
//                .input(bolt, Titanium, 4)
//                .input(dust, HexanitroHexaaxaisowurtzitane)
//                .fluidInputs(GlycerylTrinitrate.getFluid(1000))
//                .outputs(GCYSMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.NAQUADRIA_CHARGE))
//                .EUt(1966080)
//                .duration(100)
//                .buildAndRegister();

//        STELLAR_FORGE_RECIPES.recipeBuilder()
//                .input(ingot, Rhenium)
//                .inputs(GCYSMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.NAQUADRIA_CHARGE))
//                .fluidOutputs(ElectronDegenerateRhenium.getPlasma(144))
//                .EUt(1966080)
//                .duration(20)
//                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(ElectronDegenerateRhenium.getPlasma(144))
                .outputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(30720)
                .duration(20)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(RHENIUM_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(16000))
                .fluidOutputs(Helium.getFluid(16000))
                .notConsumable(PLATE_FIELD_SHAPE.getStackForm())
                .outputs(DEGENERATE_RHENIUM_PLATE.getStackForm())
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(122880)
                .duration(250)
                .buildAndRegister();

        VACUUM_RECIPES.recipeBuilder()
                .fluidInputs(Helium.getFluid(5000))
                .fluidOutputs(LiquidHelium.getFluid(5000))
                .EUt(7680)
                .duration(20)
                .buildAndRegister();

        ASSEMBLY_LINE_RECIPES.recipeBuilder()
                .input(stickLong, NeodymiumMagnetic, 2)
                .input(wireGtSingle, EnrichedNaquadahTriniumEuropiumDuranide, 16)
                .input(pipeLargeFluid, Ultimet, 4)
                .input(plate, NaquadahAlloy, 8)
                .fluidInputs(Titanium.getFluid(2592))
                .fluidInputs(NaquadahEnriched.getFluid(1584))
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(983040)
                .duration(50)
                .buildAndRegister();

//        ASSEMBLY_LINE_RECIPES.recipeBuilder()
//                .input(plate, Mendelevium)
//                .inputs(GELLED_TOLUENE.getStackForm(4))
//                .input(stickLong, NaquadriaticTaranium)
//                .input(dust, Taranium)
//                .inputs(DEGENERATE_RHENIUM_PLATE.getStackForm())
//                .fluidInputs(Tritanium.getFluid(144))
//                .fluidInputs(GlycerylTrinitrate.getFluid(2500))
//                .outputs(GCYSMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.TARANIUM_CHARGE))
//                .EUt(125000000)
//                .duration(5)
//                .buildAndRegister();

        ALLOY_BLAST_RECIPES.recipeBuilder()
                .input(dust, Seaborgium)
                .input(dust, Bohrium)
                .input(dust, Rutherfordium)
                .input(dust, Dubnium)
                .fluidOutputs(SuperheavyMix.getFluid(4000))
                .EUt(100000000)
                .duration(40)
                .blastFurnaceTemp(12800)
                .buildAndRegister();

//        FLUID_SOLIDFICATION_RECIPES.recipeBuilder()
//                .notConsumable(MetaItems.SHAPE_MOLD_BLOCK)
//                .fluidInputs(SuperheavyMix.getFluid(1000))
//                .outputs(GCYSMetaBlocks.SIMPLE_BLOCK.getItemVariant(GASimpleBlock.BlockType.SUPERHEAVY_BLOCK))
//                .EUt(100000000)
//                .duration(40)
//                .buildAndRegister();
//
//        STELLAR_FORGE_RECIPES.recipeBuilder()
//                .inputs(GCYSMetaBlocks.SIMPLE_BLOCK.getItemVariant(GASimpleBlock.BlockType.SUPERHEAVY_BLOCK))
//                .inputs(GCYSMetaBlocks.EXPLOSIVE.getItemVariant(GAExplosive.ExplosiveType.TARANIUM_CHARGE))
//                .fluidOutputs(NeutronPlasma.getFluid(1000))
//                .EUt(100000000)
//                .duration(10)
//                .buildAndRegister();

        CANNER_RECIPES.recipeBuilder()
                .inputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(NeutronPlasma.getFluid(1000))
                .outputs(NEUTRON_PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(25000000)
                .duration(80)
                .buildAndRegister();

        PLASMA_CONDENSER_RECIPES.recipeBuilder()
                .inputs(NEUTRON_PLASMA_CONTAINMENT_CELL.getStackForm())
                .fluidInputs(LiquidHelium.getFluid(32000))
                .fluidOutputs(Helium.getFluid(32000))
                .notConsumable(INGOT_FIELD_SHAPE.getStackForm())
                .output(ingot, Neutronium)
                .outputs(PLASMA_CONTAINMENT_CELL.getStackForm())
                .EUt(10000000)
                .duration(500)
                .buildAndRegister();

//        CENTRIFUGE_RECIPES.recipeBuilder()
//                .input(dust, Stone)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .chancedOutput(OreDictUnifier.get(dustTiny, Taranium), 10, 10)
//                .EUt(491520)
//                .duration(2)
//                .buildAndRegister();
    }
}
