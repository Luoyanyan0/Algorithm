package random;

import org.junit.Test;

import java.util.*;

/**
 * @Author: yanyan.luo
 * @Description: [10,1,2,7,6,1,5], target = 8,
 *               [
 *                 [1, 7],
 *                 [1, 2, 5],
 *                 [2, 6],
 *                 [1, 1, 6]
 *              ]
 * @Date: Created in 22:54 2019/8/9
 */
public class CombinationSum2 {
    @Test
    public void combinationSum2(){
        int candidates[] = {10,1,2,7,6,1,5};
        int target = 8;
        for (List<Integer> ll : combinationSum2(candidates,target)) {
            System.out.println(ll);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalResult = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationSum2Core(set,new ArrayList<Integer>(),candidates,0,target,0);
        for (List<Integer> l : set) {
            finalResult.add(l);
        }
        return finalResult;
    }

    private void combinationSum2Core(Set<List<Integer>> set, ArrayList<Integer> integers,
                                     int[] candidates, int currentSum, int target, int currentIndex) {
        if (currentSum == target){
            List<Integer> list = new ArrayList<>(integers);
            Collections.sort(list);
            set.add(list);
            return;
        } else if (currentSum > target){
            return;
        } else {
            for (int i = currentIndex; i < candidates.length; i++){
                integers.add(candidates[i]);
                combinationSum2Core(set,integers,candidates,currentSum+candidates[i],
                        target,i+1);
                integers.remove(integers.size()-1);
            }
        }
    }
}
