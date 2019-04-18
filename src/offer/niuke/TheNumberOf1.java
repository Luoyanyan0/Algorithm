package offer.niuke;

/**
 * 求一个数字二进制形式中1的个数
 */
public class TheNumberOf1 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(theNumberOf1(n));
        System.out.println(Integer.MAX_VALUE+"**********"+Integer.MIN_VALUE);
        System.out.println((int)2147483647+2);
        System.out.println((int)-2147483648*2);
    }
    /**
     * 常规解法
     * @param n
     * @return
     * 如果n是32位的整数，就要循环32位，造成不必要的浪费
     */
    public static int theNumberOf1(int n){
        // 常规解法 设置一个flag=1，不断左移flag
        int count = 0;
        int flag = 1;
        int i = 0;
        while (flag != 0){
            i++;
            if ((flag & n) != 0 ){
                count ++;
            }
            flag = flag << 1;
        }
        System.out.println(flag);
        System.out.println(i);
        return count;
    }

    /**
     * 推荐的解法
     * （整数-1）& 整数   = 整数右边的1变成0
     */
    public static int newSolution(int n){
        int count = 0;
        while (n != 0){
            n = (n - 1) & n;
            count ++;
        }
        return count;
    }
}
