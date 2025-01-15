package com.veda.fastnslowpointers;
import java.util.*;
public class CircularArrayLoop {
    public static boolean circularArrayLoop(int[] nums) {
        if(nums.length == 1) return false;
        for (int i = 0; i < nums.length; i++) {
            int slow = i; int fast = i;
            int next = nextStep(nums, slow);
            if(next == slow) return false;
            while(true) {
                slow = nextStep(nums, slow);
                if(notCycle(nums, slow, fast)) break;
                fast = nextStep(nums, fast);
                if(notCycle(nums, slow, fast)) break;
                fast = nextStep(nums, fast);
                if(notCycle(nums, slow, fast)) break;
                if(fast == slow) return true;
            }
        }
        return false;
    }
    public static int nextStep(int[]nums, int index) {
        int result = (index + nums[index]) % nums.length;
        if (result < 0) result += nums.length;
        return result;
    }
    public static boolean notCycle(int[]nums, int slow, int fast) {
        if(fast == nums.length) return true;
        if((nums[slow] > 0 && nums[fast] < 0) || (nums[slow] < 0 && nums[fast] > 0)) return true;
        return false;
    }
}