package random;

import org.junit.Test;

/**
 * @Author: yanyan.luo
 * @Description: 数组中的数字是否是有效的数独
 *               每行每列数字不重复1~9   每个3*3棋格中包含1~9不重复数字
 * @Date: Created in 10:26 2019/8/9
 */
public class IsValidSudoku {
    @Test
    public void isValidSudoku(){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }


    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                board[i][j] = '.';
                if (c != '.') {
                    if (isValid(board, i, j, c)) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }


}
