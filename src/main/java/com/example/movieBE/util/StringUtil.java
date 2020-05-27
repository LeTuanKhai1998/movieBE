package com.example.movieBE.util;

public class StringUtil {

    /**
     *
     * @param string
     * @return
     */
    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }

    /**
     *
     * @param string
     * @return
     */
    public static boolean isBlank(String string) {
        if (isEmpty(string)) {
            return true;
        }

        // replace 2 bytes space
        string = string.replaceAll(" ", "");

        return string.trim().length() == 0;
    }

    /**
     *
     * @param object
     * @return
     */
    public static boolean isEmpty(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String) {
            if (((String) object).length() == 0) {
                return true;
            }
        }
        return false;
    }
}
