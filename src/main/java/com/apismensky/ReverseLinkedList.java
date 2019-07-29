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

    /**
     * While you are traversing the list, change the current node's next pointer to point to its previous element.
     * Since a node does not have reference to its previous node, you must store its previous element beforehand.
     * You also need another pointer to store the next node before changing the reference.
     * Do not forget to return the new head reference at the end!
     */
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

    public static void main(String[] args) {
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
