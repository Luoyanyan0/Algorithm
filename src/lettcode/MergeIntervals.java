package lettcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description: 合并数组中重叠部分
 * @Date: Created in 11:11 2019/8/19
 */
public class MergeIntervals {
    @Test
    public void merge() {
//        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = {{1,4},{0,2},{3,5}};
        int[][] result = merge(intervals);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " " + result[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0]));
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = new int[2];
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            list.add(temp);
        }

        for (int i = 1; i < list.size(); i++) {
            int start = 0;
            int end = 0;
            if (list.get(i-1)[1] >= list.get(i)[0] ) {
                if (list.get(i)[1] >= list.get(i-1)[1]) {

                    start = list.get(i-1)[0];
                    end = list.get(i)[1];

                    list.get(i-1)[0] = start;
                    list.get(i-1)[1] = end;

                    list.remove(i);
                    i = i - 1;
                } else {

                    start = list.get(i-1)[0];
                    end = list.get(i-1)[1];

                    list.remove(i);
                    i = i - 1;
                }
            }
        }

        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++){
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }

        return result;

    }
}
