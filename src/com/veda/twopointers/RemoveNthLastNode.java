package com.veda.twopointers;
import java.util.*;

public class RemoveNthLastNode {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode left = head, right = head;

        for(int i = 1; i <= n; i++) {
            right = right.next;
        }

        if(right == null) return left.next;

        while(right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
        
        return head;
    }
}
