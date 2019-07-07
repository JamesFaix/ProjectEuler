package projectEuler;

import org.junit.Test;
import static org.junit.Assert.*;

import java.math.BigInteger;

public class Problem20Test {

    @Test public void checkAnswer() {
        var expected = 648;
        var actual = Problem20.getAnswer();
        assertEquals("Problem 20 returns the correct answer", expected, actual);
    }

    @Test public void factorial_shouldWorkFor0() {
        var expected = BigInteger.ONE;
        var actual = Problem20.factorial(0);
        assertEquals(expected, actual);
    }

    @Test public void factorial_shouldWorkFor2() {
        var expected = BigInteger.valueOf(2);
        var actual = Problem20.factorial(2);
        assertEquals(expected, actual);
    }

    @Test public void factorial_shouldWorkFor4() {
        var expected = BigInteger.valueOf(24);
        var actual = Problem20.factorial(4);
        assertEquals(expected, actual);
    }

    @Test public void factorial_shouldWorkFor100() {
        //Looked this up w/ WolframAlpha
        var expected = new BigInteger(
            "933262154439441526816992388562667" +
            "004907159682643816214685929638952" +
            "175999932299156089414639761565182" +
            "862536979208272237582511852109168" +
            "64000000000000000000000000");

        var actual = Problem20.factorial(100);
        assertEquals(expected, actual);
    }
}