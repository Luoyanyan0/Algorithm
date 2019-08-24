package test;
import java.util.Scanner;
public class maxLength {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int length = sca.nextInt();

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = sca.nextInt();
        }*/


        int length = 5;
        int[] numbers = {1,5,3,2,4};

        if (length < 0 || length > 50000){
            System.out.println(0);
            return;
        }

        /*int[] maxLength = new int[length];
        maxLength[0] = 1;
        for (int i = 1; i < length; i++){
            int max = 1;
            for (int j = 0; j < i; j++){
                if (numbers[i] > numbers[j] && maxLength[j] >= max){
                    max = maxLength[j] + 1;
                }
            }
            maxLength[i] = max;
        }
        System.out.println(maxLength[length-1]);*/


       int [] maxLength = new int[length + 1];
       maxLength[1] = numbers[0];
       int len = 1;
       int start = 0;
       int end = len,mid;

       for (int i = 1; i <length; i ++){
           if (numbers[i] > maxLength[len]){
               len ++;
               maxLength[len] = numbers[i];
           } else {
               start =1;
               end = len;
               while (start <= end){
                   mid = (start + end)/2;
                   if (maxLength[mid] < numbers[i]){
                       start = mid+1;
                   } else {
                       end = mid -1;
                   }
               }
               maxLength[start] = numbers[i];
           }
       }
        System.out.println(len);
    }




}