package gregicality.science.api.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class NumberFormat {

    private static final CharacterIterator ABOVE_1_PREFIX = new StringCharacterIterator("kMGTPEZY");
    private static final CharacterIterator BELOW_1_PREFIX = new StringCharacterIterator("munpfazy");

    public static String format(double num) {
        if (num == 0) {
            return "0";
        }
        if ((1 <= num && num < 1000)) {
            return String.format("%.0f", num);
        }
        if ((num < 1 && num > 0) || (num < 0 && num > -1)) {
            BELOW_1_PREFIX.setIndex(0);
            while ((num > 0 && num <= 0.00095) || (num < 0 && num >= -0.00095)) {
                num *= 1000;
                if (BELOW_1_PREFIX.next() == CharacterIterator.DONE) {
                    break;
                }
            }
            return String.format("%.0f %c", num * 1000.0, BELOW_1_PREFIX.current());
        }
        ABOVE_1_PREFIX.setIndex(0);
        while (num <= -999_950 || num >= 999_950) {
            num /= 1000;
            if (ABOVE_1_PREFIX.next() == CharacterIterator.DONE) {
                break;
            }
        }
        return String.format("%.0f %c", num / 1000.0, ABOVE_1_PREFIX.current());
    }
}
