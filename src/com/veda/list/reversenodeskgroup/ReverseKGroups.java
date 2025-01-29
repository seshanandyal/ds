package com.veda.list.reversenodeskgroup;

// Definition for a Linked List node

// class LinkedListNode {
//     public int data;
//     public LinkedListNode next;
//     public LinkedListNode(int data) {
//         this.data = data;
//         this.next = null;
//     }
// }

import java.util.*;

public class ReverseKGroups{
    public static LinkedListNode reverseKGroups(LinkedListNode head, int k) {
        LinkedListNode current = head;
        int count = 0;
        while(current != null) {
            current = current.next;
            count++;
        }

        int groupCount = count / k;
        if(groupCount == 0) return head;

        current = head;
        LinkedListNode prev = null;
        LinkedListNode nextHead = current;
        for(int i = 1; i <= groupCount; i++) {
            for(int j = 0; j < k; j++) nextHead = nextHead.next;
            LinkedListNode tempHead = reverseList(current, k);

            if(i == 1) head = tempHead;
            else {
                prev.next = tempHead;
            }
            current.next = nextHead;
            prev = current;
            current = nextHead;
        }
        return head;
    }

    private static LinkedListNode reverseList(LinkedListNode head,
                                              int k) {
        LinkedListNode current = head, prev = null, next = null;

        int count = 1;
        while(count <= k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        return prev;
    }
}