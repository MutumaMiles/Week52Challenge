package mutuma.com.week52challenge;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {
   private static NumberFormat formatter = new DecimalFormat("#,###.00");

    /**
     *
     * @param value
     * @return
     */
    public static String formattedAmount(Long value) {
        Double money = Double.parseDouble(String.valueOf(value));
        return formatter.format(money);
    }
}
