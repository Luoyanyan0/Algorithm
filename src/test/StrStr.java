package test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:48 2019/8/5
 */

import org.junit.Test;

/**
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 */
public class StrStr {

    @Test
    public void strStr(){
        String haystack = "mississipp";
        String needle = "issip";
        System.out.println(strStr(haystack,needle));
    }

    public int strStr(String haystack, String needle) {
        int i = 0;
        if(needle.isEmpty()) {
            return 0;
        }
        // i是起始位置，while保证haystack能够容纳needle
        while(i + needle.length() <= haystack.length()){
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = 0;
                while( j < needle.length()){
                    if(haystack.charAt(i+j) != needle.charAt(j)) {
                        break;
                    }
                    j++;
                }
                if(j == needle.length()) {
                    return i;
                }

            }
            i++;
        }
        return -1;
    }
}
