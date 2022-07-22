package gregicality.science.api.capability;

import gregicality.science.api.GCYSValues;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nonnull;

public interface IPressureContainer {

    int PRESSURE_TOLERANCE = 1000;

    /**
     * @return the amount of particles in the container
     */
    double getParticles();

    /**
     * This method should <b>never</b> return 0.
     *
     * @return the volume of the container in B
     */
    double getVolume();

    /**
     * <p>
     * Pressure = number of particles / volume
     * </p>
     * <p>
     * While not scientifically accurate, it provides enough detail for proper equalization
     *
     * @return the amount of pressure in the container
     */
    default double getPressure() {
        return getParticles() / getVolume();
    }

    /**
     * @param amount the amount of particles
     * @return the pressure if the container had a certain number of particles
     */
    default double getPressureForParticles(double amount) {
        return amount / getVolume();
    }

    /**
     * @param volume the volume, nonzero
     * @return the pressure if the container had a certain volume
     */
    default double getPressureForVolume(double volume) {
        return getParticles() / volume;
    }

    /**
     * Set the amount of particles in the container
     *
     * @param amount the amount to set
     */
    void setParticles(double amount);

    /**
     * Change the amount of particles in the container by a given amount
     *
     * @param amount   the amount to change by
     * @param simulate whether to actually change the value or not
     * @return true if the change is safe, else false
     */
    default boolean changeParticles(double amount, boolean simulate) {
        if (simulate) return isPressureSafe(getPressureForParticles(getParticles() + amount));
        setParticles(getParticles() + amount);
        return isPressureSafe();
    }

    /**
     * @return the minimum pressure this container can handle
     */
    double getMinPressure();

    /**
     * @return the maximum pressure this container can handle
     */
    double getMaxPressure();

    /**
     * @return true if the pressure is safe for the container, else false
     */
    default boolean isPressureSafe() {
        return isPressureSafe(getPressure());
    }

    /**
     * @param pressure the pressure to check
     * @return true if the pressure is safe for the container, else false
     */
    default boolean isPressureSafe(double pressure) {
        return pressure < getMaxPressure() && pressure > getMinPressure();
    }

    /**
     * @return if the pressure is around atmospheric levels
     */
    default boolean isNormalPressure() {
        return Math.abs(getPressure() - GCYSValues.EARTH_ATMOSPHERIC_PRESSURE) < PRESSURE_TOLERANCE;
    }

    default boolean isVacuum() {
        return getPressure() < GCYSValues.EARTH_ATMOSPHERIC_PRESSURE - PRESSURE_TOLERANCE;
    }

    /**
     * Causes an explosion due to pressure
     *
     * @param world the world to create the explosion in
     * @param pos   the position of the explosion
     */
    default void causePressureExplosion(World world, BlockPos pos) {
        if (world != null && !world.isRemote) {
            //TODO implosion
            if (isVacuum()) world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
            else world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
        }
    }

    /**
     * Equalizes the pressure between containers. This does not modify volume.
     *
     * @param containers the containers to merge
     */
    static void mergeContainers(@Nonnull IPressureContainer... containers) {
        mergeContainers(true, containers);
    }

    /**
     * Equalizes the pressure between containers. This does not modify volume.
     *
     * @param checkSafety whether to check if changing pressure is safe before modifying container values
     * @param containers  the containers to merge
     */
    static void mergeContainers(boolean checkSafety, @Nonnull IPressureContainer... containers) {
        // P = (n1 + n2) / (v1 + v2)
        double particles = 0;
        double volume = 0;
        for (IPressureContainer container : containers) {
            particles += container.getParticles();
            volume += container.getVolume();
        }
        if (volume == 0) return;

        // P = vN * [(n1 + n2 + ...) / (v1 + v2 + ...)] / vN
        final double newParticles = particles / volume;
        for (IPressureContainer container : containers) {
            double amount = container.getVolume() * newParticles - container.getParticles();
            if (!checkSafety || container.changeParticles(amount, true)) {
                container.changeParticles(amount, false);
            }
        }
    }

    IPressureContainer EMPTY = new IPressureContainer() {
        @Override
        public double getParticles() {
            return 0;
        }

        @Override
        public double getVolume() {
            return 1;
        }

        @Override
        public void setParticles(double amount) {/**/}

        @Override
        public double getMinPressure() {
            return GCYSValues.EARTH_ATMOSPHERIC_PRESSURE / 2;
        }

        @Override
        public double getMaxPressure() {
            return GCYSValues.EARTH_ATMOSPHERIC_PRESSURE * 2;
        }
    };
}
