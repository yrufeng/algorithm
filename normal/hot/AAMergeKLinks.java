package hot;

import java.util.*;

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

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int value, ListNode next) {
//        this.val = value;
//        this.next = next;
//    }
//    ListNode(int[] arr) {
//        //
//    }
//}

public class AAMergeKLinks {
    public static void main(String[] args) {
        int[] arr1 = {1,2,4}, arr2 = {1,3,4,9};
        ListNode l1 = buildLink(arr1);
        ListNode l2 = buildLink(arr2);
        System.out.println("合并前l1: " + Arrays.toString(arr1));
        System.out.println("合并前l2: " + Arrays.toString(arr2));
        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        ListNode res = mergeKLinks(lists);

        System.out.println("合并后：");
        // 返回的是虚拟节点
        ListNode p = res.next;
        while (p != null) {
            System.out.print(p.val + " ,");
            p = p.next;
        }
    }

    private static ListNode mergeKLinks(List<ListNode> lists) {
        ListNode dummy = new ListNode(-1);
        // p 负责生成合并后链表
        ListNode p = dummy;

        if (lists.size() > 0) {
            if (lists.size() == 1) {
                return lists.get(0);
            }

            // 优先级队列，最小堆
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), Comparator.comparingInt(l -> l.val));

            for (ListNode list : lists) {
                if (list != null) {
                    pq.add(list);
                }
            }

            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                p.next = node;
                if (node.next != null) {
                    pq.add(node.next);
                }
                p = p.next;
            }
        }

        return dummy.next;
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
