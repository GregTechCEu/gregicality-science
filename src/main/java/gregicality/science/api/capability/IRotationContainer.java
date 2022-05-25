package gregicality.science.api.capability;

/**
 * A container which can handle pressures. All values units are in Pa
 */
public interface IRotationContainer {

    /**
     * @return the current speed of this container
     */
    long getSpeed();

    /**
     * @return the maximum speed this container can handle
     */
    long getMaxSpeed();

    /**
     * @return the current power of this container
     */
    int getPower();

    /**
     *
     * @return the current rotation of this container
     */
    EnumRotation getRotation();

    /**
     * Changes the speed by the given amount
     *
     * @param amount amount to change. + for add - for subtract
     * @return actually changed amount
     */
    long changeSpeed(long amount);

    /**
     * Changes the power by the given amount
     *
     * @param amount amount to change. + for add - for subtract
     * @return actually changed amount
     */
    int changePower(int amount);

    /**
     * Changes the direction to the given type
     *
     * @param rotation the direction to change to
     * @return the new direction
     */
    EnumRotation changeRotation(EnumRotation rotation);

    /**
     * Determines whether this container can handle the given speed
     *
     * @param speed speed to check
     * @return if speed can be handled
     */
    default boolean canHandleSpeed(int speed) {
        return speed <= getMaxSpeed();
    }

    IRotationContainer EMPTY = new IRotationContainer() {

        @Override
        public long getSpeed() {
            return 0;
        }

        @Override
        public int getPower() {
            return 0;
        }

        @Override
        public EnumRotation getRotation() {
            return EnumRotation.NONE;
        }

        @Override
        public long getMaxSpeed() {
            return 0;
        }

        @Override
        public long changeSpeed(long amount) {
            return 0;
        }

        @Override
        public int changePower(int amount) {
            return 0;
        }

        @Override
        public EnumRotation changeRotation(EnumRotation rotation) {
            return EnumRotation.NONE;
        }
    };
}
