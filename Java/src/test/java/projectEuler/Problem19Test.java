package projectEuler;

import org.junit.Test;
import static org.junit.Assert.*;

public class Problem19Test {

    //I started writing these tests on 2019-06-30, so that's what "Today" means

    @Test public void getDaysSinceEpochStart_shouldWorkForEpochStart(){
        var year = 1900;
        var month = 1;
        var day = 1;
        var expected = 0;
        var actual = Problem19.getDaysSinceEpochStart(year, month, day);
        assertEquals(expected, actual);
    }

    @Test public void getDaysSinceEpochStart_shouldWorkForOneYearAfterEpochStart(){
        var year = 1901;
        var month = 1;
        var day = 1;
        var expected = 365; //1900 wasn't a leap year because it's divisble by 100 but not 400
        var actual = Problem19.getDaysSinceEpochStart(year, month, day);
        assertEquals(expected, actual);
    }

    @Test public void getDaysSinceEpochStart_shouldWorkForToday(){
        var year = 2019;
        var month = 6;
        var day = 30;
        var expected = 43644; //I just looked this up
        var actual = Problem19.getDaysSinceEpochStart(year, month, day);
        assertEquals(expected, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForEpochStart(){
        var year = 1900;
        var month = 1;
        var day = 1;
        var expectedDayOfWeek = 1;
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForOneWeekAfterEpochStart(){
        var year = 1900;
        var month = 1;
        var day = 8;
        var expectedDayOfWeek = 1;
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForOneYearAfterEpochStart(){
        var year = 1901;
        var month = 1;
        var day = 1;
        var expectedDayOfWeek = 2; //I just looked up this date
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForDDay(){
        var year = 1944;
        var month = 6;
        var day = 6;
        var expectedDayOfWeek = 2; //I just looked up this date
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForStartOfNewMillenium(){
        var year = 2000;
        var month = 1;
        var day = 1;
        var expectedDayOfWeek = 6; //I just looked up this date
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void getDayOfWeek_shouldWorkForToday(){
        var year = 2019;
        var month = 6;
        var day = 30;
        var expectedDayOfWeek = 0;
        var actual = Problem19.getDayOfWeek(year, month, day);
        assertEquals(expectedDayOfWeek, actual);
    }

    @Test public void checkAnswer() {
        var expected = 171;
        var actual = Problem19.getAnswer();
        assertEquals("Problem 19 returns the correct answer", expected, actual);
    }
}
