package problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: yanyan.luo
 * @Description: dijistra算法  计算一个节点到其他节点的最短路径
 * @Date: Created in 15:41 2019/8/19
 */
public class MyDijkstra {

    public static void main(String[] args) {
        int[][] weight= {{0,-1,10,-1,30,100},{-1,0,5,-1,-1,-1},{-1,-1,0,50,-1,-1},{-1,-1,-1,0,-1,10},
                {-1,-1,-1,20,0,60},{-1,-1,-1,-1,-1,0}};
      //  String[] str= {"V1","V2","V3","V4","V5","V6"};
      //  int len=str.length;
        MyDijkstra dijkstra=new MyDijkstra();
        //依次让各点当源点，并调用dijkstra函数
        for(int i=0;i<weight.length;i++) {
            dijkstra.dijkstra(weight, i);
            System.out.println();
        }
    }



    private int getIndex(int[] distance, Queue<Integer> visited) {
        int k = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < distance.length; i++) {
            // 该结点没被访问过
            if (!visited.contains(i)) {
                // 该结点到当前节点距离最短
                if (distance[i] < min) {
                    min = distance[i];
                    k = i;
                }
            }
        }
        return k;
    }

    public void dijkstra (int[][] weight, int currentNode) {
        Queue<Integer> visited = new LinkedList<>();
        int[] distance = new int[weight.length];
        // 取出每一个当前节点到各个节点的距离
        for (int i = 0; i < weight[currentNode].length; i++) {
            if (weight[currentNode][i] == -1) {
                distance[i] = Integer.MAX_VALUE;
            } else {
                distance[i] = weight[currentNode][i];
            }
        }

        visited.offer(currentNode);
        // TODO 如果出现
        while (visited.size() < weight.length) {
            // 取出离当前节点最近节点的位置
            int k = getIndex(distance,visited);
            visited.offer(k);
            if (k != -1) {

                // 找到最短的距离
                for (int i = 0; i < distance.length; i++) {
                    // 有路径到达
                    if (weight[k][i] != -1) {
                        // 经过k到达i，比直接从currentNode到达i要近
                        if (distance[i] > distance[k] + weight[k][i]) {
                            // 更新distance
                            distance[i] = distance[k] + weight[k][i];
                        }
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i]+"  ");
        }
        return;

    }
}
