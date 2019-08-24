package tecent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:10 2019/8/17
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        int n = sca.nextInt();
        int numLength = (int) Math.pow(2,n);
        int[] initialNum = new int[numLength];
        for (int i = 0; i < numLength; i++) {
            initialNum[i] = sca.nextInt();
        }

        int m = sca.nextInt();
        int q[] = new int[m];
        for (int i = 0; i < m; i++) {
            q[i] = sca.nextInt();
        }



      /*  int n = 2;
        int[] initialNum = {2,1,4,3};
        int m = 4;
        int[] q = {1,2,0,2};*/

        // 存放每次反转的长度
        int[] newQ = new int[q.length];
        for (int i = 0; i < newQ.length; i++) {
            newQ[i] = (int)Math.pow(2,q[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < initialNum.length; i++) {
            sb.append(initialNum[i]);
        }

        List<String> reverseString = new ArrayList<>();
        for (int i = 0; i < newQ.length; i++) {
            List<String> tempList = new ArrayList<>();
            int gap = newQ[i];
            for (int j = 0; j < initialNum.length;){
                tempList.add(sb.substring(j,j+gap));
                j = j+gap;
            }
            String ss = reverseString(tempList);
            reverseString.add(ss);
            sb = new StringBuilder(ss);

        }
        for (String s : reverseString) {
            System.out.println(InversePairs(charToInt(s.toCharArray())));
        }

    }


    public static int[] charToInt(char[] cc) {
        int[] array = new int[cc.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = cc[i] - '0';
        }
        return array;
    }

    public static int InversePairs(int[] array) {
        if(array.length <= 0) {return 0;}
        int copy[] = new int[array.length];
        for(int i = 0 ; i < array.length ; i++) {
            copy[i] = array[i];
        }
        int count = inverseCore(array, copy, 0, array.length - 1)%1000000007;
        return count;
    }

    public static int inverseCore(int[] array,int[] copy,int start,int end){
        if(start == end){
            copy[start] = array[start];
            return 0 ;
        }

        int length = (end - start)/2;
        int left = inverseCore(copy, array, start, start + length);
        int right = inverseCore(copy, array, start + length + 1, end);

        //i初始化为前半段的最后一个下标
        int i = start + length ;
        //j初始化为后半段的最后一个下标
        int j = end;
        //记录copy数组的下标
        int indexOfCopy = end;
        //记录逆序对的数量
        int count = 0;
        while(i >= start && j >= start+length+1){
            if(array[i] > array[j]){
                copy[indexOfCopy--] = array[i--];
                count += j - start - length;
                if(count > 1000000007)
                    count = count%1000000007;
            }else{
                copy[indexOfCopy--] = array[j--];
            }
        }
        for(; i >= start;--i)
            copy[indexOfCopy--] = array[i];
        for(; j >= start+length+1;--j)
            copy[indexOfCopy--] = array[j];

        return (left + right + count)%1000000007;
    }


    private static String reverseString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(new StringBuilder(s).reverse());
        }
        return sb.toString();
    }
}
