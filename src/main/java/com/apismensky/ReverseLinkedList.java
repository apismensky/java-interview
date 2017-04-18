package com.apismensky;

/**
 * Reverse a singly linked list.
 * <p/>
 * <p/>
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseList(ListNode head) {
        traverse(head);
        ListNode prev = null;

        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }

        traverse(prev);
        return prev;
    }


    public static ListNode reverseListRec(ListNode head) {
       return traverseListRec(head, null);
    }


    public static ListNode traverseListRec(ListNode head, ListNode prev) {
        if (head == null) {
            System.out.println("null");
            return null;
        }

        ListNode nextTemp = head.next;
        head.next = prev;
        prev = head;
        head = nextTemp;

        //System.out.print(head.val + " -> ");
        return traverseListRec(head, prev);
    }

    public static void traverse(ListNode n) {
        while (n != null) {
            System.out.print(n.val);
            String a = " -> ";
            if (n.next == null)
                a += "none";
            System.out.print(a);
            n = n.next;
        }
        System.out.println();
    }


}
