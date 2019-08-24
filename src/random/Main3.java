package random;

/**
 * @Author: yanyan.luo
 * @Description: 单调递增 长度为N 和为S
 * @Date: Created in 15:49 2019/8/11
 */
public class Main3 {
    public static void main(String[] args) {
        int N = 3;
        int S = 10;

        for (int a = 0; a < N; a++) {
            for (int i = 1; i <= S; i++) {
                int tempSum = i + (i+1);
            }
        }
    }
}
