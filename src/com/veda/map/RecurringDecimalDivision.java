package com.veda.map;
import java.util.*;
public class RecurringDecimalDivision {


    public static String fractionToDecimal (int numerator, int denominator) {
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new HashMap<>();

        if(numerator <0 ^ denominator <0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
            sb.append("-");
        }
        int quotient = numerator / denominator;
        int remainder = numerator % denominator;

        sb.append(quotient);
        if(remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        while(remainder != 0) {
            if(map.containsKey(remainder)) {
                String leftPart = sb.substring(0, map.get(remainder));
                String rightPart = sb.substring(map.get(remainder));
                return leftPart + "(" + rightPart + ")";
            } else {
                map.put(remainder, sb.length());
                remainder = remainder * 10;
                quotient = remainder / denominator;
                remainder = remainder % denominator;
                sb.append(quotient);
            }
        }
        return sb.toString();
    }
}