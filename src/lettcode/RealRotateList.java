package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *  * Input: 1->2->3->4->5->NULL, k = 2
 *  * Output: 4->5->1->2->3->NULL
 *  * Explanation:
 *  * rotate 1 steps to the right: 5->1->2->3->4->NULL
 *  * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *  之前的做法没看清题意
 * @Date: Created in 20:30 2019/8/22
 */
public class RealRotateList {

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

        int k = 5;
        ListNode listNode = rotateRight(one, k);
        while (listNode != null) {
            System.out.print(listNode.val+"  ");
            listNode = listNode.next;
        }

    }

    // 首先找到旋转的节点在哪里

    /**
     * 需要注意的点：
     * 1.旋转位置的判断   因为是从尾部开始旋转  所以旋转的下标定位是  length - k
     * 2.旋转的位置是链表的尾部   这时的next为空
     * 3.如果next为空，显得头结点就是原始的头结点
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        // 旋转节点的下标
        int length = getListLength(head);
        // 是从后面开始转的，所以新头部的位置是  长度-1-k
        int index = length - 1 - (k % length);
        // index的下一个就是新的头部
        ListNode tempHead = head;
        for (int i = 0; i < index; i++) {
            tempHead = tempHead.next;
        }

        ListNode newHead = tempHead;
        // 可能断开的位置是链表的尾部，这时的next为空，需要判断，不然会引起空指针异常
        if (tempHead.next != null) {
            newHead = tempHead.next;

            tempHead.next = null;

            ListNode tempNewHead = newHead;
            while (tempNewHead.next != null) {
                tempNewHead = tempNewHead.next;
            }
            tempNewHead.next = head;

            // 注意：当新的头结点是最后一个节点的时候，新的头结点就是最原始头结点
        } else {
            newHead = head;
        }
        return newHead;
    }

    private int getListLength (ListNode head) {
        int length = 0;
        ListNode tempNode = head;
        while (tempNode != null) {
            length ++;
            tempNode = tempNode.next;
        }
        return length;
    }
}
