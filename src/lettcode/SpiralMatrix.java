package lettcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yanyan.luo
 * @Description: 螺旋输出矩阵中的数值
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * @Date: Created in 16:56 2019/8/18
 */
public class SpiralMatrix {

    @Test
    public void spiralOrder () {
      //  int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};

        for (Integer i : spiralOrder(matrix)) {
            System.out.print(i+"  ");
        }
    }


    public List<Integer> spiralOrder(int[][] matrix) {


        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int circlr = rows % 2 == 0 ? rows/2 : rows/2 + 1;
        for (int i = 0; i < circlr; i++) {
            List<Integer> tempList = spiralOrderCore(matrix,rows,cols,i,i);
            list.addAll(tempList);
        }
        return list;
    }

    /**
     * @param matrix
     * @param rows
     * @param cols
     * @param startRow
     * @param startCol
     * @return
     */
    private List<Integer> spiralOrderCore(int[][] matrix, int rows, int cols, int startRow, int startCol) {
        List<Integer> circleList = new ArrayList<>();

        // 从左到右   行不变 列递增  i < cols-startCol   记住每一圈的终止位置是不一样的，绝对不能使用 i < cols
        // 最起码有一行一列
        if (rows -startRow > startRow && cols - startCol > startCol) {
            for (int i = startCol; i < cols - startCol; i++) {
                circleList.add(matrix[startRow][i]);
            }
        }

        // 从上到下  列不变  行变大
        // 最起码有两行一列
        if (rows - startRow > startRow + 1 && cols - startCol > startCol) {
            for (int i = startRow + 1; i < rows - startRow; i++) {
                circleList.add(matrix[i][cols - startCol - 1]);
            }
        }

        // 从右到左 行不变 列变小
        // 最起码有两行两列
        if (rows - startRow > startRow + 1 && cols - startCol > startCol + 1) {
            for (int i = cols - startCol - 2; i >= startCol; i--) {
                circleList.add(matrix[rows - startRow - 1][i]);
            }
        }

        // 从下到上  列不变   行变小
        // 最起码有三行两列
        if (rows - startRow > startRow + 2 && cols - startCol > startCol + 1) {
            for (int i = rows - startRow - 2; i >= startRow + 1; i--) {
                circleList.add(matrix[i][startCol]);
            }
        }
        return circleList;
    }
}
