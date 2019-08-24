package test;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 多个字符串的最长的公共前缀
 * @Date: Created in 20:11 2019/7/30
 */
public class LongestCommonPrefix {
    @Test
    public void test(){
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs.length == 0){
            return result;
        }
        // 找到数组中最短的那个字符串
        String minString = strs[0];
        for (int i = 1; i < strs.length; i++){
            if (strs[i].length() < minString.length()){
                minString = strs[i];
            }
        }

        // 判断每个字符是否和minString相等，如果不相等，则将minString从后面删减字符
        int end = minString.length();
        while (end > 0){
            int i = 0;
            for (; i < strs.length; i++){
                if (!(strs[i].substring(0,end).equals(minString.substring(0,end)))){
                    end--;
                    break;
                }
            }

            if (i == strs.length){
                result = minString.substring(0,end);
                return result;
            }
        }
        return result;

    }
}
