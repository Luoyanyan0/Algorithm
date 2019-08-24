package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 经典爬楼梯，每次可以爬一阶两阶三阶
 * @Date: Created in 16:15 2019/8/23
 */
public class JumpFloor {
    @Test
    public void jumpFloor() {
        int n = 5;
        System.out.println(jumpFloorII(n));
    }

    public int jumpFloorII(int n) {
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;
        result[2] = 2;
        result[3] = 4;
        for (int i = 4; i <=n; i++) {
            result[i] = result[i-1]+result[i-2]+result[i-3];
        }
        return result[n];
    }

    public int jumpFloor(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (n ==3) {
            return 4;
        }
        return jumpFloor(n-1)+jumpFloor(n-2)+jumpFloor(n-3);
    }
}
