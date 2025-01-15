package com.veda.fastnslowpointers;

public class HappyNumber {
    public static boolean isHappyNumber(int n) {
        if(n == 1) return true;
        int slow = n, fast = square(n);
        if(fast == 1) return true;
        while(fast != slow && fast != 1) {
            slow = square(slow);
            fast = square(fast);
            if(fast == 1 || slow == 1) return true;
            fast = square(fast);
        }
        if(fast == 1) return true;
        else return false;
    }

    static int square(int num) {
        int sum = 0;
        while(num != 0) {
            int remainder = num % 10;
            sum += (remainder*remainder);
            num = num / 10;
        }
        return sum;
    }
}