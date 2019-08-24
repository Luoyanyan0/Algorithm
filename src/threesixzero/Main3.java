package threesixzero;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:45 2019/8/15
 */
public class Main3 {
    public static void main(String[] args) {

        int num1[] = {4,4,1,1,1};
        int num2[] = {4,3,0,1,2};

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < num1.length; i++) {
            map.put(num1[i],i);
        }

    }
}
