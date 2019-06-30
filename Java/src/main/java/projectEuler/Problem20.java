package projectEuler;

/*
    n! means n × (n − 1) × ... × 3 × 2 × 1

    For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
    and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

    Find the sum of the digits in the number 100!
*/

import java.util.*;
import java.math.BigInteger;

public class Problem20 {

    //Normally you would memoize w/ a HashMap, but in this case the keys will always be
    //integers starting at 0, so a list works fine.
    //A hashmap may provide faster arbitrary lookup though.
    private static final ArrayList<BigInteger> cache = new ArrayList<>();

    static {
        cache.add(BigInteger.ONE); //0! = 1
    }

    public static int getAnswer() {
        return sumDigits(factorial(100));
    }

    public static BigInteger factorial(int n) {
        var size = cache.size();

        if (size > n) {
            return cache.get(n);
        }

        var lastIndex = size-1;
        var lastValue = cache.get(lastIndex);

        for (var i = (lastIndex+1); i <= n; i++) {
            var currentValue = lastValue.multiply(BigInteger.valueOf(i));
            cache.add(currentValue);
            lastValue = currentValue;
        }

        return lastValue;
    }

    public static int sumDigits(BigInteger n) {
        var str = n.toString(/*radix*/ 10);
        var sum = 0;
        for (char c : str.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }
}

/*
    You are the 179680th person to have solved this problem.
*/