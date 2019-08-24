package test;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:02 2019/8/10
 */
public class abs {
    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int length = sca.nextInt();

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = sca.nextInt();
        }*/

        int length = 9;
        int numbers[] = {1,3,4,7,2,6,5,12,12};

        if (length == 0){
            System.out.println(0);
            return;
        }

        int min = getAbs(numbers[0] - numbers[length-1]);
        int a = numbers[0];
        int b = numbers[1];
        for (int i = 0; i < length-1; i++) {
                int temp = getAbs(numbers[i] - numbers[i+1]);
                if (temp < min){
                    min = temp;
                    a = numbers[i];
                    b = numbers[i+1];
                }
        }
        System.out.println(a+" "+b);
    }

    private static int getAbs(int number){
        return number >= 0 ? number : -number;
    }
}
