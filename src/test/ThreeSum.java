package test;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:59 2019/7/30
 */
public class ThreeSum {

    @Test
    public void threeSum(){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        for (List<Integer> list : threeSum(nums)){
            System.out.println(list);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>>  finalList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        // 此处排序是为了让重复的list可以在set中去重
        // 比如，不排序可能会出现 [-1,0,1] [1,0,-1] 这样的情况set无法去重
        // 排序之后，list会出现[-1,0,1],[-1,0,1 set可以去重
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                int lastNumber = 0 - nums[i] - nums[j];
                if (map.containsKey(lastNumber) && map.get(lastNumber) > j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(lastNumber);
                    set.add(list);
                }
            }
        }

        for (List<Integer> listInSet : set){
            finalList.add(listInSet);
        }
        return finalList;

    }
}
