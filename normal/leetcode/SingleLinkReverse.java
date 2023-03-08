package leetcode;

/**
 * 单链表逆置：http://c.biancheng.net/view/8105.html
 */

public class SingleLinkReverse {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Node link = initLink(arr);
        System.out.println("初始化链表后，打印:");
        Node temp = link;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println("\n逆置-就地逆转:");
        Node reverseLink = reverseByLoop(link);
        while(reverseLink != null) {
            System.out.print(reverseLink.data + " ");
            reverseLink = reverseLink.next;
        }

        Node link2 = initLink(arr);
        System.out.println("\n初始化链表后，打印:");
        Node temp2 = link2;
        while(temp2 != null) {
            System.out.print(temp2.data + " ");
            temp2 = temp2.next;
        }

        Node headInsertLink = headInsert(link2);
        System.out.println("\n逆置-头插法逆转:");
        while (headInsertLink != null) {
            System.out.print(headInsertLink.data + " ");
            headInsertLink = headInsertLink.next;
        }
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node reverseByLoop(Node head) { // 就地反转
        if (head == null || head.next == null) {
            return head;
        }

        Node pre = head;
        Node next = head.next;
        while (next != null) {
            pre.next = next.next;

            //next.next = pre; // 这句指向有问题
            next.next = head;

            head = next;
            next = pre.next;
        }
        return head;
    }

    /**
     * 所谓头插法，是指在原有链表的基础上，依次将位于链表头部的节点摘下，然后采用从头部插入的方式生成一个新链表，则此链表即为原链表的反转版
     * @param head
     * @return
     */
    static Node headInsert(Node head) { // 头插法反转
        if (head == null || head.next == null) return head;

        Node newHead = null;
        while (head != null) {
            Node copy = head;
            head = head.next;
            copy.next = newHead;
            newHead = copy;
        }

        return newHead;
    }

    static Node initLink(int[] arr) {
        if (arr.length <= 0) return null;

        Node head = new Node(arr[0]);
        Node pre = head;
        Node cur;
        for (int i = 1; i < arr.length; i ++) {
            cur = new Node(arr[i]);
            pre.next = cur;
            pre = cur;
        }

        return head;
    }
}
