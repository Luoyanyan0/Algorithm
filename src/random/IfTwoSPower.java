package random;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/18 15:41
 * @Description:判断一个数是不是2的整数次方
 * 使用 一个数的二进制中有几个1的解法
 * 一个数是2的整数次方，那么这个数中只有一个1
 * 比如： 8 --- 1000
 *       4 ---- 0100
 *       2 ---- 0010
 *       16 --- 10000
 */
public class IfTwoSPower {

    public static void main(String[] args) {
        int number = 17;
        System.out.println(ifTwosPower(number));
        int m = 10;
        int n = 5;
        System.out.println(mToN(m,n));
    }


     public static boolean ifTwosPower(int number){
         int count = 0;
         while (number != 0){
             ++ count;
             number = (number - 1) & number;
         }
         if (count == 1) {
             return true;
         }
         return false;
     }

    /**description：
     * 两个数字M和N，查看两个数字的二进制，需要改动M中的几位才能变成N
     * 比如：，m = 10   n = 13
     * m:1010   n:1101     返回结果：3
     * @param m
     * @param n
     * @return
     * 1，异或，可以求出两个数中不相同部分的个数
     * 2，判断异或结果中1的个数
     */
     public static int mToN(int m, int n){
         int result = 0;
         int difference = m ^ n;
         while (difference != 0){
             ++ result;
             difference = difference & (difference - 1);
         }
         return result;
     }
}
