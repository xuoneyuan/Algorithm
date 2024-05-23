import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */


public class rotateRight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取链表
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        String[] nums = sc.nextLine().split(" ");
        for (String num : nums) {
            tail.next = new ListNode(Integer.parseInt(num));
            tail = tail.next;
        }
        ListNode head = dummy.next;

        // 读取旋转步数k
        int k = sc.nextInt();

        // 旋转链表
        ListNode result = rotateRight(head, k);

        // 输出结果
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" ");
            }
            curr = curr.next;
        }

        sc.close();
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 计算链表长度
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 计算旋转步数
        k %= length;
        if (k == 0) {
            return head;
        }

        // 形成环形链表
        tail.next = head;

        // 找到新的尾节点
        for (int i = 0; i < length - k; i++) {
            tail = tail.next;
        }

        // 断开环形链表
        ListNode newHead = tail.next;
        tail.next = null;

        return newHead;
    }
}
