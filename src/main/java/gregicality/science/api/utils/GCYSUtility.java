package gregicality.science.api.utils;

import gregicality.science.api.GCYSValues;

public class GCYSUtility {

    public static int getTierByPressure(double pressure) {
        if (pressure == GCYSValues.EARTH_PRESSURE) return GCYSValues.EAP;
        for (int i = 0; i < GCYSValues.P.length; i++) {
            double p = GCYSValues.P[i];
            if (pressure <= GCYSValues.EARTH_PRESSURE && p <= GCYSValues.EARTH_PRESSURE) {
                if (p < pressure) continue;
                else return i;
            }
            if (pressure >= GCYSValues.EARTH_PRESSURE && p > GCYSValues.EARTH_PRESSURE) {
                if (p >= pressure) return i;
            }
        }
        return 0;
    }
}
