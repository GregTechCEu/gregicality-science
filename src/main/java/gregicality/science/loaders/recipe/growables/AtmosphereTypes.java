package gregicality.science.loaders.recipe.growables;

import gregicality.science.api.recipes.growable.AtmosphereType;
import static gregtech.api.unification.material.Materials.*;
import net.minecraftforge.fluids.FluidStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AtmosphereTypes {

    public static AtmosphereType AmnioticFluid = new AtmosphereType("amniotic_fluid", new HashMap<FluidStack, Integer>(){{
        put(DistilledWater.getFluid(10), 4);
        put(RawGrowthMedium.getFluid(10), 2);
        put(SterileGrowthMedium.getFluid(10), 1);
    }});

    public static AtmosphereType Overworld = new AtmosphereType("overworld", new HashMap<FluidStack, Integer>(){{
        put(Air.getFluid(10), 4);
    }});

    public static AtmosphereType Nether = new AtmosphereType("nether", new HashMap<FluidStack, Integer>(){{
        put(NetherAir.getFluid(10), 4);
    }});

    public static AtmosphereType End = new AtmosphereType("end", new HashMap<FluidStack, Integer>(){{
        put(EnderAir.getFluid(10), 4);
    }});

    public static AtmosphereType Sea = new AtmosphereType("sea", new HashMap<FluidStack, Integer>(){{
        put(SaltWater.getFluid(10), 4);
    }});
}
