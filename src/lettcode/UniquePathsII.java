package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 走矩阵，从左上角到右下角   中间会设置障碍
 * @Date: Created in 20:43 2019/8/23
 */
public class UniquePathsII {
    @Test
    public void uniquePathsWithObstacles() {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        if (rows == 0 || cols == 0) {
            return 0;
        }

        int[][] result = new int[rows][cols];
       /* int tag;
        if (obstacleGrid[0][0] == 1) {
            tag = 0;
        } else {
            tag = 1;
        }*/

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                   /* int up = 0;
                    int left = 0;
                    if (i-1 >= 0) {
                        up = result[i-1][j];
                    }
                    if (j-1 >= 0) {
                        left = result[i][j-1];
                    }
                    result[i][j] = up + left;
                    if (i == 0 && j == 0) {
                        result[i][j] = tag;
                    }*/

                   if (i == 0 && j == 0) {
                       result[i][j] = 1;
                   } else if (i == 0 && j > 0) {
                       result[i][j] = result[i][j-1];
                   } else if (i > 0 && j == 0) {
                       result[i][j] = result[i-1][j];
                   } else {
                       result[i][j] = result[i-1][j] + result[i][j-1];
                   }

                }
            }
        }
        return result[rows-1][cols-1];
    }
}
