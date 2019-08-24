package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: yanyan.luo
 * @Description: 找到数组中三个数相加与target最接近的值
 * @Date: Created in 20:30 2019/7/31
 */
public class ThreeSumClosest {
    @Test
    public void threeSumClosest(){
        int[] nums = {1,2,5,10,11};
        int target = 12;
        System.out.println(threeSumClosest(nums,target));

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        if (nums.length == 3){
            return nums[0] + nums[1] + nums[2];
        }

        int closestSum = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length; i++){
                int left = i + 1;
                int right = nums.length - 1;
            if (left < right && right < nums.length) {
                int sum = nums[i] + nums[left] + nums[right];
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < target) {
                        while (left < right && nums[left] == nums[left + 1]) {
                            ++left;
                        }
                        ++left;

                    } else if (sum > target) {
                        while (left < right && nums[right - 1] == nums[right]) {
                            --right;
                        }
                        --right;
                    } else {
                        return sum;
                    }

                    if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                        closestSum = sum;
                    }
                }

            }
        }
        return closestSum;
    }
}
