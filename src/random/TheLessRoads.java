package random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/9 11:23
 * @Description:加油站到各个站点之间的直线路径，最少有多少条
 * 3 [0,0] [[1,1],[-1,1],[2,3]]   output:3
 *
 * 6 [0,0] [[2,2],[3,3],[-4,8],[8,8],[-1,-1],[5,8]]  output:3
 */
public class TheLessRoads {

    public static void main(String[] args) {
        int stationNum = 6;
        int[] oilPostition = {0,0};
        List<List<Integer>> stationPositions = new ArrayList<>();
        List<Integer> station1 = new ArrayList<>();
        station1.add(2); station1.add(2);

        List<Integer> station2 = new ArrayList<>();
        station2.add(3); station2.add(3);

        List<Integer> station3 = new ArrayList<>();
        station3.add(-4); station3.add(8);

        List<Integer> station4 = new ArrayList<>();
        station4.add(8); station4.add(8);

        List<Integer> station5 = new ArrayList<>();
        station5.add(-1); station5.add(-1);

        List<Integer> station6 = new ArrayList<>();
        station6.add(5); station6.add(8);

        stationPositions.add(station1);
        stationPositions.add(station2);
        stationPositions.add(station3);
        stationPositions.add(station4);
        stationPositions.add(station5);
        stationPositions.add(station6);

        System.out.println(theLessRoads(stationNum,oilPostition,stationPositions));
    }

    public static int theLessRoads(int stationNum, int[] oilPostition,
                            List<List<Integer>> stationPositions){
        Set<Double> roadNums = new HashSet<>();
        // 算出斜率，斜率相同的就是一条路线
        // 将斜率直接放在set中，最后算出set的size
        for (List<Integer> stationPosition : stationPositions){
            double graident = (double) (stationPosition.get(1) - oilPostition[1]) /
                    (double) (stationPosition.get(0) - oilPostition[0]);
            roadNums.add(graident);
        }
    return roadNums.size();
    }
}
