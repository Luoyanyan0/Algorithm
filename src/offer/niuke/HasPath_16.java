package offer.niuke;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/12 16:20
 * @Description:
 */
public class HasPath_16 {

    public static void main(String[] args) {
        char matrix[] = {'a','b','c','e','s','f','c','s','a','d','e','e'};
        int rows = 3;
        int cols =4;
        String str = "abcb";
        System.out.println(hasPath(matrix,rows,cols,str));
    }


    public static boolean hasPath(char[] matrix,int rows,int cols,String str){
         if (rows <= 0 || cols <= 0){
            return false;
        }
        int[] visited = new int[matrix.length];
        boolean hasPath = false;
        char[] charArray = str.toCharArray();
            for (int row = 0; row < rows; row++){
                for (int col = 0; col < cols; col++){
                hasPath = findPathCore(matrix,rows,cols,row,col,charArray,0,visited);
                if (hasPath){
                    return true;
                }
            }
        }
        return hasPath;
}

    public static boolean findPathCore(char[] matrix,int rows,int cols,int row,int col,char[] charArray,
                                int position,int[] visited){
        // 使用递归，因此不需要使用循环

        boolean hasPath = false;

        // 访问到字符串的最后一个字符了，说明全部匹配成功
        if (position == charArray.length){
            return true;
        }

        // 只有当前的字符匹配上的时候，才会考虑上下左右的路径是否匹配
        if (row >= 0 && row < rows && col >= 0 && col <cols && visited[row * cols + col] == 0 &&
                charArray[position] == matrix[row * cols + col]){
            ++position;
            visited[row * cols + col] = 1;

            // 向上 下 左 右
            hasPath = findPathCore(matrix,rows,cols,row - 1,col,charArray,position,visited) ||
                    findPathCore(matrix,rows,cols,row + 1,col,charArray,position,visited) ||
                    findPathCore(matrix,rows,cols,row,col - 1,charArray,position,visited) ||
                    findPathCore(matrix,rows,cols,row,col + 1,charArray,position,visited);

            if (hasPath == false){
                visited[row * cols + col] = 0;
                --position;
            }
        }

        return hasPath;
    }

}
