package problems;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 11:28 2019/8/18
 */
public class findSpecialNumber {


    private static final int N = 100000000;
    private static final int size = N/6*2 + (N%6 == 5? 2: (N%6>0 ? 1 : 0));
    private static final int p[] = new int[size / 32 + 1];


    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        System.out.println(creat_prime());
        System.out.println(System.currentTimeMillis() - startTime);
    }


   /* @Test
    public void test(){
        int a = 2;
        int b = 2;
        System.out.println(a^b);
    }*/


    /**
     * & | ^ 两边的元素是数字    && 两边的元素必须是表达式
     * @return
     */
    public static int creat_prime() {
        int i, j;
        int len, stp;
        int c = size + 1;
        for (i = 1; ((i&~1)<<1) * ((i&~1) + (i>>1) + 1) < size; i++) {
            if ((p[i >> 5] >> (i & 31) & 1) != 0) {
                continue;
            }
            len = ((i & 1) != 0)? ((i&~1)<<1) + 3: ((i&~1)<<2) + 1;
            stp = ((i&~1)<<1) + ((i&~1)<<2) + ((i & 1)!= 0 ? 10: 2);
            j = ((i&~1)<<1) * (((i&~1)>>1) + (i&~1) + 1) + ((i & 1)!= 0 ? ((i&~1)<<3) + 8 + len: len);
            for (; j < size; j += stp) {
                if ((p[j >> 5] >> (j & 31) & 1 ^ 1) != 0) {
                    p[j >> 5] |= 1L << (j & 31);
                    --c;
                }
                if ((p[(j-len) >> 5] >> ((j-len) & 31) & 1 ^ 1) != 0) {
                    p[(j - len) >> 5] |= 1L << ((j - len) & 31);
                    --c;
                }
            }
            if (j - len < size && ((p[(j-len) >> 5] >> ((j-len) & 31) & 1 ^ 1) != 0)) {
                p[(j - len) >> 5] |= 1L << ((j - len) & 31);
                --c;
            }
        }
        return c;
    }
}
