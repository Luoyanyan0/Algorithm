package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 一个长度为n的递增排序数组中所有的数字都是唯一的，并且每个数字都在范围0~n-1范围内，
 *               在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * @Date: Created in 11:26 2019/7/10
 */
public class GetMissingNumber {

    @Test
    public void test(){
        int[] numbers = {1,2,3,4,5};
        System.out.println(getMissingNumber(numbers));
    }

    /** 默认数组是从0开始递增排序的
     * 假设缺失的数字是L，L前的数字和下标同，L是第一个数字和下标不同的数    二分查找思维
     * @param numbers
     * @return
     */
    public int getMissingNumber(int[] numbers){
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high){
            int mid = (low + high)/2;
            // numbers[mid] == mid 数等于下标，说明L在mid右侧
            // 数不等于下标  1.数是L  2.L在mid左侧
            if (numbers[mid] == mid){
                low = mid + 1;
            }else {
                if (mid == 0 || numbers[mid - 1] == mid - 1){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void test2(){
        int[] numbers = {-3,-1,1,3,5};
        System.out.println(getNumberSameAsIndex(numbers));
    }

    /**
     * 数组中数值和下标相等的元素
     * 单调递增数组每个元素都为整数且唯一
     * {-3，-1,1,3,5}  输出3
     */
    public int getNumberSameAsIndex(int[] numbers){
        if (numbers.length == 0){
            return -1;
        }
        int low = 0;
        int high = numbers.length - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if (numbers[mid] == mid){
                return mid;
            }else if (numbers[mid] > mid){
                // 值大于下标，往左找
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }


}
