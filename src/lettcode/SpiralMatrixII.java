package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @Date: Created in 16:56 2019/8/19
 */
public class SpiralMatrixII {

    @Test
    public void generateMatrix() {
        int n = 1;
        int[][] result = generateMatrix(n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]+"     ");
            }
            System.out.println();
        }
    }



    public int[][] generateMatrixII(int n) {
        int[][] res = new int[n][n];
        int ub = n * n;
        int minRow = 0, maxRow = n - 1;
        int minCol = 0, maxCol = n - 1;
        int value = 0;
        while (true) {
            for (int i = minCol; i <= maxCol; i++)
                res[minRow][i] = ++value;
            minRow++;
            if (value == ub)
                break;
            for (int i = minRow; i <= maxRow; i++)
                res[i][maxCol] = ++value;
            maxCol--;
            if (value == ub)
                break;
            for (int i = maxCol; i >= minCol; i--)
                res[maxRow][i] = ++value;
            maxRow--;
            if (value == ub)
                break;
            for (int i = maxRow; i >= minRow; i--)
                res[i][minCol] = ++value;
            minCol++;
            if (value == ub)
                break;
        }
        return res;
    }

    static int startNumber = 1;

    public int[][] generateMatrix(int n) {
        int temp = n % 2;
        int circle = temp == 0 ? n/2 : n/2 + 1;
        if (n == 1) {
            circle = 1;
        }

        int[][] matrix = new int[n][n];
        int rows = n, cols = n;
        for (int i = 0; i < circle; i++) {
            generateMatrixCore(matrix,rows,cols,i,i);
        }
        return matrix;
    }

    private void generateMatrixCore(int[][] matrix, int rows, int cols,
                                    int startRow, int startCol) {
        // 至少有一行一列
        if (rows > startRow && cols > startCol) {
            // 行不变，列变大
            for (int i = startCol; i < cols - startCol; i++) {
                matrix[startRow][i] = startNumber++;
            }
        }

        // 至少有两行一列
        if (rows > startRow + 1 && cols > startCol) {
            // 列不变，行变大
            for (int i = startRow + 1; i < rows - startRow; i++) {
                matrix[i][cols-startCol-1] = startNumber++;
            }
        }

        // 至少有两行两列
        if (rows > startRow + 1 && cols > startCol + 1) {
            // 行不变，列变小
            for (int i = cols-startCol-2; i >= startCol; i--) {
                matrix[rows-startRow-1][i] = startNumber++;
            }
        }


        // 至少有三行两列
        if (rows > startRow+2 && cols > startCol + 1) {
            // 列不变，行变小
            for (int i = rows-startRow-2; i >= startRow+1; i--) {
                matrix[i][startCol] = startNumber++;
            }
        }

    }
}
