package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:23 2019/8/9
 */
public class SearchRange {
    @Test
    public void searchRange(){
        int nums[] = {5,7,7,8,8,10};
        int target = 6;
        for (Integer a : searchRange(nums,target)){
            System.out.print(a+"  ");
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] starEnd = new int[2];
        // 找到起始位置和终止位置
        starEnd[0] = findStartPosition(nums,target);
        starEnd[1] = findEndPosition(nums,target);

        return starEnd;
    }

    private int findStartPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (target > nums[mid]){
                low = mid + 1;
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                if (mid == 0 || (mid - 1 >= 0  && nums[mid - 1] != target)){
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    private int findEndPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            if (target > nums[mid]){
                low = mid + 1;
            } else if (target < nums[mid]){
                high = mid - 1;
            } else {
                if (mid == nums.length - 1 || (mid + 1 <= nums.length - 1 && nums[mid + 1] != target)){
                    return mid;
                }
                low = mid + 1;
            }
        }
        return -1;
    }
}
