package com.apismensky;

/**
 * There is a leap year every year whose number is perfectly divisible by four -
 * except for years which are both divisible by 100 and not divisible by 400.
 * The second part of the rule effects century years.
 * For example; the century years 1600 and 2000 are leap years,
 * but the century years 1700, 1800, and 1900 are not.
 */
class LeapYear {
    static boolean isLeapYear(int year) {
        return year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0);
    }
}
