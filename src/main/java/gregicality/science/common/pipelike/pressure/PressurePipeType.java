package gregicality.science.common.pipelike.pressure;

import gregicality.science.api.GCYSValues;
import gregtech.api.pipenet.block.IPipeType;

import javax.annotation.Nonnull;

public enum PressurePipeType implements IPipeType<PressurePipeData> {
    LOW_VACUUM("low_vacuum", 0.125f, GCYSValues.P[GCYSValues.LV], GCYSValues.EARTH_PRESSURE, 1.0D),
    MEDIUM_VACUUM("medium_vacuum", 0.25f, GCYSValues.P[GCYSValues.MV], GCYSValues.EARTH_PRESSURE, 1.25D),
    HIGH_VACUUM("high_vacuum", 0.5f, GCYSValues.P[GCYSValues.HV], GCYSValues.EARTH_PRESSURE, 1.5D),
    ULTRA_HIGH_VACUUM("ultra_high_vacuum", 0.625f, GCYSValues.P[GCYSValues.UHV], GCYSValues.EARTH_PRESSURE, 2.0D),
    EXTREMELY_HIGH_VACUUM("extremely_high_vacuum", 0.75f, GCYSValues.P[GCYSValues.EHV], GCYSValues.EARTH_PRESSURE, 3.0D),
    CLOSE_SPACE_VACUUM("close_space_vacuum", 0.825f, GCYSValues.P[GCYSValues.CSV], GCYSValues.EARTH_PRESSURE, 5.0D),
    INTERGALACTIC_VOID_VACUUM("intergalactic_void_vacuum", 0.9f, GCYSValues.P[GCYSValues.IVV], GCYSValues.EARTH_PRESSURE, 10.0D),
    LOW_PRESSURE("low_pressure", 0.75f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.LP], 1.0D),
    MEDIUM_PRESSURE("medium_pressure", 0.625f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.MP], 0.75D),
    HIGH_PRESSURE("high_pressure", 0.5f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.HP], 0.625D),
    ULTRA_HIGH_PRESSURE("ultra_high_pressure", 0.375f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.UHP], 0.5D),
    ELECTRON_DEGENERACY_PRESSURE("electron_degeneracy_pressure", 0.25f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.EDP], 0.025D),
    WHITE_DWARF_PRESSURE("white_dwarf_pressure", 0.125f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.WDP], 0.0125D),
    NEUTRON_STAR_PRESSURE("neutron_star_pressure", 0.05f, GCYSValues.EARTH_PRESSURE, GCYSValues.P[GCYSValues.NSP], 0.001D);

    public final float thickness;
    public final String name;
    public final double maxPressure;
    private final double minPressure;
    private final double volume;

    PressurePipeType(String name, float thickness, double minPressure, double maxPressure, double volume) {
        this.thickness = thickness;
        this.name = name;
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
        this.volume = volume;
    }

    @Override
    public float getThickness() {
        return this.thickness;
    }

    public double getMinPressure() {
        return this.minPressure;
    }

    public double getMaxPressure() {
        return this.maxPressure;
    }

    public double getVolume() {
        return this.volume;
    }

    @Nonnull
    @Override
    public PressurePipeData modifyProperties(PressurePipeData pipeData) {
        return new PressurePipeData(minPressure, maxPressure, volume);
    }

    @Override
    public boolean isPaintable() {
        return true;
    }

    @Nonnull
    @Override
    public String getName() {
        return name;
    }
}
