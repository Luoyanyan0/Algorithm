package offer.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 10:38
 * @Description:输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class printListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> tailToHead = new ArrayList<>();
        while (listNode != null){
            tailToHead.add(0,listNode.val);
            listNode = listNode.next;
        }
        return tailToHead;
    }
}
