package test;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:48 2019/8/4
 */
public class SwapPair {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = null;

        ListNode head = one;
        ListNode node = swapPairsII(head);
        while (node != null){
            System.out.print(node.val+"->");
            node = node.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node = null;
        if (head == null){
            return node;
        }
        ListNode finalNode = node;
        ListNode odd = head;
        while (odd != null){
            ListNode even = odd.next;
            if (node == null){
                node = even;
                finalNode = node;
            } else {
                node.next = even;
                node = node.next;
            }
            ListNode temp = odd;
            temp.next = null;
            odd = even.next;
            even.next = temp;

            node = node.next;
        }
        return finalNode;
    }

    public static ListNode swapPairsII(ListNode head) {
        ListNode Head = new ListNode(0);
        Head.next = head;
        ListNode p = Head;
        while(p.next != null && p.next.next != null){
            ListNode m = p.next;
            ListNode n = p.next.next;
            ListNode t = p.next.next.next;
            p.next = n;
            n.next = m;
            m.next = t;
            p = m;
        }
        return Head.next;
    }


    @Test
    public void removeDuplicates(){
        int nums[] = {0,0,1,1,1,2,2};
        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++){
            if (nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    @Test
    public void removeElement(){
        int nums[] = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums,2));
    }

    public int removeElement(int[] nums, int val) {
      int i = 0;
      for (int j = 0; j < nums.length; j++){
          if (nums[j] != val){
              nums[i] = nums[j];
              i++;
          }
      }
      return i;
    }

}
