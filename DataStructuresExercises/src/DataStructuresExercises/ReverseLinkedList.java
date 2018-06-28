package DataStructuresExercises;

import java.util.Stack;

public class ReverseLinkedList {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        reverseList(a1);

        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }

    public static void reverseList(ListNode head){


        while (head != null){
            stack.push(head.val);
            head = head.next;
        }

    }


}

class ListNode{
    int val;
    ListNode next;

    ListNode(int x){
        val = x;
    }
}