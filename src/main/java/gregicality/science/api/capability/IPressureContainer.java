package gregicality.science.api.capability;

public interface IPressureContainer {

    static final double ATMOSPHERIC_PRESSURE = 101325;

    double getPressure();

    void applyPressure(double amount);

    double getMaxPressure();

    default double getMinPressure() {
        return 1 / getMaxPressure();
    }

    static final IPressureContainer EMPTY = new IPressureContainer() {
        @Override
        public double getPressure() {
            return 0;
        }

        @Override
        public void applyPressure(double amount) {
        }

        @Override
        public double getMaxPressure() {
            return ATMOSPHERIC_PRESSURE;
        }
    };
}
