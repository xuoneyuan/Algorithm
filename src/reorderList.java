import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */


public class reorderList {

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

        // 重新排序链表
        reorderList(head);

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

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // 使用快慢指针找到链表的中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode headn = null, next = slow.next;
        slow.next = null;
        slow = next;
        while (slow != null) {
            next = slow.next;
            slow.next = headn;
            headn = slow;
            slow = next;
        }

        // 合并两个子链表
        ListNode cur = head;
        ListNode curn = headn;
        while (cur != null && curn != null) {
            next = cur.next;
            cur.next = curn;
            curn = curn.next;
            cur.next.next = next;
            cur = next;
        }
    }
}
