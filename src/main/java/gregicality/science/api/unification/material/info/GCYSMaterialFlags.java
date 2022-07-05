package gregicality.science.api.unification.material.info;

import gregtech.api.unification.material.info.MaterialFlag;
import gregtech.api.unification.material.info.MaterialFlags;
import gregtech.api.unification.material.properties.PropertyKey;

public class GCYSMaterialFlags {

    public static final MaterialFlag DISABLE_CRYSTALLIZATION = new MaterialFlag.Builder("no_crystallization")
            .requireFlags(MaterialFlags.CRYSTALLIZABLE)
            .requireProps(PropertyKey.GEM)
            .build();

    public static final MaterialFlag GENERATE_BOULE = new MaterialFlag.Builder("generate_boule")
            .requireProps(PropertyKey.GEM)
            .build();
}
