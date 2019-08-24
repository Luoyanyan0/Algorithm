package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 丑数
 * @Date: Created in 22:47 2019/7/8
 */
public class GetUglyNUmber {
    @Test
    public void test(){
        int index = 3;
        System.out.println(GetUglyNumber_Solution(index));
    }

    public int GetUglyNumber_Solution(int index) {

        if (index ==1){
            return 1;
        }

        // 存放所有丑数的数组
        int uglyNumber[] = new int[index];

        int uglyNumber2[] = uglyNumber;
        int uglyNumber3[] = uglyNumber;
        int uglyNumber5[] = uglyNumber;

        uglyNumber[0] = uglyNumber2[0] = uglyNumber3[0] = uglyNumber5[0] = 1;
        int nextIndex = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;

        while (nextIndex < index){
            int min = getMin(uglyNumber2[index2]*2,uglyNumber3[index3]*3,uglyNumber5[index5]*5);
            uglyNumber[nextIndex] = min;

            while (uglyNumber2[index2] * 2 <= uglyNumber[nextIndex]){
                index2++;
            }
            while (uglyNumber3[index3] * 3 <= uglyNumber[nextIndex]){
                index3++;
            }
            while (uglyNumber5[index5] * 5 <= uglyNumber[nextIndex]){
                index5++;
            }
            nextIndex++;
        }

        return uglyNumber[index-1];
    }

    private int getMin(int number2,int number3,int number5){
        int min = (number2 <= number3 ? number2 : number3);
        return min <= number5 ? min : number5;
    }
}
