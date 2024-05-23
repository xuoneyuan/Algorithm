import java.util.Scanner;

/**
 * Definition for singly-linked list.
 */


public class isPalindrome {

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

        // 处理链表，判断是否为回文
        boolean result = isPalindrome(head);

        // 输出结果
        System.out.println(result ? "true" : "false");

        sc.close();
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 找到链表中点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转后半部分链表
        ListNode secondHalf = reverseList(slow);
        ListNode firstHalf = head;

        // 比较前半部分和后半部分
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}
