package projectEuler;

import org.junit.Test;
import static org.junit.Assert.*;

public class Problem20Test {

    @Test public void checkAnswer() {
        var expected = 0;
        var actual = Problem20.getAnswer();
        assertEquals("Problem 20 returns the correct answer", expected, actual);
    }
}