package DataStructuresExercises.MergeTwoSortedLists;

import java.util.*;

public class MainMergeTwoSortedLists {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        LinkedList<Integer> adj = new LinkedList<>();
        PriorityQueue<Integer> add = new PriorityQueue<>();
        add.add(2);
        Set<String> sdsd = new HashSet<>();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(2);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        print(Solution.mergeTwoLists(a1,b1));
    }

    private static void print(ListNode listNode) {
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);
            ListNode node = result;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    node.next = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    node.next = new ListNode(l2.val);
                    l2 = l2.next;
                }
                node = node.next;
            }

            while (l1 != null) {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
                node = node.next;
            }

            while (l2 != null) {
                node.next = new ListNode(l2.val);
                l2 = l2.next;
                node = node.next;
            }

            return node;
        }
    }
}
