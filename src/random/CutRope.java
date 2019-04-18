package random;

/**
 * 剪绳子
 * 长度为N，剪成N段，
 * N>1,M>1
 */
public class CutRope {
    public static void main(String[] args) {
        int length = 8;
        System.out.println(cutRope2(length));
    }
    /**
     * 动态规划的解法
     * @param length
     * @return
     */
    public static int cutRope(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int result[] = new int[length+1];
        // 前面长度为1,2,3最大的乘积已经做了判断，后面的长度是从4开始的
        // 所以这里对result[0]，1,2,3的赋值和前面的值不同，这里主要是为了后面做计算
        // 比如长度为4的绳子，可以分为2,2/1,3这其中的2,3就不需要再分了，因为再分的话最终的乘积就会变小
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        int max = 0;
        for (int i = 4; i <= length; i++){
            // 这里的max不重新赋值为0也是可以的
            // 因为这里的情况比较特殊，绳子越长，最终的乘积也就越大，一定会覆盖前面的值
            max = 0;
            for (int j = 1; j <= i/2; j++){
               int product = result[j] * result[i-j];
               if (product > max) {
                   max = product;
               }
            }
            result[i] = max;
        }
        return max;
    }

    /**
     * 贪心算法剪绳子
     * @param length
     * @return
     * 尽量多剪出长度为3的绳子
     */
    public static int cutRope2(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length/3;
        // 最终剩余长度为4的绳子，剪成2段长度为2的绳子
        if (length - 3 * timesOf3 == 1){
            timesOf3 --;
        }
        int timesOf2 = (length - (timesOf3 * 3))/2;

        return (int)Math.pow(2,timesOf2) * (int)Math.pow(3,timesOf3);
    }
}
