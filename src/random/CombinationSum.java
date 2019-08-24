package random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description: Input: candidates = [2,3,6,7], target = 7,
 *              A solution set is:
 *              [
 *                  [7],
 *                  [2,2,3]
 *              ]
 * @Date: Created in 20:40 2019/8/9
 */
public class CombinationSum {
    @Test
    public void combinationSum(){
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> list = combinationSum(candidates,target);
        for (List<Integer> l : list){
            System.out.println(l);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalResult = new ArrayList<>();
        combinationSumCore(finalResult,new ArrayList<Integer>(),candidates,0,target,0);
        return finalResult;
    }

    private void combinationSumCore(List<List<Integer>> finalResult, ArrayList<Integer> integers,
                                    int[] candidates, int currentSum, int target, int currentIndex) {
        if (currentSum == target){
            finalResult.add(new ArrayList<>(integers));
            return;
        } else if (currentSum > target){
            return;
        } else {
            for (int i =  currentIndex; i < candidates.length; i++){
                integers.add(candidates[i]);
                combinationSumCore(finalResult,integers,candidates,currentSum+candidates[i],target,i);
                integers.remove(integers.size()-1);
            }
        }
    }


}
