package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: m*n的矩阵
 * 机器人在矩阵的左上角，机器人每次只能向右或者向下走一步，终点是右下，
 * 有多少种走法。
 * @Date: Created in 19:38 2019/8/23
 */
public class UniquePaths {
    @Test
    public void uniquePaths() {
        int m = 3;
        int n = 3;
        System.out.println(uniquePathsII(m,n));
    }

    public int myUniquePaths(int m, int n) {
        // result[i][j]表示到从0,0到i，j这个点的走法
        int result[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = 0;
                int left = 0;
                if (i-1 >= 0) {
                    up = result[i-1][j];
                }
                if (j-1 >= 0) {
                    left = result[i][j-1];
                }

                result[i][j] = up+left;
                if (i == 0 && j == 0) {
                    result[i][j] = 1;
                }
            }
        }
        return result[m-1][n-1];
    }

    public int uniquePathsII(int m, int n) {
        // result[i][j]表示到从0,0到i，j这个点的走法
       int result[][] = new int[m][n];
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (i ==0 || j == 0) {
                   result[i][j] = 1;
               } else {
                   // 到i，j点有两种走法，上边，左边
                   result[i][j] = result[i-1][j] + result[i][j-1];
               }
           }
       }
       return result[m-1][n-1];
    }



    /**
     * 不能用static修饰，不然在lettcode中会报错
     */
    int count = 0;
    public int uniquePaths(int m, int n) {
        if (m ==0 && n == 0) {
            return 0;
        }
        uniquePathsCore(m,n,0,0);
        return count;
    }

    private void uniquePathsCore(int m, int n, int startRow, int startCol) {
        if (startRow == m-1 && startCol == n-1) {
            count++;
            return;
        }

        // m行n列
        if (startCol < n - 1) {
            // 向右走
            uniquePathsCore(m,n,startRow,startCol+1);
        }

        if (startRow < m - 1) {
            // 向下走
            uniquePathsCore(m,n,startRow+1,startCol);
        }
    }
}
