package gregicality.science.api;

import static net.minecraft.util.text.TextFormatting.*;

public class GCYSValues {

    /**
     * Earth's Atmospheric Pressure at Sea Level
     * Anything smaller than this counts as a Vacuum
     */
    public static final double EARTH_PRESSURE = 101_325;

    /**
     * Earth's Temperature in Kelvin
     */
    public static final int EARTH_TEMPERATURE = 298;

    /**
     * The main pressure thresholds
     */
    public static final double[] P = new double[]{
            10E-17,
            10E-15,
            10E-9,
            10E-6,
            10E-1,
            10E2,
            31E3,
            101_325,
            275E3,
            550E3,
            7E5,
            10E7,
            4E10,
            10E23,
            10E32
    };

    public static final int IVV = 0;
    public static final int CSV = 1;
    public static final int EHV = 2;
    public static final int UHV = 3;
    public static final int HV = 4;
    public static final int MV = 5;
    public static final int LV = 6;
    public static final int EAP = 7;
    public static final int LP = 8;
    public static final int MP = 9;
    public static final int HP = 10;
    public static final int UHP = 11;
    public static final int EDP = 12;
    public static final int WDP = 13;
    public static final int NSP = 14;

    /**
     * The short names of each pressure threshold
     */
    public static final String[] PN = new String[]{
            "IVV",
            "CSV",
            "EHV",
            "UHV",
            "HV",
            "MV",
            "LV",
            "EAP",
            "LP",
            "MP",
            "HP",
            "UHP",
            "EDP",
            "WDP",
            "NSP"
    };

    /**
     * The decorated names of each pressure threshold
     */
    public static final String[] PNF = new String[]{
            BLUE + "IVV",
            DARK_GREEN + "CSV",
            DARK_RED + "EHV",
            WHITE + "UHV",
            DARK_BLUE + "HV",
            GOLD + "MV",
            GRAY + "LV",
            DARK_GRAY + "EAP",
            AQUA + "LP",
            DARK_PURPLE + "MP",
            LIGHT_PURPLE + "HP",
            DARK_AQUA + "UHP",
            GREEN + "EDP",
            YELLOW + "WDP",
            RED + "NSP"
    };

    /**
     * The full names of each pressure threshold
     */
    public static final String[] PRESSURE_NAMES = new String[]{
            "Intergalactic Void Vacuum",
            "Close-Space Vacuum",
            "Extremely High Vacuum",
            "Ultra High Vacuum",
            "High Vacuum",
            "Medium Vacuum",
            "Low Vacuum",
            "Earth Atmospheric Pressure",
            "Low Pressure",
            "Medium Pressure",
            "High Pressure",
            "Ultra High Pressure",
            "Electron Degeneracy Pressure",
            "White Dwarf Pressure",
            "Neutron Star Pressure"
    };
}
