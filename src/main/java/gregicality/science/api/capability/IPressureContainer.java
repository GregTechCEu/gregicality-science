package gregicality.science.api.capability;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * A container which can handle pressures. All values units are in Pa
 */
public interface IPressureContainer {

    /**
     * Default pressure. Anything below this counts a vacuum
     */
    double ATMOSPHERIC_PRESSURE = 101325;

    /**
     * @return the current pressure hold by this container
     */
    double getPressure();

    /**
     * Changes the pressure by the given amount
     *
     * @param amount amount to change. + for add - for subtract
     * @return actually changed amount
     */
    double changePressure(double amount);

    /**
     * @return the maximum pressure this container can handle
     */
    double getMaxPressure();

    /**
     * @return the minimum pressure this container can handle
     */
    default double getMinPressure() {
        return ATMOSPHERIC_PRESSURE / getMaxPressure();
    }

    /**
     * @return if the container currently holds a vacuum
     */
    default boolean isVacuum() {
        return getPressure() < ATMOSPHERIC_PRESSURE - 1000;
    }

    /**
     * @return if the pressure is around atmospheric levels
     */
    default boolean isNormalPressure() {
        return getPressure() < ATMOSPHERIC_PRESSURE + 1000 && getPressure() > ATMOSPHERIC_PRESSURE - 1000;
    }

    /**
     * Determines whether this container can handle the given pressure
     *
     * @param pressure pressure to check
     * @return if pressure can be handled
     */
    default boolean canHandlePressure(double pressure) {
        return pressure >= getMinPressure() && pressure <= getMaxPressure();
    }

    static void causePressureExplosion(boolean vacuum, World world, BlockPos pos) {
        if (world != null && !world.isRemote) {
            if (vacuum) {
                //TODO implosion
                world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
            } else {
                world.createExplosion(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 5, true);
            }
        }
    }

    IPressureContainer EMPTY = new IPressureContainer() {
        @Override
        public double getPressure() {
            return ATMOSPHERIC_PRESSURE;
        }

        @Override
        public double changePressure(double amount) {
            return 0;
        }

        @Override
        public double getMaxPressure() {
            return ATMOSPHERIC_PRESSURE * 2;
        }
    };
}
