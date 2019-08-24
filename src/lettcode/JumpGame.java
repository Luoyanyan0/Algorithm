package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * Input: [2,3,1,1,4]
 * Output: true
 *
 * Input: [3,2,1,0,4]
 * Output: false
 *
 * @Date: Created in 19:07 2019/8/18
 */
public class JumpGame {
    @Test
    public void canJump() {
        int nums[] = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public boolean canJumpII(int[] nums) {
        int start = 0;
        boolean[] result = new boolean[nums.length];
        return canJumpCoreII(nums,start,result);
    }

    public boolean canJump(int[] nums) {
        boolean[] result = new boolean[nums.length];
        result[0] = true;
        for (int i = 0; i < nums.length; i++) {
            if (result[i]) {
                for (int j = 1; j < nums.length && j <= nums[i]; j++) {
                    if (!result[i+j]) {
                        result[i + j] = true;
                    }
                }
            } else {
                return false;
            }
        }
        return result[nums.length-1];
    }

    private boolean canJumpCoreII(int[] nums, int start, boolean[] result) {

        if (start < nums.length) {
            if (result[start]) {
                return true;
            }

            if (start >= nums.length - 1) {
                result[start] = true;
            }

            int gap = nums[start];
            for (int j = 1; j <= gap; j++) {
                result[start] = result[start] || canJumpCoreII(nums, start + j, result);
            }
            return result[start];
        }
        return true;
    }


    private boolean canJumpCore(int[] nums, int start) {

        boolean ret = false;
        if (start >= nums.length - 1) {
            ret = true;
            return ret;
        }

        if (nums[start] == 0 && start < nums.length - 1) {
            ret = false;
            return ret;
        }

        int gap = nums[start];
        for (int j = 1; j <= gap; j++) {
           ret = ret || canJumpCore(nums,start+j);
        }
        return ret;
    }



}
