/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

import java.util.Scanner;

public class oddEvenList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取链表
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (sc.hasNextInt()) {
            tail.next = new ListNode(sc.nextInt());
            tail = tail.next;
        }

        ListNode head = dummy.next;

        // 处理链表
        head = oddEvenList(head);

        // 输出结果
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" ");
            }
            curr = curr.next;
        }
        sc.close();
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode evenHead = head.next; // Head of the even indexed nodes
        ListNode odd = head; // Pointer to the current odd indexed node
        ListNode even = evenHead; // Pointer to the current even indexed node

        while (even != null && even.next != null) {
            odd.next = even.next; // Link odd nodes together
            odd = odd.next; // Move to the next odd node
            even.next = odd.next; // Link even nodes together
            even = even.next; // Move to the next even node
        }

        odd.next = evenHead; // Append the even nodes after the odd nodes
        return head;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
