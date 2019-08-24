package lettcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description: 一个字符串的排列组合
 * @Date: Created in 10:01 2019/8/12
 */
public class Permutations {

    @Test
    public void permute(){
        int[] nums = {1,2,3};
        for (List<Integer> l : permute(nums)) {
            System.out.println(l);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        permuteCore(nums,0,nums.length-1,finalList);
        return finalList;
    }

    private void permuteCore(int[] nums, int from, int to, List<List<Integer>> finalList) {
        if (from == to) {
            List<Integer> list = new ArrayList<>(numsIntoList(nums));
            if (!finalList.contains(list)) {
                finalList.add(list);
            }
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums,from,i);
                permuteCore(nums,from+1,to,finalList);
                swap(nums,i,from);
            }
        }
    }

    /**
     * 将数组中的数据放到list中*
     * @return
     */
    private List<Integer> numsIntoList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer a : nums) {
            list.add(a);
        }
        return list;
    }

    /**
     * 交换数组中两个元素的位置
     * @param nums
     * @param index1
     * @param index2
     */
    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
