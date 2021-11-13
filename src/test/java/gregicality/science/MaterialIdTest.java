package gregicality.science;

import gregicality.science.api.GAMaterials;
import gregicality.science.api.fluid.GAMetaFluids;
import gregicality.science.common.item.GAMetaBlocks;
import gregicality.science.common.GAMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.unification.material.MaterialRegistry;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTLog;
import gregtech.common.MetaFluids;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.init.Bootstrap;
import org.apache.logging.log4j.LogManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaterialIdTest {

    /**
     * Initialize registries
     */
    @BeforeClass
    public static void bootStrap() {
        Bootstrap.register();

        // Bootstrap the GTCE Material System
        GTLog.init(LogManager.getLogger(GTValues.MODID)); // yes this was necessary
        Materials.register();
        GAEnums.onConstruction();
        GAMaterials gaMaterials = new GAMaterials();
        gaMaterials.onMaterialsInit();
        MaterialRegistry.freeze();
        MetaFluids.init();
        GAMetaFluids.init();

        // Bootstrap the GTCE MetaTileEntity System
        MetaBlocks.init();
        GAMetaBlocks.init();
        MetaTileEntities.init();
        GAMetaTileEntities.init();
    }

    /**
     * Basic Nonnull test to try.
     *
     * The real test is in the bootStrap, where if there are conflicting material IDs registered,
     * it will throw an {@link IllegalArgumentException} and fail the test.
      */
    @Test
    public void areMaterialsGenerated() {
        assertNotNull(
                "OreDictUnifier failed to gather a GTCE Material ItemStack",
                Materials.Carbon
        );
        assertNotNull(
                "OreDictUnifier failed to gather a Gregicality Material ItemStack",
                GAMaterials.Pikyonium
        );
    }

    /**
     * Basic Nonnull test to try.
     *
     * The real test is in bootStrap, where if there are conflicting MTE ID's,
     * it will throw an {@link IllegalArgumentException} and fail the test.
     */
    @Test
    public void areMTEsGenerated() {
        assertNotNull(
                "GTCE MetaTileEntity is still null!",
                MetaTileEntities.LARGE_COMBUSTION_ENGINE
        );
        assertNotNull(
                "Gregicality: Science MetaTileEntity is still null!",
                GAMetaTileEntities.STELLAR_FORGE
        );
    }
}
