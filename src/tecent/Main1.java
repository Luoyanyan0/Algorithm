package tecent;

import org.junit.Test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: yanyan.luo
 * @Description: 压缩
 * @Date: Created in 20:01 2019/8/17
 */
public class Main1 {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        String str = sca.next();*/


        String str = "[1|HG[3|B[2|CA]]F]";
        //System.out.println("HGBCACABCACABCACAF");

        StringBuilder sb = new StringBuilder(str);
        System.out.println(compact(sb).equals("HGBCACABCACABCACAF"));


    }


    @Test
    public void test() {
        String s = "abc|f";
        System.out.println(s.split("\\|").length);
    }

    private static final Stack<Character> stack = new Stack<>();

    private static String compact(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ']') {
                int end = i - 1;

                // 先pop，所以[已经pop出去了
                while (stack.pop() != '[') {
                    end --;
                }
                int start = end + 1;
                end = i;

                // 拼接字符串
               sb = jointString(sb,start,end);
               i = stack.size()-1;
            } else {
                stack.push(sb.charAt(i));
            }
        }
        return sb.toString();
    }

    private static StringBuilder jointString(StringBuilder sb, int start, int end) {
        // sb = 2|CA
        String[] cc = sb.substring(start,end).split("\\|");
        int times = Integer.valueOf(cc[0]);
        String loopString = cc[1];

        StringBuilder newSb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            newSb.append(loopString);
        }
        // stack中不一定是完整的字符串，但是sb中的字符串是完整的，需要将前面的[和后面的]删除
        sb.delete(start-1,end+1);
        sb.insert(start-1,newSb);

        return sb;
    }
}
