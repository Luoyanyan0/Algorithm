package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:11 2019/8/10
 */
public class Combination {
    @Test
    public void combination(){
        int n = 3;
        int r = 1;
        combination(n,r);
    }

    public void combination(int n, int r){
        if (n < r){
            return;
        }
        if (r == 0){
            System.out.println(n);
            return;
        }
        combination(n-1,r-1);
        combination(n-1,r);
    }


}
