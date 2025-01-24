package com.veda.binarysearch;
import java.util.*;
public class RotatedSortedArraySearcher {
    public static int binarySearchRotated(List<Integer> nums, int target) {

        // Replace this placeholder return statement with your code

        return search(nums, 0, nums.size()-1, target);
    }

    static int search(List<Integer> nums, int left, int right,
                      int target) {
        if(left > right) return -1;
        int mid = (left + right) / 2;
        if(nums.get(mid) == target) return mid;
        if (nums.get(left) <= nums.get(mid)) {
            if (nums.get(left) <= target && target < nums.get(mid)) {
                return search(nums, left, mid - 1, target);
            }
            return search(nums, mid + 1, right, target);
        } else {
            if (nums.get(mid) < target && target <= nums.get(right)) {
                return search(nums, mid + 1, right, target);
            }
            return search(nums, left, mid - 1, target);
        }

    }

}