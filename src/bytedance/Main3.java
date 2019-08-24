package bytedance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:51 2019/8/11
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int count = sca.nextInt();

        int year[] = new int[count];
        for (int i = 0; i < count; i++) {
            year[i] = sca.nextInt();
        }

     /*   int count = 5;
        int year[] = {1,2,3,4,5};
*/

        int money[] = new int[count];
        for (int i = 0; i < money.length; i++){
            money[i] = 100;
        }
        int index = minInYear(year);
        if (index - 1 >= 0 && year[index-1] > year[index]){
            money[index - 1] = 200;
        }

        if (index + 1 < count && year[index+1] > year[index]){
            money[index + 1] = 200;
        }


        for (int i = index - 2; i >= 0; i--) {
            if (year[i] > year[i+1]) {
                money[i] = money[i+1] + 100;
            }
        }

        for (int i = index + 2; i < count; i++){
            if (year[i] > year[i-1]){
                money[i] = money[i-1] + 100;
            }
        }

        int sum = 0;
        for (int a : money){
            sum += a;
        }
        System.out.println(sum);


    }

    private static int minInYear(int year[]){
        int index = 0;
        int minYear = year[0];
        for (int i = 1; i < year.length; i++) {
            if (year[i] < minYear) {
                minYear = year[i];
                index = i;
            }
        }
        return index;
    }
}
