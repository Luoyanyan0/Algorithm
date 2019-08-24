package test;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 19:56 2019/8/3
 */
public class Test2 {

    @Test
    public void getMax(){
        int[][] numbers = {{1,3,3},{2,4,9},{8,9,2}};
        System.out.println(getMax(numbers));
    }

    public int getMax(int[][] numbers){
        int max = 0;
        int rows = numbers.length;
        int cols = numbers[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                int before = 0;
                int temp = movingCount(i,j,numbers,rows,cols,before);
                if (temp > max){
                    max = temp;
                }
            }
        }
        return max;
    }

    public int movingCount(int row, int col, int[][] number,int rows, int cols,int before){
        if(rows <= 0 || cols <= 0 )
        {return 0;}
        //设置访问标记数组
        int count = movingCountCore(number, rows, cols,row, col,before);
        return count;
    }

    public int movingCountCore(int[][] number, int rows, int cols,int row, int col,int before) {
        int count = 0;
        if(row >= 0 && row < rows && col >= 0 && col < cols && number[row][col] > before){
            //已经访问过了，设置访问标记为1
            count = 1 + movingCountCore(number,rows, cols, row, col-1,number[row][col]) +
                    movingCountCore(number, rows, cols, row, col+1,number[row][col]) +
                    movingCountCore(number, rows, cols, row-1, col,number[row][col]) +
                    movingCountCore(number, rows, cols, row+1, col,number[row][col]);
        }
        return count;
    }
}
