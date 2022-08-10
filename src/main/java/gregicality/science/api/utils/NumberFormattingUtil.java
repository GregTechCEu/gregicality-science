package gregicality.science.api.utils;

import gregtech.api.util.GTUtility;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NumberFormattingUtil {

    private static final NavigableMap<Double, String> suffixesByPower = new TreeMap<>();

    static {
        suffixesByPower.put(0.000_000_000_000_000_000_000_000_000_001D, "q");
        suffixesByPower.put(0.000_000_000_000_000_000_000_000_001D, "r");
        suffixesByPower.put(0.000_000_000_000_000_000_000_001D, "y");
        suffixesByPower.put(0.000_000_000_000_000_000_001D, "z");
        suffixesByPower.put(0.000_000_000_000_000_001D, "a");
        suffixesByPower.put(0.000_000_000_000_001D, "f");
        suffixesByPower.put(0.000_000_000_001D, "p");
        suffixesByPower.put(0.000_000_001D, "n");
        suffixesByPower.put(0.000_001D, "u");
        suffixesByPower.put(0.001D, "m");
        suffixesByPower.put(1.0D, "");
        suffixesByPower.put(1_000D, "k");
        suffixesByPower.put(1_000_000D, "M");
        suffixesByPower.put(1_000_000_000D, "G");
        suffixesByPower.put(1_000_000_000_000D, "T");
        suffixesByPower.put(1_000_000_000_000_000D, "P");
        suffixesByPower.put(1_000_000_000_000_000_000D, "E");
        suffixesByPower.put(1_000_000_000_000_000_000_000D, "Z");
        suffixesByPower.put(1_000_000_000_000_000_000_000_000D, "Y");
        suffixesByPower.put(1_000_000_000_000_000_000_000_000_000D, "R");
        suffixesByPower.put(1_000_000_000_000_000_000_000_000_000_000D, "Q");
    }

    @Nonnull
    public static String formatDoubleToCompactString(double value, int precision) {
        //Double.MIN_VALUE == -Double.MIN_VALUE so we need an adjustment here
        if (value == Double.MIN_VALUE) return formatDoubleToCompactString(Double.MIN_VALUE + 1, precision);

        Map.Entry<Double, String> e = suffixesByPower.floorEntry(value);
        double divideBy = e.getKey();
        String suffix = e.getValue();

        double truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10D) != (truncated / 10);
        return hasDecimal ? GTUtility.formatNumbers(truncated / 10D) + suffix : GTUtility.formatNumbers(truncated / 10) + suffix;
    }

    @Nonnull
    public static String formatDoubleToCompactString(double value) {
        return formatDoubleToCompactString(value, 3);
    }
}
