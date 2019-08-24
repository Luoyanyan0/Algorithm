package bytedance;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:30 2019/8/11
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int N = sca.nextInt();
        int K = sca.nextInt();

        String str = sca.next();


        char[] strr = str.toCharArray();
        int[] result = new int[N];
        result[0] = strr[0];
        result[N-1] = strr[strr.length - 1];
        int count = 1;
        for (int i = 1; i < strr.length; i++){
        }



    }
}
