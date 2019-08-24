package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:49 2019/8/17
 */
public class MyPow {
    @Test
    public void myPow() {
        double x = 0.00001;
        int n = 2147483647;
        System.out.println(myPowII(x,n));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int absN = n > 0 ? n : -n;

        double result = 1;
        for (int i = 0; i < absN; i++) {
            result *= x;
        }


        return n > 0 ? result : (double)1/result;
    }


    public double myPowII(double x, int n) {
        // 这里的N需要设置成long，是因为 假如n为最小的负数，那么直接取绝对值，那么这个数字的长度就会超过int的最大值
        // 比如  -2147483648（最小的int类型）  2147483648（超过int类型的最大值）
        long N = n;
        double result = 1;

        if (N < 0) {
            x = 1/x;
            N = -N;
        }

        double temp = x;
        for (long i = N; i > 0; i = i/2) {
            if (i % 2 == 1) {
                result = result * temp;
            }
            temp = temp * temp;
        }
        return result;
    }

}
