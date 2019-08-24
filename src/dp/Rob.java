package dp;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 小偷偷东西，不能偷相邻的两家，求最终偷到的最大价值
 * @Date: Created in 15:44 2019/8/10
 */
public class Rob {
    @Test
    public void rob(){
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
     //   int[] nums = {2,7,9,3,1};
        System.out.println(robII(nums));
    }


    public int rob(int[] nums) {
        int result[] = new int[nums.length];
        for (int i = 0; i < result.length; i++){
            result[i] = -1;
        }
        if (nums.length == 0){
            return 0;
        }
        return rob(nums.length - 1, nums,result);
    }

    public int rob(int currentIndex, int[] nums, int[] result){
        if (currentIndex < 0){
            return 0;
        }

        if (result[currentIndex] >= 0) {
            return result[currentIndex];
        }

        result[currentIndex] = Math.max(nums[currentIndex] + rob(currentIndex - 2,nums,result),
                rob(currentIndex-1,nums,result));

        return result[currentIndex];
    }

    public int robII(int[] nums) {
        int result[] = new int[nums.length];

        if (nums.length == 0){
            return 0;
        }

        result[0] = nums[0];
        result[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i-2],result[i-1]);
        }
        return result[result.length - 1];
    }

}
