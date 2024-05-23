import java.util.Scanner;

/**
 * Definition for singly-linked list.
 * 2. Add Two Numbers
 */


public class addTwoNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取第一个链表
        ListNode dummy1 = new ListNode(0);
        ListNode tail1 = dummy1;
        String[] nums1 = sc.nextLine().split(" ");
        for (String num : nums1) {
            tail1.next = new ListNode(Integer.parseInt(num));
            tail1 = tail1.next;
        }
        ListNode l1 = dummy1.next;

        // 读取第二个链表
        ListNode dummy2 = new ListNode(0);
        ListNode tail2 = dummy2;
        String[] nums2 = sc.nextLine().split(" ");
        for (String num : nums2) {
            tail2.next = new ListNode(Integer.parseInt(num));
            tail2 = tail2.next;
        }
        ListNode l2 = dummy2.next;

        // 计算两数相加
        ListNode result = addTwoNumbers(l1, l2);

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
