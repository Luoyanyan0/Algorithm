package lettcode;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 顺时针旋转矩阵90度
 * @Date: Created in 11:37 2019/8/12
 */
public class Rotate {

    @Test
    public void rotate(){
        int[][] matrix = {{1,2,3},{4,5,6}, {7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++){
            for(int j = i; j < len - 1 - i; j++){
                swap(matrix,i,j,len-1-j,i);
                swap(matrix,len-1-j,i,len-1-i,len-1-j);
                swap(matrix,len-1-i,len-1-j,j,len-1-i);
            //    swap(matrix,j,len-1-i,i,j);
               /*int aux = matrix[i][j];
                matrix[i][j] = matrix[len-1 - j][i];
                matrix[len-1 - j][i] = matrix[len-1 - i][len-1 - j];
                matrix[len-1 - i][len-1 - j] = matrix[j][len-1 - i];
                matrix[j][len-1 - i] = aux;*/
            }
        }
    }

    private void swap(int [][] matrix, int r1, int c1, int r2, int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}
