package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:49 2019/7/2
 */
public class Solution {
    public static void main(String[] args) {
        String str = "abc";
        Permutation(str);
    }

    public static ArrayList<String> Permutation(String str) {

        ArrayList<String> list = new ArrayList<>();
        permutation(str.toCharArray(),0,str.length() - 1,list);
        Collections.sort(list);
        return list;
    }

    public static void permutation(char[] s,int from,int to,ArrayList<String> list) {
        if(from == to) {
            //System.out.println(s);
            if(!list.contains(String.valueOf(s)))
                list.add(String.valueOf(s));
        }
        else {
            for(int i=from; i<=to; i++) {
                swap(s,i,from); //交换前缀，使其产生下一个前缀
                permutation(s, from+1, to,list);
                swap(s,from,i); //将前缀换回，继续做上一个前缀的排列
            }
        }
        if(to < 1)
            return;
    }

    public static void swap(char[] s,int i,int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }



    @Test
    public void test1(){
        int nums1[] = {1,2};
        int nums2[] = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    // 构建两个堆   大根堆   小根堆
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(50,
            new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return o2-o1;
                }
            });

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0){
            return 0;
        }

        numbersIntoHeap(nums1,0,nums1.length - 1);
        numbersIntoHeap(nums2,nums1.length,nums1.length + nums2.length - 1);

        // 判断两个数组中元素个数是奇数还是偶数个
        int length = nums1.length + nums2.length;
        if (tagIsEven(length)){
            return (Double.valueOf(maxHeap.peek())+Double.valueOf(minHeap.peek()))/2;
        }
        return maxHeap.peek();

    }


    // 分别将数组中的元素放入堆中
    private void numbersIntoHeap(int[] numbers,int start, int end){
        // 依次将两个数组中的值放入堆中
        // 下标是偶数放入大根堆--先在小根堆中筛选
        // 下标是奇数放入小根堆中--先在大根堆中筛选
        for (int i = start; i <= end; i++){
            // 下标是偶数，目标放入大根堆，首先放入小根堆筛选
            if (tagIsEven(i)){
                minHeap.offer(numbers[i-start]);
                maxHeap.offer(minHeap.poll());
            }else {
                // 下标是奇数，目标放入小根堆，首先放入大根堆中筛选
                maxHeap.offer(numbers[i-start]);
                minHeap.offer(maxHeap.poll());
            }
        }
    }

    // 判断下标是否是偶数
    private boolean tagIsEven(int tag){
        if (tag % 2 == 0){
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        String s = "noon";
       // System.out.println(getMaxLen(s));

        String s1 = "afternoabaon";
        System.out.println(longestPalindrome(s1));
    }

    /**
     *     求最长回文字符串的长度
     */
    public int getMaxLen(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int max = 0;
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            // i看成是中心元素，然后i-j是左边，i+j是右边元素，比较这两个元素是否相等
            for (int j = 0; i - j >= 0 && i + j < str.length(); j++) {
                // 比较左右对称的元素是否相等，此时i固定，j在增加
                if (charArr[i + j] != charArr[i - j]) {
                    // 直到不相等，回文结束，此时回文长度为2*j+1
                    break;
                }
                len = 2 * j + 1;
            }
            // 如果len的值大于最大记录的回文长度，更新最大记录
            max = max > len ? max : len;
            // 同理在偶数长度时，回文长度为2*j+2
            for (int j = 0; i - j >= 0 && i + j + 1 < str.length(); j++) {
                if (charArr[i + j + 1] != charArr[i - j]) {
                    break;
                }
                len = 2 * j + 2;
            }
            max = max > len ? max : len;
        }
        return max;
    }


    /**
     * 最长的回文字符串长度
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palinLength(s, i, i);
            String s2 = palinLength(s, i, i + 1);
            String longer = s1.length() > s2.length() ? s1 : s2;
            longest = longer.length() > longest.length() ? longer : longest;
        }
        return longest;
    }

    public String palinLength(String s, int start, int end) {
        int i = start;
        int j = end;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            i = start;
            j = end;
            start--;
            end++;
        }
        return (j < s.length() && s.charAt(i) == s.charAt(j)) ? s.substring(i, j + 1) : "";
    }

    @Test
    public void reverseTest(){
        int x = 1234567899;
        System.out.println(reverse(x));
    }

    public int reverse(int x) {
       /* StringBuilder sb = new StringBuilder();
        long result = 0L;
        char[] numChar = String.valueOf(x).toCharArray();
        for (int i = numChar.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (numChar[i] == '+' || numChar[i] == '-') {
                    sb.insert(0, numChar[i]);
                } else {
                    sb.append(numChar[i]);
                }
                result = Long.valueOf(sb.toString());
            }
                if (numChar[i] >= '0' && numChar[i] <= '9') {
                    sb.append(numChar[i]);
                } else {
                    result = Long.valueOf(sb.toString());
                }
            }
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            } else {
                return Integer.valueOf(String.valueOf(result));
            }
        }*/

        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }
        int reverse=0,prev;
        while(x > 0){
            prev = reverse;
            reverse = reverse * 10 + x % 10;
            x = x /10;
            // 当 reverse 的大小超过 Integer的范围时，
            // reverse 不能正常表示为一个Integer类型的数据，因此 pre != reverse/10
            if(prev !=reverse/10){
                return 0;
            }
        }
        if(negative) {
            return -reverse;
        }
        return reverse;
    }

    @Test
    public void isPalindrome(){
        int x = 121;
        System.out.println(isPalindrome(x));
    }


    // 只需要反转数字的顺序判断两者是否相等就可以了
    public boolean isPalindrome(int x) {
        boolean result = false;
        int reverseNumber = 0;
        int tempX = x;
        if (tempX >= 0){
            while (tempX > 0){
                int a = tempX % 10;
                reverseNumber = reverseNumber*10 + a;
                tempX = tempX/10;
            }
        }
        // reverseNumber本来就是int类型的，不用担心它越界
        if (reverseNumber == x){
            result = true;
        }
        return result;
    }



    @Test
    public void isMatch(){
        String s = "";
        String p = ".*";
        System.out.println(isMatch(s,p));
    }

    /**
     * 正则表达式匹配
     * @param s 可以为空  可以包含小写字母a~z
     * @param p 可以包含小写字母a~z 以及  . *
     * @return
     */
    int indexOfS = 0, indexOfP = 0;
    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0){
            return true;
        }

        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();

        return isMatch(ss,pp,indexOfS,indexOfP);
    }

    private boolean isMatch(char[] ss, char[] pp, int indexOfS, int indexOfP) {
        if (indexOfS == ss.length && indexOfP == pp.length){
            return true;
        }

        if (indexOfS < ss.length && indexOfP == pp.length){
            return false;
        }

        // 模式串的下一个字符是*
            // 1.s当前字符匹配p当前字符
            // 2.p当前字符是.可以匹配s中任意字符
        if (indexOfP + 1 < pp.length && pp[indexOfP+1] == '*'){
            if (indexOfS < ss.length &&
                    (ss[indexOfS] == pp[indexOfP] || pp[indexOfP] == '.')){
                return (isMatch(ss,pp,indexOfS,indexOfP+2) ||
                        isMatch(ss,pp,indexOfS+1,indexOfP+2) ||
                        isMatch(ss,pp,indexOfS+1,indexOfP));

            }else {
                // p后一个字符为* p和s不匹配，p当前字符也不是. s*当做0个
                return isMatch(ss,pp,indexOfS,indexOfP+2);
            }
        }

        // 此处不能限定 indexOfP+1 < pp.length 若indexOfP==pp.length-1时，就走不进这个条件判断了
        // 模式串的下一个字符不是* s当前字符匹配p当前字符/p当前字符是.
        if (indexOfS < ss.length && (ss[indexOfS] == pp[indexOfP] ||
                ((indexOfP < pp.length && pp[indexOfP] == '.')))){
            return isMatch(ss,pp,indexOfS+1,indexOfP+1);
        }
        return false;
    }


}

