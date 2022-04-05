package gregicality.science.api.capability.impl;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class PressureMedium {

    public static void init() {
        REGISTRY.put(null, new PressureMedium());
        register(Materials.Air);
    }

    private static final Map<FluidStack, PressureMedium> REGISTRY = new HashMap<>();

    public static void register(FluidStack fluid) {
        REGISTRY.put(fluid.copy(), new PressureMedium());
    }

    public static void register(Material material) {
        register(material.getFluid(1));
    }

    public static boolean isValidMedium(FluidStack fluid) {
        return REGISTRY.containsKey(fluid);
    }
}
