package threesixzero;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:53 2019/8/15
 */
public class Main1 {
    public static void main(String[] args) {
       /* Scanner sca = new Scanner(System.in);

        int n = sca.nextInt();
        int m = sca.nextInt();

        int[] num1 = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = sca.nextInt();
        }

        int[] num2 = new int[n];
        for (int i = 0; i < n; i++) {
            num2[i] = sca.nextInt();
        }*/

       int num1[] = {4,4,1,1,1};
       int num2[] = {4,3,0,1,2};

        List<List<Integer>> list1 = permute(num1);
        List<List<Integer>> list2 = permute(num2);

       int max = 0;
       for (int i = 0; i < list1.size(); i++) {
           for (int j = 0; j < list2.size(); j++) {
               int sum = 0;
               for (int k = 0; k < list2.get(j).size(); k++) {
                   int temp1 = list1.get(i).get(k);
                   int temp2 = list2.get(j).get(k);

                   int tempNumber = (temp1+temp2)%5;
                   sum = sum*10+tempNumber;
               }
               if (sum > max) {
                   max = sum;
               }
           }
       }
        System.out.println(max);

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> finalList = new ArrayList<>();
        permuteCore(nums,0,nums.length-1,finalList);
        return finalList;
    }

    private static void permuteCore(int[] nums, int from, int to, List<List<Integer>> finalList) {
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
    private static List<Integer> numsIntoList(int[] nums) {
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
    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
