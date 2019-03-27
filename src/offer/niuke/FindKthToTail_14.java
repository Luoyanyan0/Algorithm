package offer.niuke;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthToTail_14 {
    /**
     * 设快慢指针。一个先走length - k 步，一个从头走起
     * 当快指针走到链表结尾的时候，慢指针指向的就是倒数的第k个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        // 先求出链表的长度
        int length = 0;
        ListNode node = head;
        while (node != null){
            length ++;
            node = node.next;
        }

        // 判空  或者k值大于链表长度
        if (head == null || (head != null && k > length)){
            return null;
        }

        // 两个快慢指针
        ListNode pLow = head;
        ListNode pFast = head;
        // 快指针先向前走k步
        for (int i = 0; i < k; i++){
            pFast = pFast.next;
        }
        // 然后两个指针一起走，知道快指针走到链表结束的位置
        while (pFast != null){
            pFast = pFast.next;
            pLow = pLow.next;
        }
        return pLow;
    }
}
