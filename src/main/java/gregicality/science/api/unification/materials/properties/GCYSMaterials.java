package gregicality.science.api.unification.materials.properties;

import gregicality.science.api.unification.materials.*;

public class GCYSMaterials {

    public static void init() {

        GCYSElementMaterials.init();

        GCYSFirstDegreeMaterials.init();

        GCYSSecondDegreeMaterials.init();

        GCYSThirdDegreeMaterials.init();

        GCYSHighDegreeMaterials.init();

        GCYSOrganicChemistryMaterials.init();

        GCYSUnknownCompositionMaterials.init();

        GCYSMaterialFlagAddition.init();
    }
}
