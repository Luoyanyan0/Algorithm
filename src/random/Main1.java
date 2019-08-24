package random;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 14:53 2019/8/11
 */
public class Main1 {


    public static void main(String[] args) {
        /*Scanner sca = new Scanner(System.in);
        int length = sca.nextInt();

        int[] numbers = new int[length];
        for (int i = 0; i < length; i++){
            numbers[i] = sca.nextInt();
        }*/


        int length = 4;
        int numbers[] = {10,17,17,3};


        Arrays.sort(numbers);
        double min = getSub(numbers[0],numbers[1],numbers[2]);
        for (int i = 0; i < length; i++){
            for (int j = i+1; j < length; j++){
                for (int k = j+1; k < length; k++){
                    double temp = getSub(numbers[i],numbers[j],numbers[k]);
                    System.out.println(min+" "+numbers[i]+" "+numbers[j]+" "+numbers[k]);
                    if (temp < min){
                        min = temp;
                    }
                    break;

                }
                break;
            }
        }
        System.out.println(String.format("%.2f",min));

    }

    private static double getSub(int n1, int n2, int n3){
        double avg = (double) (n1+n2+n3)/(double) 3;
        double a = 1,b = 3;
        double div = a/b;

        double m1 = Math.pow(n1-avg,2);
        double m2 = Math.pow(n2-avg,2);
        double m3 = Math.pow(n3-avg,2);

        return div*(m1+m2+m3);
    }
}
