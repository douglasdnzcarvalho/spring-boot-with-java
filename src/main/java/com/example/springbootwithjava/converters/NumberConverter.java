package com.example.springbootwithjava.converters;

public class NumberConverter {
    public static boolean isNumeric(String numberAsString) {
        return (numberAsString != null) && numberAsString.matches("[-+]?(\\d+)((.|,)\\d+)?");
    }

    public static Double convertToDouble(String numberAsString) {
        String fixedNumber = numberAsString.replaceAll(",", ".");
        return Double.parseDouble(fixedNumber);
    }
}
