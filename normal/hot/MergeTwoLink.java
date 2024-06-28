package hot;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }
    ListNode(int[] arr) {
        //
    }
}

public class MergeTwoLink {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4}, arr2 = {1,3,4};
        ListNode l1 = buildLink(arr1);
        ListNode l2 = buildLink(arr2);
        System.out.println("合并前l1: " + Arrays.toString(arr1));
        System.out.println("合并前l2: " + Arrays.toString(arr2));
        ListNode res = mergeTwoLinks(l1, l2);

        System.out.println("合并后：");
        // 返回的是虚拟节点
        ListNode p = res.next;
        while (p != null) {
            System.out.print(p.val + " ,");
            p = p.next;
        }
    }

    private static ListNode mergeTwoLinks(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2;
        // 用来形成新的链表
        ListNode p = dummy;
        while(p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p2;
                p2 = p2.next;
            }
        }

        while (p1 != null) {
            p.next = p1;
            p = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            p.next = p2;
            p = p2;
            p2 = p2.next;
        }

        return dummy;
    }

    private static ListNode buildLink(int[] arr) {
        ListNode head = new ListNode(Integer.MAX_VALUE);
        ListNode p = head;
        for (int i = 0; i < arr.length; i ++) {
            p.next = new ListNode(arr[i]);
            p = p.next;
        }

        return head.next;
    }
}
