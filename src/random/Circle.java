package random;


public class Circle {

    public static void main(String[] args) {

    }
    //1.确定链表中是否存在环
    //2.设置快慢指针找到两个指针相遇的位置(一定在环中)
    //3.重新设置快慢指针，

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        // 判断连表是否为空
        if (pHead == null){
            return null;
        }

        // 判断链表中是否存在环
        ListNode circle = ifExistCircle(pHead);
        if (circle == null){
            return null;
        }

        // circle即为环中的节点，设置快慢指针，快的先走到circle的位置
        ListNode newPFast = pHead;
        ListNode newPSlow = pHead;
        while (newPFast != circle){
            newPFast = newPFast.m_pNext;
        }
        while (newPFast != newPSlow){
            newPFast = newPFast.m_pNext;
            newPSlow = newPSlow.m_pNext;
        }
        return newPFast;
    }

    private ListNode ifExistCircle(ListNode pHead){
        ListNode pFast = pHead;
        ListNode pSlow = pHead;

        for (int i = 0; i < 2; i++){
            if(pFast.m_pNext != null){
                pFast = pFast.m_pNext;
            }else{
                return null;
            }
        }
        pSlow = pSlow.m_pNext;

        while (pFast != pSlow){
            if (pFast.m_pNext != null){
                pFast = pFast.m_pNext.m_pNext;
                pSlow = pSlow.m_pNext;
            }else {
                return null;
            }
        }
        return pFast;
    }
}
