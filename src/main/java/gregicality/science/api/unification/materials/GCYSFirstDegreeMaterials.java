package gregicality.science.api.unification.materials;

import gregtech.api.GTValues;
import gregtech.api.fluids.fluidType.FluidTypes;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.info.MaterialIconSet;
import gregtech.api.unification.material.properties.BlastProperty;

import static gregicality.science.api.unification.material.info.GCYSMaterialFlags.DISABLE_CRYSTALLIZATION;
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

        PurifiedPlatinumGroupConcentrate = new Material.Builder(3516, "purified_platinum_group_concentrate")
                .fluid()
                .color(0xFFFFC8)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 2, Platinum, 1, Palladium, 1, Chlorine, 6)
                .build();

        AmmoniumHexachloroplatinate = new Material.Builder(3517, "ammonium_hexachloroplatinate")
                .fluid()
                .color(0xFEF0C2)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Platinum, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PtCl6", true);

        AmmoniumHexachloropalladate = new Material.Builder(3518, "ammonium_hexachloropalladate")
                .fluid()
                .color(0x808080)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 2, Hydrogen, 8, Palladium, 1, Chlorine, 6)
                .build()
                .setFormula("(NH4)2PdCl6", true);

        SodiumNitrate = new Material.Builder(3519, "sodium_nitrate")
                .dust()
                .color(0x846684)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 1, Nitrogen, 1, Oxygen, 3)
                .build();

        PotassiumHydroxide = new Material.Builder(3520, "potassium_hydroxide")
                .dust().fluid()
                .color(0xFA9849)
                .flags(DISABLE_DECOMPOSITION)
                .components(Potassium, 1, Oxygen, 1, Hydrogen, 1)
                .fluidTemp(633)
                .build();

        CarbonTetrachloride = new Material.Builder(3521, "carbon_tetrachloride")
                .fluid()
                .color(0x75201A)
                .flags(DISABLE_DECOMPOSITION)
                .components(Carbon, 1, Chlorine, 4)
                .build();

        RutheniumChloride = new Material.Builder(3522, "ruthenium_chloride")
                .dust()
                .color(0x605C6C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Ruthenium, 1, Chlorine, 3)
                .build();

        SodiumPeroxide = new Material.Builder(3523, "sodium_peroxide")
                .dust()
                .color(0xECFF80)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Sodium, 2, Oxygen, 2)
                .build();

        RhodiumOxide = new Material.Builder(3524, "rhodium_oxide")
                .dust()
                .color(0xD93D16)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rhodium, 2, Oxygen, 3)
                .build();

        SodiumChlorate = new Material.Builder(3525, "sodium_chlorate")
                .dust()
                .color(0xAB8D85)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Sodium, 1, Chlorine, 1, Oxygen, 3)
                .build();

        SulfurDichloride = new Material.Builder(3526, "sulfur_dichloride")
                .fluid()
                .color(0x761410)
                .components(Sulfur, 1, Chlorine, 2)
                .build();

        ThionylChloride = new Material.Builder(3527, "thionyl_chloride")
                .fluid()
                .color(0xEBE863)
                .flags(DISABLE_DECOMPOSITION)
                .components(Sulfur, 1, Oxygen, 1, Chlorine, 2)
                .build();

        OsmiumTetrachloride = new Material.Builder(3528, "osmium_tetrachloride")
                .dust()
                .color(0x29080A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Osmium, 1, Chlorine, 4)
                .build();

        PotassiumBromate = new Material.Builder(3529, "potassium_bromate")
                .dust()
                .color(0x782828)
                .flags(DISABLE_DECOMPOSITION)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Potassium, 1, Bromine, 1, Oxygen, 3)
                .build();

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
                .components(Hydrogen, 1, Sulfur, 1, Oxygen, 3, Chlorine, 1)
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

        // FREE ID: 3550

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
                .flags(GENERATE_PLATE, DISABLE_DECOMPOSITION, CRYSTALLIZABLE, FLAMMABLE, EXPLOSIVE, DISABLE_CRYSTALLIZATION) // to disable implosion recipes
                .components(Boron, 1, Nitrogen, 1)
                .toolStats(14.0F, 9.0F, 12400, 15)
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
                .components(Germanium, 2, Antimony, 2, Tellurium, 5)
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
                .flags(DECOMPOSITION_BY_ELECTROLYZING, GENERATE_PLATE)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Cadmium, 1, Sulfur, 1)
                .build();

        CadmiumSelenide = new Material.Builder(3588, "cadmium_selenide") //TODO "Quantum Dots" tooltip
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
                .ingot().fluid()
                .color(0x05090C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD,
                        GENERATE_FINE_WIRE, GENERATE_SPRING)
                .cableProperties(GTValues.V[GTValues.UEV], 8, 6)
                .components(Carbon, 48)
                .build()
                .setFormula("CNT", false);

        LithiumHydroxide = new Material.Builder(3593, "lithium_hydroxide")
                .dust()
                .color(0xDECAFA)
                .iconSet(MaterialIconSet.FINE)
                .components(Lithium, 1, Oxygen, 1, Hydrogen, 1)
                .build();

        LithiumAmalgam = new Material.Builder(3594, "lithium_amalgam")
                .fluid()
                .color(0xAEA7D4).iconSet(MaterialIconSet.FINE)
                .flags(DISABLE_DECOMPOSITION)
                .components(Mercury, 1, Lithium, 1)
                .build();

        Lithium7Hydroxide = new Material.Builder(3595, "lithium_7_hydroxide")
                .dust()
                .color(0xAEAACA).iconSet(MaterialIconSet.FINE)
                .flags(DECOMPOSITION_BY_ELECTROLYZING)
                .components(Lithium7, 1, Oxygen, 1, Hydrogen, 1)
                .build()
                .setFormula("LiOH", true);

        NeptuniumAluminide = new Material.Builder(3596, "neptunium_aluminide")
                .ingot().fluid()
                .color(0x5E228F)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_PLATE, GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Neptunium, 1, Aluminium, 3)
                .blastTemp(1568, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.ZPM])
                .build()
                .setFormula("NpAl3", true);

        BismuthTrioxide = new Material.Builder(3597, "bismuth_trioxide")
                .dust()
                .color(0xF5EF42).iconSet(MaterialIconSet.FINE)
                .components(Bismuth, 2, Oxygen, 3)
                .build();

        FerricOxide = new Material.Builder(3598, "ferric_oxide")
                .dust()
                .color(0x915A5A).iconSet(MaterialIconSet.ROUGH)
                .components(Iron, 2, Oxygen, 3)
                .build();

        BismuthChalcogenide = new Material.Builder(3599, "bismuth_chalcogenide") //TODO "3D Topological Isolator" tooltip
                .ingot()
                .color(0x91994D).iconSet(MaterialIconSet.SHINY)
                .flags(GENERATE_PLATE, GENERATE_FOIL, DECOMPOSITION_BY_ELECTROLYZING)
                .components(Bismuth, 1, Antimony, 1, Tellurium, 2, Sulfur, 1)
                .build();

        MercuryCadmiumTelluride = new Material.Builder(3600, "mercury_cadmium_telluride")
                .ingot().fluid()
                .color(0x823C80).iconSet(MaterialIconSet.BRIGHT)
                .flags(GENERATE_FINE_WIRE)
                .components(Mercury, 2, Cadmium, 1, Tellurium, 2)
                .cableProperties(GTValues.V[GTValues.UHV], 6, 8)
                .blastTemp(2170, BlastProperty.GasTier.HIGHER, GTValues.VA[GTValues.UHV])
                .build();

        AluminiumSelenide = new Material.Builder(3601, "aluminium_selenide")
                .dust()
                .color(0x969651)
                .components(Aluminium, 2, Selenium, 3)
                .build();

        HydrogenSelenide = new Material.Builder(3602, "hydrogen_selenide")
                .fluid(FluidTypes.GAS)
                .color(0x42f554)
                .components(Hydrogen, 2, Selenium, 1)
                .build();

        PalladiumNitrate = new Material.Builder(3603, "palladium_nitrate")
                .dust()
                .color(0x82312A).iconSet(MaterialIconSet.METALLIC)
                .components(Palladium, 1, Nitrogen, 2, Oxygen, 6)
                .build()
                .setFormula("Pd(NO3)2", true);

        Fullerene = new Material.Builder(3604, "fullerene")
                .ingot()
                .color(0x72556A)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION, NO_SMELTING, GENERATE_PLATE, GENERATE_FOIL, GENERATE_ROD, GENERATE_RING,
                        GENERATE_FRAME)
                .components(Carbon, 60)
                .build();

        ThalliumCopperChloride = new Material.Builder(3605, "thallium_copper_chloride") //TODO "Antiferromagnetic" Tooltip
                .ingot().fluid()
                .color(0x3C5CB5)
                .iconSet(MaterialIconSet.MAGNETIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Thallium, 1, Copper, 1, Chlorine, 3)
                .build();

        PerrhenicAcid = new Material.Builder(3606, "perrhenic_acid")
                .dust()
                .color(0xE6DC70)
                .iconSet(MaterialIconSet.SHINY)
                .flags(DISABLE_DECOMPOSITION)
                .components(Hydrogen, 1, Rhenium, 1, Oxygen, 4)
                .build();

        AmmoniumPerrhenate = new Material.Builder(3607, "ammonium_perrhenate")
                .dust()
                .color(0xA69970)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Nitrogen, 1, Hydrogen, 4, Rhenium, 1, Oxygen, 4)
                .build();

        ThalliumSulfate = new Material.Builder(3608, "thallium_sulfate")
                .dust()
                .color(0x9C222C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Thallium, 2, Sulfur, 1, Oxygen, 4)
                .build();

        HeavyTaraniumFuel = new Material.Builder(3609, "heavy_taranium_fuel")
                .fluid()
                .color(0x141414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        MediumTaraniumFuel = new Material.Builder(3610, "medium_taranium_fuel")
                .fluid()
                .color(0x181818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        LightTaraniumFuel = new Material.Builder(3611, "light_taranium_fuel")
                .fluid()
                .color(0x1C1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        HeavyEnrichedTaraniumFuel = new Material.Builder(3612, "heavy_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1414)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        MediumEnrichedTaraniumFuel = new Material.Builder(3613, "medium_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1818)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        LightEnrichedTaraniumFuel = new Material.Builder(3614, "light_enriched_taranium_fuel")
                .fluid()
                .color(0x0F1C1C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Taranium, 1)
                .build();

        Adamantite = new Material.Builder(3615, "adamantite")
                .dust()
                .color(0xC83C3C)
                .iconSet(MaterialIconSet.ROUGH)
                .components(Adamantium, 3, Oxygen, 4)
                .build();

        AdamantiumUnstable = new Material.Builder(3616, "adamantium_unstable")
                .fluid()
                .color(0xFF763C)
                .flags(DISABLE_DECOMPOSITION)
                .components(Adamantium, 1)
                .build();

        OrichalcumEnergized = new Material.Builder(3617, "orichalcum_energized")
                .dust()
                .color(0xF4FC0C)
                .iconSet(MaterialIconSet.BRIGHT)
                .flags(DISABLE_DECOMPOSITION)
                .components(Orichalcum, 1)
                .build();

        AdamantiumEnriched = new Material.Builder(3618, "adamantium_enriched")
                .dust()
                .color(0x64B4FF)
                .iconSet(MaterialIconSet.ROUGH)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1, RareEarth, 1)
                .build();

        DeepIron = new Material.Builder(3619, "deep_iron")
                .dust()
                .color(0x968C8C)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(DISABLE_DECOMPOSITION)
                .components(Iron, 2, Trinium, 1, Indium, 1)
                .build();

        VibraniumUnstable = new Material.Builder(3620, "vibranium_unstable")
                .fluid()
                .color(0xFF7832)
                .flags(DISABLE_DECOMPOSITION)
                .components(Vibranium, 1)
                .build();

        SiliconCarbide = new Material.Builder(3621, "silicon_carbide") //TODO Carborundum tooltip
                .dust()
                .color(0x4D4D4D)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_FINE_WIRE)
                .components(Silicon, 1, Carbon, 1)
                .blastTemp(2500, BlastProperty.GasTier.HIGH, GTValues.VA[GTValues.UV])
                .cableProperties(GTValues.V[GTValues.UHV], 6, 8)
                .build();

        ChromiumGermaniumTelluride = new Material.Builder(3622, "cgt")
                .ingot().fluid()
                .color(0x8F103E)
                .iconSet(MaterialIconSet.METALLIC)
                .flags(GENERATE_ROD, GENERATE_LONG_ROD)
                .components(Chrome, 1, Germanium, 1, Tellurium, 3)
                .blastTemp(2900, BlastProperty.GasTier.HIGHER)
                .build();

        Kovar = new Material.Builder(3623, "kovar")
                .ingot()
                .color(0xCBC0A6)
                .flags(GENERATE_ROD, GENERATE_RING, DECOMPOSITION_BY_CENTRIFUGING)
                .components(Iron, 4, Nickel, 2, Cobalt, 1)
                .build();

        StannicChloride = new Material.Builder(3624, "stannic_chloride")
                .fluid()
                .color(0x33BBF5)
                .components(Tin, 1, Chlorine, 4)
                .build();

        RubidiumChlorostannate = new Material.Builder(3625, "rubidium_chlorostannate")
                .dust()
                .color(0xBD888A)
                .iconSet(MaterialIconSet.METALLIC)
                .components(Rubidium, 2, Tin, 1, Chlorine, 6)
                .build();

        CaesiumChlorostannate = new Material.Builder(3626, "caesium_chlorostannate")
                .dust()
                .color(0xBDAD88)
                .iconSet(MaterialIconSet.SHINY)
                .components(Caesium, 2, Tin, 1, Chlorine, 6)
                .build();

        HRAMagnesium = new Material.Builder(3627, "hra_magnesium") //TODO "Reike Metal" tooltip
                .dust()
                .color(Magnesium.getMaterialRGB())
                .iconSet(MaterialIconSet.SHINY)
                .components(Magnesium, 1)
                .build();

        LithiumFluoride = new Material.Builder(3628,"lithium_fluoride")
                .dust()
                .color(0x9AE7AD)
                .components(Lithium,1 , Fluorine, 1)
                .build();
    }
}
