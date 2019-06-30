package projectEuler;

/*
    You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.

    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.

    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

    How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class Problem19 {
    public static int getAnswer() {
        var count = 0;

        for (var y = 1901; y <= 2000; y++) {
            for (var m = 1; m <= 12; m++) {
                var dayOfWeek = getDayOfWeek(y, m, 1);
                if (dayOfWeek == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private static final int epochStartYear = 1900;

    private static void validateYear(int year) {
        if (year < epochStartYear) throw new IllegalArgumentException("Years before 1900 not supported.");
    }

    private static void validateMonth(int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month");
    }

    private static void validateDay(int day){
        if (day < 1 || day > 31) throw new IllegalArgumentException("Invalid day");
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }

        if (year % 100 == 0
            && year % 400 != 0) {
            return false;
        }

        return true;
    }

    private static int getDaysInMonth(int year, int month) {
        validateMonth(month);

        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static int getDaysInYear(int year) {
        return isLeapYear(year) ? 366 : 365;
    }

    public static int getDaysSinceEpochStart(int year, int month, int day) {
        validateYear(year);
        validateMonth(month);
        validateDay(day);

        var result = 0;

        for (var y = epochStartYear; y < year; y++) {
            result += getDaysInYear(y);
        }

        for (var m = 1; m < month; m++) {
            result += getDaysInMonth(year, m);
        }

        result += (day - 1);

        return result;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        var epochStartDayOfWeek = 1;
        var daysSinceEpochStart = getDaysSinceEpochStart(year, month, day);
        return (epochStartDayOfWeek + daysSinceEpochStart) % 7;
    }
}

/*
    You are the 121749th person to have solved this problem.
*/