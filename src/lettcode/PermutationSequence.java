package lettcode;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Input: n = 4, k = 9
 * Output: "2314"
 * @Date: Created in 20:05 2019/8/19
 */
public class PermutationSequence {


    public String getPermutation(int n, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        String initialString = sb.toString();

        ArrayList<String> list = new ArrayList<>();
        permutationCore(initialString.toCharArray(),0,initialString.length()-1,list);
        Collections.sort(list);

        if (k > list.size()) {
            return "";
        }
        return list.get(k-1);
    }

    private void permutationCore(char[] toCharArray, int from, int to, ArrayList<String> list) {
        if (from == to && !list.contains(String.valueOf(toCharArray))) {
            list.add(String.valueOf(toCharArray));
            return;
        }

        for (int i = from; i <= to; i++) {
            swap(toCharArray,from,i);
            permutationCore(toCharArray,from+1,to,list);
            swap(toCharArray,from,i);
        }

    }

    private void swap(char[] cc, int index1, int index2) {
        char temp = cc[index1];
        cc[index1] = cc[index2];
        cc[index2] = temp;
    }
}
