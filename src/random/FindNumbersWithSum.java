package random;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yanyan.luo
 * @Description: 输入一个递增排序的数组和一个数字S，查找两个和等于S的数
 * @Date: Created in 17:56 2019/7/11
 */
public class FindNumbersWithSum {
    @Test
    public void test(){
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int sum = 21;
        System.out.println(FindNumbersWithSum(array,sum));
    }

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (map.containsKey(sum - array[i])){
                list.add(array[i]);
                list.add(sum - array[i]);
                return list;
            }else {
                map.put(array[i],sum - array[i]);
            }
        }
        return list;
    }




    @Test
    public void test1(){
        int sum = 3;
        System.out.println(FindContinuousSequence(sum));
    }

    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        if (sum < 3){
            return list;
        }

        int small = 1;
        int big = 2;
        int mid = (1+sum)/2;
        int curSum = small + big;

        while (small < mid){
            if (curSum == sum){
                ArrayList<Integer> sequence = new ArrayList<>();
                for (int i = small; i <= big; i++){
                    sequence.add(i);
                }
                list.add(sequence);
                big ++;
                curSum = curSum + big;
            }

            while (small < mid && curSum < sum){
                big ++;
                curSum += big;
            }
            while (small < mid && curSum > sum){
                curSum -= small;
                small ++;
            }
        }
        return list;
    }


    @Test
    public void test3(){
        String str = "student. a am I";
        System.out.println(ReverseSentence(str));
    }

    // 先反转所有的字符
    // 再按照空格分别反转每段字符串
    public String ReverseSentence(String str) {
        char[] stringToChar = str.toCharArray();
        reverse(stringToChar,0,stringToChar.length-1);
        int low = 0;
        int high = 0;
        while (high <= stringToChar.length){
            // 如果碰到空格
            if (high == stringToChar.length || stringToChar[high] == ' '){
                reverse(stringToChar,low,--high);
                high = high + 2;
                low = high;
            }else {
                high ++;
            }
        }
        return String.valueOf(stringToChar);
    }



    public String LeftRotateString(String str,int n) {
        char[] strToChar = str.toCharArray();
        reverse(strToChar,0,n - 1);
        reverse(strToChar,n,str.length() - 1);
        reverse(strToChar,0,str.length() - 1);
        return String.valueOf(strToChar);
    }

    private void reverse(char[] strToChar, int low, int high){
        while (low < high) {
            char temp = strToChar[low];
            strToChar[low] = strToChar[high];
            strToChar[high] = temp;
            low++;
            high--;
        }
    }
}
