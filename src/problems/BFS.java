package problems;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: yanyan.luo
 * @Description: 广度优先遍历
 * @Date: Created in 10:17 2019/8/19
 */
public class BFS {
    @Test
    public void BFS() {
        int[][] matrix= {{0,1,1,0,0,0,0,0},{1,0,0,1,1,0,0,0},
                {1,0,0,0,0,1,1,0},{0,1,0,0,0,0,0,1},{0,1,0,0,0,0,0,1},
                {0,0,1,0,0,0,1,0},{0,0,1,0,0,1,0,0},{0,0,1,1,0,0,0,0}};
        String str = "ABCDEFGH";
        BFS bfs=new BFS();
        bfs.bfs(matrix, 'A', str);
    }

    private Queue<Integer> q;
    private Queue<Integer> visited;

    public BFS(){
        q = new LinkedList<>();
        visited = new LinkedList<>();
    }

    private int getIndex(char c, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    public void bfs (int[][] matrix, char c, String str) {
        int u = getIndex(c,str);

        q.offer(u);
        visited.offer(u);

        while (!q.isEmpty()) {
            int i = q.poll();
            System.out.print(str.charAt(i)+" ");

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1 && !visited.contains(j)) {
                    q.offer(j);
                    visited.offer(j);
                }
            }
        }

    }


}
