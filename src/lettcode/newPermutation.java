package lettcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 13:27 2019/8/20
 */
public class newPermutation {
    @Test
    public void getPermutation() {
        int n  = 9;
        int k = 54494;
        System.out.println(getPermutationII(n,k));
    }

    public String getPermutationII(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        char[] initialString = sb.toString().toCharArray();

        // 确定每个数字打头的序列有多少个
        // 比如 k = 3 1开头，2开头，3开头的分别是2个
        int eachNumber = 1;
        for (int i = 2; i <= n-1; i++) {
            eachNumber *= i;
        }
        // 找到开头的数字
        int startNumber = (k-1) / eachNumber;
        // 以这个数字打头的第几个
        int surplus = (k-1) % eachNumber;

        swap(initialString,0,startNumber);

        ArrayList<String> list = new ArrayList<>();
        permutationCore(initialString,0,initialString.length-1,list,eachNumber);
        Collections.sort(list);

        if (surplus > list.size()) {
            return "";
        }
        return list.get(surplus);
    }

    private void permutationCore(char[] toCharArray, int from, int to,
                                 ArrayList<String> list, int eachNumber) {

        if (list.size() >= eachNumber) {
            return;
        }
        if (from == to && !list.contains(String.valueOf(toCharArray))) {
            list.add(String.valueOf(toCharArray));
            return;
        }

        for (int i = from; i <= to; i++) {
            swap(toCharArray,from,i);
            permutationCore(toCharArray,from+1,to,list,eachNumber);
            swap(toCharArray,from,i);
        }
    }

    private void swap(char[] cc, int index1, int index2) {
        char temp = cc[index1];
        cc[index1] = cc[index2];
        cc[index2] = temp;
    }
}
