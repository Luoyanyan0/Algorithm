package test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 13:32 2019/8/3
 */
public class Package01 {

    /*
     * 0-1背包问题：给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高
     *
     * 以下用一个问题作为案例
     * 挖矿问题
     * 5座金矿，每座金矿的储量不同，需要参与挖矿的工人数也不同。
     * 参与挖矿的总工人数是10，每座金矿要么全挖，要么不挖，不能
     * 派一半人挖一半矿。求应选择挖哪几座金矿，才能得到尽可能多的黄金，（求能挖的最多黄金）。
     * 金矿数据：1：500金/5人；     2：400/5；     3：300/4；    4：200/3；     5：350/3
     **/


    public static void main(String[] args) {
        // 工人数量（就是背包问题中的背包重量）
        int weight = 10;
        // 金矿数量（物品数量）
        int count = 5;
        // 每个金矿需要的人手（每件物品的重量）
        int[] weights = { 5, 5, 4, 3, 3 };
        // 每个金矿的价值（每件物品的价值）
        int[] costs = { 500, 400, 300, 200, 350 };
        System.out.println(dp(weight, count, weights, costs));
        System.out.println(dp2(weight, count, weights, costs));
    }

    /** 01背包问题模板
     打表，自底向上的求解问题，从小问题开始着手。时间复杂度 O(weight * count), 空间复杂度 O(weight);
     */
    public static int dp(int weight, int count, int[] weights, int[] costs) {
        int[] preLine = new int[weight + 1];
        int[] curLine = new int[weight + 1];

        // 先处理第一行
        for (int i = 0; i <= weight; i++)
            if (weights[0] <= i)
                preLine[i] = costs[0];

        // 基于上一行处理当前行，然后迭代，pre变cur
        for (int i = 1; i < count; i++) {
            for (int j = 0; j <= weight; j++)
                if (weights[i] <= j)
                    curLine[j] = Math.max(preLine[j], costs[i] + preLine[j - weights[i]]);
                else
                    curLine[j] = preLine[j];
            preLine = curLine.clone();
        }
        return curLine[10];
    }

    // 精简后的代码
    public static int dp2(int weight, int count, int[] weights, int[] costs) {
        int[] preLine = new int[weight + 1];
        int[] curLine = new int[weight + 1];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j <= weight; j++)
                if (weights[i] <= j)
                    curLine[j] = Math.max(preLine[j], costs[i] + preLine[j - weights[i]]);
            preLine = curLine.clone();
        }
        return curLine[10];
    }

    /**
     * 动态规划的过程如下：
     * 重量（工人数）： 	0 	1 	2	3	4	5	6	7	8	9	10
     * 物品1（金矿1） 	0	0	0	0	0	500 500 500 500 500 500
     * 物品2（金矿2） 	0	0	0	0	0	500 500 500 500 500 900
     * 物品3（金矿3）		0	0	0	0	300 500 500 500 500 800 900
     * 物品4（金矿4） 	0	0	0	200 300 500 500 500 700 800 900
     * 物品5（金矿5）		0	0	0	350 350 500 550 650 850 850 900
     */
}
