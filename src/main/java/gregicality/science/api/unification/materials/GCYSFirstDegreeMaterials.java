package gregicality.science.api.unification.materials;

import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregicality.science.api.unification.materials.GCYSMaterials.*;
import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialFlags.*;

public class GCYSFirstDegreeMaterials {

    /**
     * 3500-5999
     */
    public static void init() {

        LanthanumOxide = new Material.Builder(3500, "lanthanum_oxide")
                .dust()
                .color(0x5F7777)
                .iconSet(MaterialIconSet.SHINY)
                .components(Lanthanum, 2, Oxygen, 3)
                .build();

        PraseodymiumOxide = new Material.Builder(3501, "praseodymium_oxide")
                .dust()
                .color(0xD0D0D0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Praseodymium, 2, Oxygen, 3)
                .build();

        NeodymiumOxide = new Material.Builder(3502, "neodymium_oxide")
                .dust()
                .color(0x868686)
                .components(Neodymium, 2, Oxygen, 3)
                .build();

        CeriumOxide = new Material.Builder(3503, "cerium_oxide")
                .dust()
                .color(0x10937F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cerium, 1, Oxygen, 2)
                .build();

        ScandiumOxide = new Material.Builder(3504, "scandium_oxide")
                .dust()
                .color(0x43964F)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Scandium, 2, Oxygen, 3)
                .build();

        EuropiumOxide = new Material.Builder(3505, "europium_oxide")
                .dust()
                .color(0x20AAAA)
                .iconSet(MaterialIconSet.SHINY)
                .components(Europium, 2, Oxygen, 3)
                .build();

        GadoliniumOxide = new Material.Builder(3506, "gadolinium_oxide")
                .dust()
                .color(0xEEEEFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gadolinium, 2, Oxygen, 3)
                .build();

        SamariumOxide = new Material.Builder(3507, "samarium_oxide")
                .dust()
                .color(0xFFFFDD)
                .components(Samarium, 2, Oxygen, 3)
                .build();

        YttriumOxide = new Material.Builder(3508, "yttrium_oxide")
                .dust()
                .color(0x78544E)
                .iconSet(MaterialIconSet.SHINY)
                .components(Yttrium, 2, Oxygen, 3)
                .build();

        TerbiumOxide = new Material.Builder(3509, "terbium_oxide")
                .dust()
                .color(0xA264A2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Terbium, 2, Oxygen, 3)
                .build();

        DysprosiumOxide = new Material.Builder(3510, "dysprosium_oxide")
                .dust()
                .color(0xD273D2)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Dysprosium, 2, Oxygen, 3)
                .build();

        HolmiumOxide = new Material.Builder(3511, "holmium_oxide")
                .dust()
                .color(0xAF7F2A)
                .iconSet(MaterialIconSet.SHINY)
                .components(Holmium, 2, Oxygen, 3)
                .build();

        ErbiumOxide = new Material.Builder(3512, "erbium_oxide")
                .dust()
                .color(0xE07A32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Erbium, 2, Oxygen, 3)
                .build();

        ThuliumOxide = new Material.Builder(3513, "thulium_oxide")
                .dust()
                .color(0x3B9E8B)
                .components(Thulium, 2, Oxygen, 3)
                .build();

        YtterbiumOxide = new Material.Builder(3514, "ytterbium_oxide")
                .dust()
                .color(0xA9A9A9)
                .components(Ytterbium, 2, Oxygen, 3)
                .build();

        LutetiumOxide = new Material.Builder(3515, "lutetium_oxide")
                .dust()
                .color(0x11BBFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lutetium, 2, Oxygen, 3)
                .build();

        PlatinumMetallic = new Material.Builder(3516, "platinum_metallic")
                .dust()
                .color(0xFFFBC5)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Platinum, 1, RareEarth, 1)
                .build();

        PalladiumMetallic = new Material.Builder(3517, "palladium_metallic")
                .dust()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Platinum, 1, RareEarth, 1)
                .build();

        AmmoniumHexachloroplatinate = new Material.Builder(3518, "ammonium_hexachloroplatinate")
                .dust()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        PotassiumHydroxide = new Material.Builder(3519, "potassium_hydroxide")
                .dust().fluid()
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .fluidTemp(633)
                .build();

        PotassiumBromate = new Material.Builder(3520, "potassium_bromate")
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();

        PotassiumPyrosulfate = new Material.Builder(3521, "potassium_pyrosulfate")
                .dust()
                .color(0xFBBB66)
                .iconSet(MaterialIconSet.SHINY)
                .components(Potassium, 2, Sulfur, 2, Oxygen, 7)
                .build();

        PotassiumSulfate = new Material.Builder(3522, "potassium_sulfate")
                .dust()
                .color(0xF0B064)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Potassium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        ZincSulfate = new Material.Builder(3523, "zinc_sulfate")
                .dust()
                .color(0x846649)
                .iconSet(MaterialIconSet.FINE)
                .components(Zinc, 1, Sulfur, 1, Oxygen, 4)
                .build();

        SodiumNitrate = new Material.Builder(3524, "sodium_nitrate")
                .dust()
                .color(0x846684)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 1, Nitrogen, 3, Oxygen, 9)
                .build()
                .setFormula("Na(NO3)3", true);

        RhodiumNitrate = new Material.Builder(3525, "rhodium_nitrate")
                .dust()
                .color(0x776649)
                .iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Rhodium, 1, Nitrogen, 3, Oxygen, 9)
                .build()
                .setFormula("Rh(NO3)3", true);

        SodiumRuthenate = new Material.Builder(3526, "sodium_ruthenate")
                .dust()
                .color(0x3A40CB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Ruthenium, 1, Oxygen, 4)
                .build();

        SodiumPeroxide = new Material.Builder(3527, "sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        IridiumDioxideResidue = new Material.Builder(3528, "iridium_dioxide_residue")
                .dust()
                .color(0x17182E)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iridium, 1, Oxygen, 2, RareEarth, 1)
                .build();

        AmmoniumHexachloroIridiate = new Material.Builder(3529, "ammonium_hexachloroiridiate")
                .dust()
                .color(0x644629)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Iridium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2IrCl6", true);

        TungstenTrioxide = new Material.Builder(3530, "tungsten_trioxide")
                .dust()
                .color(0xC7D300)
                .iconSet(MaterialIconSet.DULL)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tungsten, 1, Oxygen, 3)
                .build();

        HydrogenPeroxide = new Material.Builder(3531, "hydrogen_peroxide")
                .fluid()
                .color(0xD2FFFF)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Oxygen, 2)
                .build();

        Hydrazine = new Material.Builder(3532, "hydrazine")
                .fluid()
                .color(0xB50707)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 4)
                .build();

        BerylliumOxide = new Material.Builder(3533, "beryllium_oxide")
                .ingot()
                .color(0x54C757)
                .flags(GENERATE_ROD, GENERATE_RING)
                .components(Beryllium, 1, Oxygen, 1)
                .build();

        TantalumPentoxide = new Material.Builder(3534, "tantalum_pentoxide")
                .dust()
                .color(0x72728A)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Tantalum, 2, Oxygen, 5)
                .build();

        NiobiumPentoxide = new Material.Builder(3535, "niobium_pentoxide")
                .dust()
                .color(0xBAB0C3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Niobium, 2, Oxygen, 5)
                .build();

        CalciumDifluoride = new Material.Builder(3536, "calcium_difluoride")
                .dust()
                .color(0xFFFC9E)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Calcium, 1, Fluorine, 2)
                .build();

        ManganeseDifluoride = new Material.Builder(3537, "manganese_difluoride")
                .dust()
                .color(0xEF4B3D)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Manganese, 1, Fluorine, 2)
                .build();

        CalciumCarbide = new Material.Builder(3538, "calcium_carbide")
                .dust()
                .color(0x807B70)
                .iconSet(MaterialIconSet.DULL)
                .components(Calcium, 1, Carbon, 2)
                .build();

        CalciumHydroxide = new Material.Builder(3539, "calcium_hydroxide")
                .dust()
                .color(0x5F8764)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Calcium, 1, Hydrogen, 2, Oxygen, 2)
                .build()
                .setFormula("Ca(OH)2", true);

        SodiumCyanide = new Material.Builder(3540, "sodium_cyanide")
                .dust()
                .color(0x5F7C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 1, Carbon, 1, Nitrogen, 1)
                .build();

        ChlorosulfuricAcid = new Material.Builder(3541, "chlorosulfuric_acid")
                .fluid()
                .color(0x916C1D)
                .components(Hydrogen, 1, Chlorine, 1, Sulfur, 1, Oxygen, 3)
                .build();

        CubicZirconia = new Material.Builder(3542, "cubic_zirconia")
                .gem()
                .color(0xFFDFE2)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(CRYSTALLIZABLE, DISABLE_DECOMPOSITION)
                .components(Zirconium, 1, Oxygen, 2)
                .build();

        MolybdenumTrioxide = new Material.Builder(3543, "molybdenum_trioxide")
                .dust()
                .color(0xCBCFDA)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Molybdenum, 1, Oxygen, 3)
                .build();

        LeadChloride = new Material.Builder(3544, "lead_chloride")
                .dust()
                .color(0xF3F3F3)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Lead, 1, Chlorine, 2)
                .build();

        SodiumTellurite = new Material.Builder(3545, "sodium_tellurite")
                .dust()
                .color(0xC6C9BE)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sodium, 2, Tellurium, 1, Oxygen, 3)
                .build();

        TelluriumDioxide = new Material.Builder(3546, "tellurium_dioxide")
                .dust()
                .color(0xE3DDB8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Tellurium, 1, Oxygen, 2)
                .build();

        SeleniumDioxide = new Material.Builder(3547, "selenium_dioxide")
                .dust()
                .color(0xE0DDD8)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Selenium, 1, Oxygen, 2)
                .build();

        SelenousAcid = new Material.Builder(3548, "selenous_acid")
                .dust()
                .color(0xE0E083)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Selenium, 1, Oxygen, 3)
                .build();

        BoricAcid = new Material.Builder(3549, "boric_acid")
                .dust()
                .color(0xFAFAFA)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 3, Boron, 1, Oxygen, 3)
                .build();

        MetaboricAcid = new Material.Builder(3550, "metaboric_acid")
                .dust()
                .color(0xCBFACF)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Boron, 1, Oxygen, 2)
                .build();

        BoronTrioxide = new Material.Builder(3551, "boron_trioxide")
                .dust()
                .color(0xE9FAC0)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Boron, 2, Oxygen, 3)
                .build();

        BoronTrifluoride = new Material.Builder(3552, "boron_trifluoride")
                .fluid(FluidTypes.GAS)
                .color(0xFAF191)
                .components(Boron, 1, Fluorine, 3)
                .build();

        LithiumTetrafluoroborate = new Material.Builder(3553, "lithium_tetrafluoroborate")
                .dust()
                .color(0x90FAF6)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Lithium, 1, Boron, 1, Fluorine, 4)
                .build();

        Diborane = new Material.Builder(3554, "diborane")
                .fluid(FluidTypes.GAS)
                .color(0x3F3131)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 2, Hydrogen, 6)
                .build();

        Borazine = new Material.Builder(3555, "borazine") //TODO "Boron Aromatic" tooltip
                .fluid()
                .color(0x542828)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Hydrogen, 6, Nitrogen, 3)
                .build();

        BoronTrichloride = new Material.Builder(3556, "boron_trichloride")
                .fluid(FluidTypes.GAS)
                .color(0x033F1B)
                .components(Boron, 1, Chlorine, 3)
                .build();

        Trichloroborazine = new Material.Builder(3557, "trichloroborazine") //TODO "Boron Aromatic" tooltip
                .fluid()
                .color(0xD62929)
                .flags(DISABLE_DECOMPOSITION)
                .components(Boron, 3, Chlorine, 3, Hydrogen, 3, Nitrogen, 3)
                .build();

        HexagonalBoronNitride = new Material.Builder(3558, "hexagonal_boron_nitride")
                .gem()
                .color(0x6A6A72)
                .iconSet(MaterialIconSet.GEM_VERTICAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("h-BN", true);

        CubicBoronNitride = new Material.Builder(3559, "cubic_boron_nitride")
                .gem()
                .color(0x545572)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, CRYSTALLIZABLE, FLAMMABLE, EXPLOSIVE) // to disable implosion recipes
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("c-BN", true);

        AmorphousBoronNitride = new Material.Builder(3560, "amorphous_boron_nitride")
                .ingot()
                .color(0x9193C5)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, NO_SMASHING, NO_SMELTING)
                .components(Boron, 1, Nitrogen, 1)
                .build()
                .setFormula("a-BN", true);

        Heterodiamond = new Material.Builder(3561, "heterodiamond")
                .gem()
                .color(0x512A72)
                .iconSet(MaterialIconSet.GEM_HORIZONTAL)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 1, Nitrogen, 1)
                .build();

        CubicHeterodiamond = new Material.Builder(3562, "cubic_heterodiamond")
                .gem()
                .color(0x753DA6)
                .iconSet(MaterialIconSet.DIAMOND)
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION)
                .components(Boron, 1, Carbon, 2, Nitrogen, 1)
                .build()
                .setFormula("c-BC2N", true);

        LithiumHydride = new Material.Builder(3563, "lithium_hydride")
                .ingot()
                .color(0x9BAFDB)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Lithium, 1, Hydrogen, 1)
                .build();

        HydrobromicAcid = new Material.Builder(3564, "hydrobromic_acid")
                .fluid(FluidTypes.ACID)
                .color(0x8D1212)
                .components(Hydrogen, 1, Bromine, 1)
                .build();

        WhitePhosphorus = new Material.Builder(3565, "white_phosphorus")
                .gem()
                .color(0xECEADD)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        RedPhosphorus = new Material.Builder(3566, "red_phosphorus")
                .gem()
                .color(0x77040E)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        VioletPhosphorus = new Material.Builder(3567, "violet_phosphorus")
                .gem()
                .color(0x8000FF)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        BlackPhosphorus = new Material.Builder(3568, "black_phosphorus")
                .gem()
                .color(0x36454F)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        BluePhosphorus = new Material.Builder(3569, "blue_phosphorus")
                .gem()
                .color(0x9BE3E4)
                .iconSet(MaterialIconSet.FLINT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Phosphorus, 4)
                .build();

        Phosphorene = new Material.Builder(3570, "phosphorene")
                .ingot()
                .color(0x273239)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION, GENERATE_FOIL)
                .components(Phosphorus, 4)
                .build();

        PhosphorusTrichloride = new Material.Builder(3571, "phosphorus_trichloride")
                .fluid()
                .color(0xE8C474)
                .components(Phosphorus, 1, Chlorine, 3)
                .build();

        PhosphorylChloride = new Material.Builder(3572, "phosphoryl_chloride")
                .fluid()
                .color(0xE8BB5B)
                .components(Phosphorus, 1, Oxygen, 1, Chlorine, 3)
                .build();

        ZincOxide = new Material.Builder(3573, "zinc_oxide")
                .dust()
                .color(0xB85C34)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Zinc, 1, Oxygen, 1)
                .build();

        GermaniumTetrachloride = new Material.Builder(3574, "germanium_tetrachloride")
                .fluid()
                .color(0x787878)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Chlorine, 4)
                .build();

        GermaniumDioxide = new Material.Builder(3575, "germanium_dioxide")
                .dust()
                .color(0x666666)
                .flags(DISABLE_DECOMPOSITION)
                .components(Germanium, 1, Oxygen, 2)
                .build();

        SiliconTetrachloride = new Material.Builder(3576, "silicon_tetrachloride")
                .fluid()
                .color(0x5B5B7A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Silicon, 1, Chlorine, 4)
                .build();

        GSTGlass = new Material.Builder(3577, "gst_glass")
                .ingot().fluid()
                .color(0xCFFFFF)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, NO_SMASHING, NO_WORKING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Germanium, 2, Tellurium, 2, Antimony, 5)
                .blastTemp(873, BlastProperty.GasTier.MID)
                .build();

        ZBLANGlass = new Material.Builder(3578, "zblan_glass")
                .ingot().fluid()
                .color(0xACB4BC)
                .iconSet(MaterialIconSet.SHINY)
                .flags(NO_SMASHING, NO_WORKING, DISABLE_DECOMPOSITION)
                .components(Zirconium, 5, Barium, 2, Lanthanum, 1, Aluminium, 1, Sodium, 2, Fluorine, 6)
                .build()
                .setFormula("(ZrF4)5(BaF2)2(LaF3)(AlF3)(NaF)2", true);

        HeliumNeon = new Material.Builder(3579, "helium_neon")
                .fluid(FluidTypes.GAS)
                .color(0xFF0080)
                .flags(DECOMPOSITION_BY_CENTRIFUGING)
                .components(Helium, 9, Neon, 1)
                .build();

        AluminiumHydroxide = new Material.Builder(3580, "aluminium_hydroxide")
                .dust()
                .color(0xBEBEC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Oxygen, 3, Hydrogen, 3)
                .build()
                .setFormula("Al(OH)3", true);

        AluminiumTrichloride = new Material.Builder(3581, "aluminium_trichloride")
                .dust()
                .color(0x78C3EB)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Aluminium, 1, Chlorine, 3)
                .build();

        GalliumTrichloride = new Material.Builder(3582, "gallium_trichloride")
                .dust()
                .color(0x6EB4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Gallium, 1, Chlorine, 3)
                .build();

        GalliumTrioxide = new Material.Builder(3583, "gallium_trioxide")
                .dust().fluid().fluidTemp(2170)
                .color(0xE4CDFF)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Gallium, 1, Oxygen, 3)
                .build();

        GalliumNitride = new Material.Builder(3584, "gallium_nitride")
                .ingot()
                .color(0xFFF458)
                .iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE)
                .components(Gallium, 1, Nitrogen, 1)
                .build();

        CadmiumBromide = new Material.Builder(3585, "cadmium_bromide")
                .dust()
                .color(0xFF1774)
                .iconSet(MaterialIconSet.SHINY)
                .components(Cadmium, 1, Bromine, 2)
                .build();

        MagnesiumBromide = new Material.Builder(3586, "magnesium_bromide")
                .dust()
                .color(0x5F4C32)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Magnesium, 1, Bromine, 2)
                .build();

        CadmiumSulfide = new Material.Builder(3587, "cadmium_sulfide")
                .dust()
                .color(0xC8C43C)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .build();

        CadmiumSelenide = new Material.Builder(3588, "cadmium_selenide")
                .dust()
                .color(0x983034)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Selenium, 1)
                .build();

        Phosphine = new Material.Builder(3589, "phosphine")
                .fluid(FluidTypes.GAS)
                .color(0xACB330)
                .flags(DECOMPOSITION_BY_ELECTROLYZING, FLAMMABLE)
                .components(Phosphorus, 1, Hydrogen, 3)
                .build();

        PlutoniumTrihydride = new Material.Builder(3590, "plutonium_trihydride")
                .dust()
                .color(0x140002)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Plutonium239, 1, Hydrogen, 3)
                .build()
                .setFormula("PuH3", true);

        PlutoniumPhosphide = new Material.Builder(3591, "plutonium_phosphide")
                .ingot()
                .color(0x1F0104)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Plutonium239, 1, Phosphorus, 1)
                .build()
                .setFormula("PuP", true);

        CarbonNanotube = new Material.Builder(3592, "carbon_nanotube")
                .ingot()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD, GENERATE_FINE_WIRE)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6, false)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);
    }
}
