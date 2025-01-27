package com.veda.list.linkedlistreversal;
import java.util.*;
public class LinkedListReversal {
// Definition for a Linked List node

// class LinkedListNode {
//     public int data;
//     public LinkedListNode next;
//     public LinkedListNode(int data) {
//         this.data = data;
//         this.next = null;
//     }
// }
    public static LinkedListNode reverse(LinkedListNode head) {
        LinkedListNode prev = null, current = head, next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }
}