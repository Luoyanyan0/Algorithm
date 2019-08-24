package test;

import org.junit.Test;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {

    synchronized void setA() throws Exception{
        Thread.sleep(1000);
        System.out.println("A");
        setB();
    }

    synchronized void setB() throws Exception{
        Thread.sleep(1000);
        System.out.println("B");
    }

    @Test
    public void test1() {
        try {
            setA();
            setB();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countSum(){
        int row = 325;
        int col = 255;
        int countSum = 0;
        while (row > 0){
            countSum += row % 10;
            row = row / 10;
        }
        while (col > 0){
            countSum += col % 10;
            col = col / 10;
        }
        System.out.println(countSum);
    }


    @Test
    public void test(){
        /*Father son = new Son();
        System.out.println(son.a);*/
        String str = "abc";
        char[] array = str.toCharArray();
        System.out.println(String.valueOf(array));

    }


    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean isPopOrder = false;
        Stack<Integer> popStack = new Stack<>();
        // 判断数组中是否有元素
        if (pushA.length > 0 && popA.length > 0 && pushA.length == popA.length) {
            // i j   pushA popA
            int i = 0, j = 0;
            // 这里要使用popA，使用pushA把所有元素放进去后就进不去循环了
            while (j < popA.length) {
                // 栈空/栈顶元素不等于弹出序列元素   压栈
                if (popStack.isEmpty() || popStack.peek() != popA[j]){
                    if (i >= pushA.length){
                        return isPopOrder;
                    }
                    popStack.push(pushA[i]);
                    i++;
                }else {
                    // 栈顶元素等于弹出元素   弹出栈顶元素  popA后移
                    popStack.pop();
                    j++;
                }
            }
            if (j == popA.length){
                isPopOrder = true ;
            }
        }
        return isPopOrder;
    }



        // 递归，数组的最后一个元素就是根，根据数组中数字的大小区分左右子树
        public boolean VerifySquenceOfBST(int [] sequence) {
            if (sequence.length <= 0){
                return false;
            }
            return VerifySquenceOfBST(sequence,0,sequence.length);

        }

        private boolean VerifySquenceOfBST(int [] sequence,int start,int length){
            // 确定根节点的值
            int root = sequence[length - 1];
            // 根据根区分左右子树
            int i  = 0;
            for (; i < length - 1;i++){
                // 当sequence中的值大于根节点的值，属于右子树
                if (sequence[i] > root){
                    break;
                }
            }

            int j = i;
            for (; j < length - 1; j++){
                // 右子树序列中出现了小于根节点的值，说明序列不对
                if (sequence[j] < root){
                    return false;
                }
            }

            boolean left = true;
            boolean right = true;
            // 说明有左子树
            if (i > 0){
                left = VerifySquenceOfBST(sequence,0,i);
            }
            // 说明存在右子树
            if (i < length - 1){
                // 长度记得减去根
                right = VerifySquenceOfBST(sequence,i,length - i - 1);
            }
            return left && right;
        }

        public void test3(){
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            list.add(new ArrayList<>(path));
        }

        @Test
        public void test4(){
        int count = 0;
            for (int i = 0; i <= 369; i++){
                count += String.valueOf(i).length();
            }
            System.out.println(count);
        }

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("["+threadInfo.getThreadId()+"]"+threadInfo.getThreadName());
        }
    }


    @Test
    public void test2(){
       /* String str = "abcde";
        System.out.println(ifContainDigit(str));*/

       String str = ".1";
        System.out.println(myAtoi(str));

    }

    String regx = ".*\\d+.*";
    public boolean ifContainDigit(String str){
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            return true;
        }
        return false;
    }


    public int myAtoi(String str) {
        if ("".equals(str)){
            return 0;
        }

        char[] strToChar = str.toCharArray();
        int index = firstNoWhiteSpace(strToChar);
        // 如果index等于-1,说明字符串中都是空格
        // 只接受第一个非空字符是数字或者符号 否则 返回0
        if (index == -1 ||
                (!isNumber(strToChar[index]) && !isMark(strToChar[index]))){
            return 0;
        }


        StringBuilder sb = new StringBuilder();
        sb.append(strToChar[index]);
        long result = 0;
        for (int i = index+1; i < strToChar.length; i++){
            // 超过int类型的最大或者最小范围
            if (isLessMin(result)){
                return Integer.MIN_VALUE;
            }else if (isMoreMax(result)){
                return Integer.MAX_VALUE;
            }

            // 3.1415 这种情况应该输入3   因此只要碰到非数字字符，即结束
            if (!isNumber(strToChar[i])){
                break;
            }else {
                sb.append(strToChar[i]);
                result = Long.valueOf(sb.toString());
            }

        }

        // 排除最后的结果只有一个符号的情况
        if (sb.length() == 0 || (sb.length() == 1 && (isMark(sb.charAt(0))))){
            return 0;
        }else if(isLessMin(result)){
            return Integer.MIN_VALUE;
        }else if(isMoreMax(result)){
            return Integer.MAX_VALUE;
        }

        return Integer.valueOf(sb.toString());
    }

    // 得到第一个不是空格的字符下标
    private int firstNoWhiteSpace(char[] strToChar){
        int index = -1;
        boolean firstNoWhiteSpace = false;
        for (int i = 0; i < strToChar.length; i++){
            // 记录第一个不为空字符的位置
            if (!firstNoWhiteSpace && strToChar[i] != ' '){
                firstNoWhiteSpace = true;
                index = i;
            }
        }
        return index;
    }

    // 判断一个字符是不是符号
    private boolean isMark(char s){
        return (s == '+' || s == '-');
    }

    // 判断一个字符是不是数字
    private boolean isNumber(char s){
        return (s >= '0' && s <= '9');
    }

    // 判断结果是否超出Integer范围
    private boolean isLessMin(long number){
        return (number < Integer.MIN_VALUE);
    }

    // 判断结果是否超出Integer范围
    private boolean isMoreMax(long number){
        return (number > Integer.MAX_VALUE);
    }








    @Test
    public void myAtoiII(){
        String str = "  -34";
        System.out.println(myAtoiII(str));
    }

    public int myAtoiII(String str) {
        int i = 0, answer = 0;
        boolean pos = true;
        for (; i < str.length() && str.charAt(i) == ' '; i++);
        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            if (str.charAt(i) == '-')
                pos = false;
            i++;
        }
        for (; i < str.length() && Character.isDigit(str.charAt(i)); i++) {
            int digit = str.charAt(i) - '0';
            if (pos) {
                if (answer > Integer.MAX_VALUE / 10)
                    return Integer.MAX_VALUE;
                answer *= 10;
                if (answer > Integer.MAX_VALUE - digit)
                    return Integer.MAX_VALUE;
                answer += digit;
            }
            else {
                if (-answer < Integer.MIN_VALUE / 10)
                    return Integer.MIN_VALUE;
                answer *= 10;
                if (-answer < Integer.MIN_VALUE + digit)
                    return Integer.MIN_VALUE;
                answer += digit;
            }
        }
        return pos ? answer : -answer;
    }



    @Test
    public void myAtoiIII(){
        String str = "  -42";
        System.out.println(myAtoiIII(str));
    }

    public int myAtoiIII(String str){
        int i = 0, j = 0, len = str.length();
        boolean negative = false;
        for (i = 0; i < len; i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                break;
            } else if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                negative = str.charAt(i) == '-';
                i++;
                break;
            } else if (str.charAt(i) != ' ') {
                return 0;
            }
        }
        for (j = i; j < len; j++) {
            if (str.charAt(j) < '0' || '9' < str.charAt(j)) {
                break;
            }
        }
        int ret = 0;
        String num = str.substring(i, j);
        for (int x = 0; x < num.length(); x++) {
            int cur = num.charAt(x) - '0';
            if (negative) {
                //这里判断溢出的情况和第7题一样
                if (ret < Integer.MIN_VALUE / 10|| ret == Integer.MIN_VALUE / 10 && cur > 8) {
                    return Integer.MIN_VALUE;
                }
                ret = ret * 10 - cur;
            } else {
                if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && cur > 7) {
                    return Integer.MAX_VALUE;
                }
                ret = ret * 10 + cur;
            }
        }
        return ret;
    }

    @Test
    public void test5(){
         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15, new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2){
                 return o2 - o1;
             }
         });

         PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(15, new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2) {
                 return o2 - o1;
             }
         });

    }

    @Test
    public void test6() {
        HashMap<String,String> map = new HashMap<>();
    }
}
