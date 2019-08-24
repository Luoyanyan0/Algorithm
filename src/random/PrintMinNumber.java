package random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author: yanyan.luo
 * @Description: 把数组里所有的数拼接成最小的数
 * @Date: Created in 20:31 2019/7/4
 */
public class PrintMinNumber {
    @Test
    public void test(){
        int[] numbers = {3,32,321};
        System.out.println(PrintMinNumber(numbers));
    }

    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length ; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2){
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
        }
        return String.valueOf(sb);
    }
}
