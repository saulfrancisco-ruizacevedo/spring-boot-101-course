package com.dartrox.course.springboot.service.demo.util;

import java.util.Objects;

public class StringUtils {

    /**
     * Method to concatenate strings with a comma, avoiding a comma at the beginning or end.
     * @param currentString The current string, which may be empty or have a value.
     * @param newString The new string to add.
     * @return The concatenated string with a comma, if not empty.
     */
    public static String concatenateWithComma(String currentString, String newString) {
        if (Objects.isNull(currentString) || currentString.isEmpty()) {
            return newString;
        }

        return currentString + ", " + newString;
    }
}
