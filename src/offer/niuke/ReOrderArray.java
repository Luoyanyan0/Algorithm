package offer.niuke;

import org.junit.Test;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    /**
     * 其实就是要实现一种稳定的排序
     * @param array
     */
    public void reOrderArray(int [] array) {
        // 奇数在偶数前面
        for (int i = 1; i < array.length; i++){
            int j = i;
            int temp = array[i];
            // 当前的值是奇数，当前值前面的值是偶数， 4(0)   3(1)   -->   4(1)
            while (j > 0 && isOdd(temp) && !isOdd(array[j - 1])){
                array[j] = array[j - 1];
                j --;
            }
            array[j] = temp;
        }
    }

    public boolean isOdd(int number){
        if (number % 2 != 0){
            return true;
        }
        return false;
    }


    /**
     * 插入排序
     *//*
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }*/

    @Test
    public void test1() {
        int[] arr = {3,2,1,4};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
