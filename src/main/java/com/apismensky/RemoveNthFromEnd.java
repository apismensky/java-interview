package com.apismensky;

import java.util.Objects;

public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override public String toString() {
            return "ListNode{" +
                   "val=" + val +
                   '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ListNode listNode = (ListNode)o;
            return val == listNode.val;
        }

        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode slow = head;
        ListNode prev = head;
        int count = 0;
        while (current != null) {
            count++;
            if (count > n) {
                prev = slow;
                slow = slow.next;
            }
            current = current.next;
        }
        // slow is pointing to the n-th element from the last
        prev.next = slow.next;
        return head;
    }
}
