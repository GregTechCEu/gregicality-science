package gregicality.science.api.unification.materials;

import gregtech.api.unification.material.Material;

public class GCYSMaterials {

    // Element Materials


    // First Degree Materials
    public static Material LanthanumOxide;
    public static Material PraseodymiumOxide;
    public static Material NeodymiumOxide;
    public static Material CeriumOxide;
    public static Material ScandiumOxide;
    public static Material EuropiumOxide;
    public static Material GadoliniumOxide;
    public static Material SamariumOxide;
    public static Material YttriumOxide;
    public static Material TerbiumOxide;
    public static Material DysprosiumOxide;
    public static Material HolmiumOxide;
    public static Material ErbiumOxide;
    public static Material ThuliumOxide;
    public static Material YtterbiumOxide;
    public static Material LutetiumOxide;
    public static Material PlatinumMetallic;
    public static Material PalladiumMetallic;
    public static Material AmmoniumHexachloroplatinate;
    public static Material ChloroplatinicAcid;


    // Second Degree Materials
    public static Material LaPrNdCeOxidesSolution;
    public static Material ScEuGdSmOxidesSolution;
    public static Material YTbDyHoOxidesSolution;
    public static Material ErThYtLuOxidesSolution;
    public static Material PlatinumGroupResidue;
    public static Material PalladiumRichAmmonia;


    // Third Degree Materials
    public static Material PlatinumPalladiumLeachate;
    public static Material CrudePlatinumResidue;
    public static Material CrudePalladiumResidue;


    // Organic Chemistry Materials
    public static Material Butyraldehyde;
    public static Material Ethylhexanol;
    public static Material DiethylhexylPhosphoricAcid;
    public static Material Butanol;
    public static Material MethylFormate;
    public static Material FormicAcid;


    // Unknown Composition Materials
    public static Material RareEarthHydroxidesSolution;
    public static Material RareEarthChloridesSolution;


    /**
     * 3100 - 19999
     */
    public static void init() {

        // 3100-3499
        GCYSElementMaterials.init();

        // 3500-5999
        GCYSFirstDegreeMaterials.init();

        // 6000-8999
        GCYSSecondDegreeMaterials.init();

        // 9000-11999
        GCYSThirdDegreeMaterials.init();

        // 12000-14999
        GCYSHighDegreeMaterials.init();

        // 15000-17999
        GCYSOrganicChemistryMaterials.init();

        // 18000-19999
        GCYSUnknownCompositionMaterials.init();

        GCYSMaterialFlagAddition.init();
    }
}
