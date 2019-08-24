package test;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * 第一行N，表示参赛人数（2<=N<=10^5）
 * 第二行N个正整数表示体重（0<体重<=10^8）
 * @Date: Created in 19:55 2019/8/10
 */
public class contest {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int length = sca.nextInt();

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = sca.nextInt();
            if (numbers[i] <= 0 || numbers[i] > 100000000 ){
                System.out.println(0);
                return;
            }
        }*/

        int length = 5;
        int[] numbers = {1,1,1,1,1};

        /*if (length < 2 || length > 100000){
            System.out.println(0);
            return;
        }


        long count = 0;
        for (int i = 0; i < length; i++){
            for (int j = i+1; j < length; j++){
                int big = numbers[i] > numbers[j] ? numbers[i] : numbers[j];
                int small = numbers[i] > numbers[j] ? numbers[j] : numbers[i];

                if (small >= big * 0.9){
                    count ++;
                }
            }
        }
        System.out.println(count);
*/


        if(numbers.length <= 0) {return;}
        int copy[] = new int[numbers.length];
        for(int i = 0 ; i < numbers.length ; i++) {
            copy[i] = numbers[i];
        }
        int count = inverseCore(numbers, copy, 0, numbers.length - 1);
        System.out.println(count);
    }

    public static int inverseCore(int[] numbers,int[] copy,int start,int end){
        if(start == end){
            copy[start] = numbers[start];
            return 0 ;
        }

        int length = (end - start)/2;
        int left = inverseCore(copy, numbers, start, start + length);
        int right = inverseCore(copy, numbers, start + length + 1, end);

        //i初始化为前半段的最后一个下标
        int i = start + length ;
        //j初始化为后半段的最后一个下标
        int j = end;
        //记录copy数组的下标
        int indexOfCopy = end;
        //记录逆序对的数量
        int count = 0;
        while(i >= start && j >= start+length+1){
            if(numbers[i] >= numbers[j]*0.9){
                copy[indexOfCopy--] = numbers[i--];
                count += j - start - length;
                /*if(count > 1000000007)
                    count = count%1000000007;*/
            }else{
                copy[indexOfCopy--] = numbers[j--];
            }
        }
        for(; i >= start;--i) {
            copy[indexOfCopy--] = numbers[i];
        }
        for(; j >= start+length+1;--j) {
            copy[indexOfCopy--] = numbers[j];
        }

        return (left + right + count);
    }

}
