package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 一个数组中只有一个数字只出现一次，其他数字都出现了三次
 *               {3,3,2,3}
 * @Date: Created in 17:07 2019/7/10
 */
public class NumberAppearOnce {
    @Test
    public void test(){
        int[] array = {3,3,2,3};
        System.out.println(numberAppearOnce(array));
    }

    /**
     * 计算所有位出现多少次 将得到的位数%3 ==0 该位=0  否则=1
     * @param array
     * @return
     */
    public int numberAppearOnce(int[] array){
        int count[] = new int[32];
        for (int i = 0; i < array.length; i++){
            int flag = 1;
            for (int j = 31; j >= 0; j--){
                if (isNotZero(array[i],flag)){
                    count[j] += 1;
                }
                flag = flag << 1;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++){
            result = result << 1;
            result += count[i] % 3;
        }
        return result;
    }

    private boolean isNotZero(int number, int flag){
        if ((number & flag) != 0){
            return true;
        }
        return false;
    }
}
