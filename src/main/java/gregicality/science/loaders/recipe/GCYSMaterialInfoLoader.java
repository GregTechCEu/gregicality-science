package gregicality.science.loaders.recipe;

import gregicality.science.api.unification.materials.GCYSMaterials;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.block.blocks.BlockCrucible;
import gregicality.science.common.block.blocks.BlockTransparentCasing;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.stack.ItemMaterialInfo;
import gregtech.api.unification.stack.MaterialStack;

import static gregtech.api.GTValues.M;

public class GCYSMaterialInfoLoader {

    public static void init() {
        OreDictUnifier.registerOre(GCYSMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.QUARTZ_CRUCIBLE), new ItemMaterialInfo(new MaterialStack(Materials.Quartzite, M * 7))); // single plate
        OreDictUnifier.registerOre(GCYSMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.TUNGSTEN_CRUCIBLE), new ItemMaterialInfo(new MaterialStack(Materials.Tungsten, M * 7 * 9))); // dense plate
        OreDictUnifier.registerOre(GCYSMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.GRAPHITE_CRUCIBLE), new ItemMaterialInfo(new MaterialStack(Materials.Graphene, M * 7 * 9))); // dense plate
        OreDictUnifier.registerOre(GCYSMetaBlocks.CRUCIBLE.getItemVariant(BlockCrucible.CrucibleType.BORON_NITRIDE_CRUCIBLE), new ItemMaterialInfo(new MaterialStack(GCYSMaterials.HexagonalBoronNitride, M * 7))); // single plate

        OreDictUnifier.registerOre(GCYSMetaBlocks.TRANSPARENT_CASING.getItemVariant(BlockTransparentCasing.CasingType.PMMA), new ItemMaterialInfo(new MaterialStack(GCYSMaterials.PMMA, M * 4))); // single plate
 //TODO remove this if replacing Nt stays
//        OreDictUnifier.registerOre(MetaTileEntities.HULL[9].getStackForm(), new ItemMaterialInfo(
//                new MaterialStack(Orichalcum, M * 8), // plate
//                new MaterialStack(Europium, M), // single cable
//                new MaterialStack(Rubber, M * 2))); // plate
    }
}
