import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */


public class removeNthFromEnd {

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

        // 读取n值
        int n = sc.nextInt();

        // 移除链表的倒数第n个节点
        ListNode result = removeNthFromEnd(head, n);

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
}
