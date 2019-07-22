package com.apismensky;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Find Nth element from the last in the single linked list
 */
public class LinkedListNth {
    private static class Node {
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        int val;
        Node next;

        @Override
        public String toString() {
            return "[" + val + "]";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node)o;
            return val == node.val &&
                   Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    // 2nd from the end

    // Fast and slow pointers
    // Start moving slow pointer after skipping num nodes
    public static Node find(Node head, int num) {
        Node curr = head;
        Node slow = head;
        int count = 0;

        while(curr != null) {
            if (count > num) {
                slow = slow.next;
            }
            curr = curr.next;
            count++;
        }
        return slow;
    }

    /**
     * Print Nth element from the last in the single linked list
     * @return Node n-th from the last
     *
     *     111 -> 112 -> 113 -> null
     index         2   ->  1   ->  0
     */
    public static int printNodeRecursive(Node head, int num) {
        if (head == null) {
            return 0;
        }

        int index = printNodeRecursive(head, num) + 1;
        if (index == num) {
            System.out.println("Node: " + head);
        }
        return index;
    }

    public static boolean isLoop(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = null;
        int count = 0;
        while (fast != null) {

            if (fast.equals(slow)) {
                return true;
            }
            fast = fast.next;
            if (count%2==0) {
                slow = slow == null ? head : slow.next;
            }
            count++;
        }
        return false;
    }

    public static void removeDups(Node head) {
       Set<Integer> nodeSet = new HashSet<>();
       Node prev = head;
        while (head!=null) {
            if (!nodeSet.contains(head.val)) {
                nodeSet.add(head.val);
            }
            else {
                prev.next = head.next;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void prn(Node head) {
       while (head!=null) {
           System.out.print(head);
           if (head.next!=null) {
               System.out.print("->");
           }
           head = head.next;
       }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);

        Node n4 = new Node(4, n3);
        Node n5 = new Node(5, n4);
        Node n3dup = new Node(3, n5);
        Node n6 = new Node(6, n3dup);
        Node n7 = new Node(7, n6);

        Node n5dup = new Node(5, n7);
        Node n8 = new Node(7, n5dup);

        prn(n8);
        removeDups(n8);
        prn(n8);
    }

}
