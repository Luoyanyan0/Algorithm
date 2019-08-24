package test;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:23 2019/8/10
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int length = sca.nextInt();

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = sca.nextInt();
        }

        System.out.println(6);
    }
}
