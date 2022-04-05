package gregicality.science.api.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class GCYSTileCapabilities {

    @CapabilityInject(IPressureContainer.class)
    public static Capability<IPressureContainer> CAPABILITY_PRESSURE_CONTAINER = null;
}
