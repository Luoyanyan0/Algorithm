package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/3/10 19:24
 * @Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor_8 {
    public int JumpFloor(int target) {
        int totalNumber = 0;
        if (target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        if (target >= 3){
            totalNumber =  JumpFloor(target - 1) + JumpFloor(target - 2);
        }
        return totalNumber;
    }

}
