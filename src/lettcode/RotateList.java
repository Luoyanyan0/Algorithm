package lettcode;


import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * @Date: Created in 19:29 2019/8/22
 */
public class RotateList {

    @Test
    public void rotateRight() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        int k = 2;
        ListNode listNode = rotateRight(one, k);
        while (listNode != null) {
            System.out.print(listNode.val+"  ");
            listNode = listNode.next;
        }

    }

    public ListNode rotateRight(ListNode head, int k) {
        // 先确定k是否大于链表的长度
        int length = getListLength(head);
        if (k >= length - 1) {
            return head;
        }

        ListNode tempNode = head;
        for (int i = 0; i < k; i++) {
            tempNode = tempNode.next;
        }
        ListNode newHead = tempNode.next;
        tempNode.next = null;


        // 找到尾结点
        ListNode tempNewHead = newHead;
        while (tempNewHead.next != null) {
            tempNewHead = tempNewHead.next;
        }
        tempNewHead.next = head;
        return newHead;

    }

    private int getListLength(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length ++;
            temp = temp.next;
        }
        return length;
    }
}
