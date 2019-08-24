package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 矩阵左上角走到右下角，求走过格子和最小的路径
 * 1 3 1
 * 1 5 1
 * 4 2 1
 * 输出：7
 * @Date: Created in 10:46 2019/8/24
 */
public class MinimumPathSum {
    @Test
    public void minPathSum() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSumII(grid));
    }

    public int minPathSumII(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 在00的位置，无法参考左边或者上面的位置
                if (i == 0 && j == 0) {
                    result[i][j] = grid[i][j];
                } else if (i == 0 && j > 0) {
                    result[i][j] = result[i][j-1] + grid[i][j];
                } else if (i > 0 && j == 0) {
                    result[i][j] = result[i-1][j] + grid[i][j];
                } else {
                    result[i][j] = Math.min(result[i-1][j],result[i][j-1]) + grid[i][j];
                }
            }
        }
        return result[rows-1][cols-1];
    }

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 注意题目中说明矩阵中的元素是非负数，即矩阵中的数可以是0，
                // 因此需要将up初始值设置成负数，而不能设置成0
                int up = -1;
                int left = -1;
                if (i-1 >= 0) {
                    up = result[i-1][j];
                }

                if (j-1 >= 0) {
                    left = result[i][j-1];
                }

                if (up < 0 && left < 0) {
                    result[i][j] = grid[i][j];
                } else if (up < 0 && left >= 0) {
                    result[i][j] = grid[i][j] + left;
                } else if (up >= 0 && left < 0) {
                    result[i][j] = grid[i][j] + up;
                } else {
                    result[i][j] = grid[i][j] + (up < left ? up : left);
                }

            }
        }
        return result[rows-1][cols-1];
    }
}
