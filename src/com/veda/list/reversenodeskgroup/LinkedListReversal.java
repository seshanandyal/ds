package com.veda.list.reversenodeskgroup;

class LinkedListReversal{
    static LinkedListNode[] reverseLinkedList(LinkedListNode node, int k){

        LinkedListNode previous = null;
        LinkedListNode current = node;
        LinkedListNode next = null;

        for (int i = 0; i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return new LinkedListNode[]{previous, current};
    }
}