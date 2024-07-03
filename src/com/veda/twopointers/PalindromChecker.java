package com.veda.twopointers;
import java.util.*;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
       int left = 0, right = s.length() - 1;
       while(left < right) {
           if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
       }
       return true;
    }
}
