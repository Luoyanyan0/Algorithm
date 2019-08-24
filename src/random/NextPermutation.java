package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:29 2019/8/7
 */
public class NextPermutation {
    @Test
    public void nextPermutation(){
        int nums[] = {1,5,1};
        nextPermutation(nums);
        for (Integer a : nums){
            System.out.print(a+" ");
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        int j = nums.length - 1;

        while (i > 0 && nums[i-1] >= nums[i]){
            i --;
        }

        int k = i - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i ++;
            j --;
        }

        int p = k + 1;
        while (k >= 0 && p <nums.length && nums[k] >= nums[p]){
            p ++;
        }
        if (k >= 0 && p < nums.length){
            int temp = nums[k];
            nums[k] = nums[p];
            nums[p] = temp;
        }
    }
}
