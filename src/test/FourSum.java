package test;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 16:38 2019/8/1
 */
public class FourSum {
    @Test
    public void fourSum(){
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums,0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        if (nums.length == 0){
            return list;
        }

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                for (int k = j+1; k < nums.length; k++){
                    int value = target - (nums[i] + nums[j] + nums[k]);
                    if (map.containsKey(value) && map.get(value) > k){
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        tempList.add(value);
                    //    Collections.sort(tempList);
                        set.add(tempList);
                    }
                }
            }
        }
        for (List<Integer> l : set){
            list.add(l);
        }
        return list;
    }
}
