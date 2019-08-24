package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: Input: nums = [4,5,6,7,0,1,2], target = 0   Output: 4
 *               Input: nums = [4,5,6,7,0,1,2], target = 3   Output: -1
 * @Date: Created in 11:02 2019/8/8
 */
public class SearchInPartSortArray {
    @Test
    public void search(){
        int nums[] = {1,3};
        int target = 1;
        System.out.println(search(nums,target));
    }

    /**
     * 统一输出前面递增数组的最后一个元素
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        // 确认数组有翻转
        if (nums.length > 0 && nums[0] >= nums[nums.length - 1]) {
            int boundry = findBoundry(nums);
            int result1 = binarySearch(nums,target,0,boundry);
            int result2 = binarySearch(nums,target,boundry+1,nums.length-1);
            if (result1 == -1 && result2 == -1){
                return -1;
            } else {
                return result1 + result2 + 1;
            }
        } else {
            // 数组没有翻转，正常二分查找
            return binarySearch(nums,target,0,nums.length - 1);
        }

    }


    private int findBoundry(int nums[]){
        {
            // 首先找到分界的位置，然后分别在两个递增数组中查找
            // 数组原始是递增的，不存在相同的元素 不会出现low mid high 处元素相同的情况

            int low = 0;
            int high = nums.length - 1;
            while (low <= high){
                int mid = (low + high)/2;
                if (nums[mid] >= nums[low]){
                    // mid是前面递增数组的最后一个元素，也是两个递增数组的分界线
                    if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]){
                        return mid;
                    } else {
                        low = mid + 1;
                    }
                } else if (nums[mid] <= nums[high]){
                    // mid是后面递增数组的最后一个元素，也是两个递增数组的分界线
                    if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]){
                        return mid - 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

    // 二分查找
    private int binarySearch(int nums[], int target, int start, int end){
        while (start <= end){
            int mid = (start + end)/2;
            if (target > nums[mid]){
                start = mid + 1;
            } else if (target < nums[mid]){
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
