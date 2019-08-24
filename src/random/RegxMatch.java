package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:  "aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * @Date: Created in 18:11 2019/8/20
 */
public class RegxMatch {
    @Test
    public void regxMatch() {
        char[] str = "aaa".toCharArray();
        char[] pattern = "a.a".toCharArray();
        System.out.println(match(str, pattern));
    }

    /**
     * 目标是找出所有可以匹配的情况
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        int strIndex = 0;
        int pIndex = 0;
        return matchCore(str,pattern,strIndex,pIndex);
    }

    private boolean matchCore(char[] str, char[] pattern, int strIndex, int pIndex) {
        if (strIndex == str.length && pIndex == pattern.length) {
            return true;
        }

        // 字符串没匹配完，但是模式串匹配完了
        if (strIndex < str.length && pIndex == pattern.length) {
            return false;
        }

        // 字符串匹配完了，模式串还存在，有这种情况   比如  ""   ".*"

        // pattern下一个字符是*
        if (pIndex + 1 < pattern.length && pattern[pIndex+1] == '*') {
            // 若str当前字符与pattern当前字符匹配，或者pattern当前字符是‘.’
            if (strIndex < str.length && (str[strIndex] == pattern[pIndex] || pattern[pIndex] == '.')) {
                return  matchCore(str, pattern, strIndex, pIndex+2) ||
                        matchCore(str, pattern,strIndex+1, pIndex+2) ||
                        matchCore(str, pattern, strIndex+1,pIndex);
            } else {
                return matchCore(str, pattern, strIndex, pIndex+2);
            }
        }


        // 下一个字符不是*
        if ((strIndex < str.length && pIndex < pattern.length && str[strIndex] == pattern[pIndex]) ||
                (pIndex < pattern.length && pattern[pIndex] == '.')) {
            return matchCore(str, pattern, strIndex+1, pIndex+1);
        }
        return false;
    }
}
