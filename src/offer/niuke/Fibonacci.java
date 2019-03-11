package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 19:03
 * @Description:现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。  n<=39
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        int fn = 0;
        if (n == 1 || n == 2){
            return 1;
        }
        int a = 1,b = 1;
        for (int i = 3; i <= n; i++){
            fn = a + b;
            a = b;
            b = fn;
        }
        return fn;
    }
}
