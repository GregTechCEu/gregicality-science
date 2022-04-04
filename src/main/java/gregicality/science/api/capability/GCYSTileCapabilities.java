package gregicality.science.api.capability;

import gregicality.science.api.metatileentity.IVacuumConsumer;
import gregicality.science.api.metatileentity.IVacuumProducer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

public class GCYSTileCapabilities {

    @CapabilityInject(IVacuumProducer.class)
    public static Capability<IVacuumProducer> CAPABILITY_VACUUM_PRODUCER = null;

    @CapabilityInject(IVacuumConsumer.class)
    public static Capability<IVacuumConsumer> CAPABILITY_VACUUM_CONSUMER = null;

    @CapabilityInject(IPressureContainer.class)
    public static Capability<IPressureContainer> CAPABILITY_PRESSURE_CONTAINER = null;
}
