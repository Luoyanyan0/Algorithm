package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 最长不含重复字符的子字符串   arabcacfr   acfr
 * @Date: Created in 10:43 2019/7/8
 */
public class LongestSubstringWithoutDuplication {

    @Test
    public void test(){
        /*String str = "arabcacfr";
        System.out.println(longestSubstirngWithoutDuplication(str));*/

        int[] a = new int[2];
        int[] b = a;
        a[0] = 1;
        for (int aa : b){
            System.out.println(aa);
        }


    }

    public int longestSubstirngWithoutDuplication(String str){
        if (str.length() <= 0){
            return -1;
        }

        // 记录每个字符在字符串中前一个出现的位置
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++){
            position[i] = -1;
        }

        int curLength = 0;
        // 记住最长不重复子串的长度
        int maxLength = 0;

        char[] strToChar = str.toCharArray();
        for (int i = 0; i < strToChar.length; i++){

            int preIndex = position[strToChar[i] - 'a'];

            // 表示这个字符以前没有出现过 出现过
            if (preIndex == -1 || i - preIndex > maxLength){
                curLength++;
            } else if (i - preIndex <= maxLength){
                //  当前字符以前出现过 d <= f(i-1)
                curLength = i - preIndex;
            }

            position[strToChar[i] - 'a'] = i;

            if (curLength > maxLength){
                maxLength = curLength;
            }
        }
        return maxLength;
    }
}
