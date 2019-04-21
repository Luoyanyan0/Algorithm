package random;

/**
 * 删除链表中的结点
 */
public class DeleteNode {
    /**
     * 特殊情况：
     * 删除的是尾部的结点
     * 链表只有一个节点
     * @param pHead
     * @param pToBeDeleted
     */
    public void deleteNode(ListNode pHead, ListNode pToBeDeleted){
        // 判空
        if (pHead == null || pToBeDeleted == null){
            return;
        }

        // 链表只有一个结点，删除节点后将头指针赋为空
        if (pToBeDeleted == pHead){
            pHead = null;
            pToBeDeleted = null;
        } else if (pToBeDeleted.m_pNext != null){
            // 删除的结点不是尾结点
            // 将待删除结点下一个节点的值赋给待删除的结点
            pToBeDeleted.m_nValue = pToBeDeleted.m_pNext.m_nValue;
            pToBeDeleted.m_pNext = pToBeDeleted.m_pNext.m_pNext;

        }else {
        // 删除的结点是尾结点
        // 从头结点开始遍历
            ListNode pTemp = pHead;
            while (pTemp.m_pNext != pToBeDeleted){
                pTemp = pTemp.m_pNext;
            }

            pTemp.m_pNext = null;
            pToBeDeleted = null;
        }
    }
}
