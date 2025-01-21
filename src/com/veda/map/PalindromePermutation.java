package com.veda.map;
import java.util.*;
public class PalindromePermutation {
    public static boolean permutePalindrome(String st) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch: st.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;
        for(char ch: map.keySet()) {
            if(map.get(ch) % 2 != 0) count++;
            if(count > 1) return false;
        }
        return true;
    }
}