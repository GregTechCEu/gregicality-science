package gregicality.science.api.capability.impl;

import gregicality.science.api.GCYSValues;
import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class PressureMedium {

    private static final Map<Fluid, PressureMedium> REGISTRY = new HashMap<>();

    private final double minPressure;
    private final double maxPressure;

    public PressureMedium(double minPressure, double maxPressure) {
        this.minPressure = minPressure;
        this.maxPressure = maxPressure;
    }

    public static void init() {
        register(Materials.Air, 10E-6, 142_000.0D);
        register(Materials.Mercury, GCYSValues.EARTH_ATMOSPHERIC_PRESSURE, 28_500_100_000.0D);
    }

    public static void register(@Nonnull Fluid fluid, double minPressure, double maxPressure) {
        REGISTRY.put(fluid, new PressureMedium(minPressure, maxPressure));
    }

    public static void register(@Nonnull Material material, double minPressure, double maxPressure) {
        register(material.getFluid(), minPressure, maxPressure);
    }

    public static boolean isValidMedium(@Nonnull FluidStack stack) {
        return isValidMedium(stack.getFluid());
    }

    public static boolean isValidMedium(@Nullable Fluid fluid) {
        return REGISTRY.containsKey(fluid);
    }

    public static double getMaxPressure(@Nullable FluidStack stack) {
        if (stack == null) return Double.MIN_VALUE;
        return getMaxPressure(stack.getFluid());
    }

    public static double getMaxPressure(@Nullable Fluid fluid) {
        if (isValidMedium(fluid)) return REGISTRY.get(fluid).maxPressure;
        return Double.MIN_VALUE;
    }

    public static double getMinPressure(@Nullable FluidStack stack) {
        if (stack == null) return Double.MAX_VALUE;
        return getMinPressure(stack.getFluid());
    }

    public static double getMinPressure(@Nullable Fluid fluid) {
        if (isValidMedium(fluid)) return REGISTRY.get(fluid).minPressure;
        return Double.MAX_VALUE;
    }
}
