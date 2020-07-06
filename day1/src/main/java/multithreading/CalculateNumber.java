package multithreading;

import java.math.BigDecimal;

public class CalculateNumber {

    public static long calculateBigNumber(int lastIndex) {
        long number = 0;
        for(int i = 0; i< lastIndex; i++) {
            number += i;
        }

        return number;
    }
}
