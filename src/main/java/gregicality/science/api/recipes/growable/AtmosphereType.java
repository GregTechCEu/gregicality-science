package gregicality.science.api.recipes.growable;

import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.List;

public class AtmosphereType {
    public String name;
    public HashMap<FluidStack, Integer> fluidMap;

    public AtmosphereType(String name, HashMap<FluidStack, Integer> fluidMap) {
        this.name = name;
        this.fluidMap = fluidMap;
    }
}
