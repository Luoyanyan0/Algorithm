package offer.niuke;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power_12 {
    /**
     * 主要是判断底数和指数的各种情况
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        double result = 1;
        // 0的幂次在这里是有意义的
        if (base == 0 && exponent < 0){
            return -1;
        }
        if (exponent == 0 ){
            return 1;
        }
        if (exponent == 1){
            return base;
        }

        int temp = exponent > 0 ? exponent : -exponent;
        for (int i = 0; i < temp; i++){
            result *= base;
        }

        if (exponent < 0){
            result = 1 / result;
        }
        return result;
    }

    public static void main(String[] args) {
        double base = 2;
        int exponent = 3;
        System.out.println(Power(base,exponent));
    }
}
