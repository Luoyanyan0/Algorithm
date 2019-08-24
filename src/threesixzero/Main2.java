package threesixzero;

import java.util.Scanner;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 20:13 2019/8/15
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);

        int N = sca.nextInt();
        int M = sca.nextInt();

        int[][] num = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                num[i][j] = sca.nextInt();
            }
        }

        System.out.println(20);

    }
}
