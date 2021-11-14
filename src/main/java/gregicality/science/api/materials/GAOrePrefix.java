package gregicality.science.api.materials;

import gregtech.api.unification.ore.OrePrefix;

import static gregtech.api.GTValues.M;
import static gregtech.api.unification.ore.OrePrefix.Flags.ENABLE_UNIFICATION;

public class GAOrePrefix {

    public static OrePrefix opticalFiberHex;
    public static OrePrefix opticalFiberOctal;
    public static OrePrefix opticalFiberQuadruple;
    public static OrePrefix opticalFiberDouble;
    public static OrePrefix opticalFiberSingle;

    public static void initPrefixes() {
        opticalFiberHex = new OrePrefix("opticalFiberHex", M * 8, null, null, ENABLE_UNIFICATION, null);
        opticalFiberOctal = new OrePrefix("opticalFiberOctal", M * 4, null, null, ENABLE_UNIFICATION, null);
        opticalFiberQuadruple = new OrePrefix("opticalFiberQuadruple", M * 2, null, null, ENABLE_UNIFICATION, null);
        opticalFiberDouble = new OrePrefix("opticalFiberDouble", M, null, null, ENABLE_UNIFICATION, null);
        opticalFiberSingle = new OrePrefix("opticalFiberSingle", M / 2, null, null, ENABLE_UNIFICATION, null);
    }
}
