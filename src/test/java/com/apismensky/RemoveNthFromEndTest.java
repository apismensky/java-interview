package com.apismensky;

import static com.apismensky.RemoveNthFromEnd.removeNthFromEnd;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.apismensky.RemoveNthFromEnd.ListNode;
import org.junit.Ignore;
import org.junit.Test;

public class RemoveNthFromEndTest {

    @Test
    @Ignore
    public void test1() {
        ListNode node = new ListNode(1);
        assertNull(removeNthFromEnd(node, 1));
    }

    @Test
    @Ignore
    public void test2() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode node = removeNthFromEnd(n1, 2);
        assertEquals(n2, node);
    }

    @Test
    @Ignore
    public void test3() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        ListNode n4 = new ListNode(4);
        n3.next = n4;
        ListNode n5 = new ListNode(5);
        n4.next = n5;
        ListNode node = removeNthFromEnd(n1, 2);
        assertEquals(n2, node);
    }
}
