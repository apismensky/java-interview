package com.apismensky;

import org.junit.Test;

public class ReverseLinkedListTest {
    @Test
    public void test1() {

        ReverseLinkedList.ListNode n1 = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode n2 = new ReverseLinkedList.ListNode(2);
        ReverseLinkedList.ListNode n3 = new ReverseLinkedList.ListNode(3);
        ReverseLinkedList.ListNode n4 = new ReverseLinkedList.ListNode(4);

        // n1 -> n2 -> n3 -> n4 -> null
        // n1, prev = null
        // n2 ,prev = n1, n2.next = n1, n1.next = null, prev = n2
        // n3, prev = n2, n3.next = n2, n2.next = n1;
        //

        // n4 -> n3 -> n2 -> n1 -> null

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ReverseLinkedList.ListNode listNode = ReverseLinkedList.reverseList(n1);

        ReverseLinkedList.ListNode reverseListRec = ReverseLinkedList.reverseListRec(listNode);
        ReverseLinkedList.traverse(reverseListRec);

    }
}
