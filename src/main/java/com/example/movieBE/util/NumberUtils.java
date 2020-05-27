package com.example.movieBE.util;

import java.math.BigInteger;

public class NumberUtils {

    /**
     *
     * @param number
     * @return
     */
    public static Long toLong(BigInteger number) {
        try {
            return number.longValue();
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     *
     * @param number
     * @return
     */
    public static Long toLong(String number) {
        try {
            return Long.valueOf(number);
        } catch (Exception e) {
            return 0L;
        }
    }

    /**
     *
     * @param number
     * @return
     */
    public static Long toLong(Integer number) {
        try {
            return Long.valueOf(number);
        } catch (Exception e) {
            return 0L;
        }
    }
    /**
     *
     * @param number
     * @return
     */
    public static Double toDouble(String number) {
        try {
            return Double.valueOf(number);
        } catch (Exception e) {
            return new Double(0);
        }
    }
    /**
     *
     * @param number
     * @return
     */
    public static Double toDouble(Integer number) {
        try {
            return Double.valueOf(number);
        } catch (Exception e) {
            return new Double(0);
        }
    }
}
