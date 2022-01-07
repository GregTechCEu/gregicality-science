package gregicality.science;

import gregicality.science.api.GCYSMaterials;
import gregicality.science.common.block.GCYSMetaBlocks;
import gregicality.science.common.machine.GCYSMetaTileEntities;
import gregtech.api.GTValues;
import gregtech.api.unification.material.Materials;
import gregtech.api.util.GTLog;
import gregtech.common.MetaFluids;
import gregtech.common.blocks.MetaBlocks;
import gregtech.common.metatileentities.MetaTileEntities;
import net.minecraft.init.Bootstrap;
import org.apache.logging.log4j.LogManager;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

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
        GCYSMaterials.register();
        MetaFluids.init();

        // Bootstrap the GTCE MetaTileEntity System
        MetaBlocks.init();
        GCYSMetaBlocks.init();
        MetaTileEntities.init();
        GCYSMetaTileEntities.init();
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
                GCYSMaterials.Pikyonium
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
                GCYSMetaTileEntities.STELLAR_FORGE
        );
    }
}
