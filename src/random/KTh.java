package random;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一个无序的数组，找出其中最大的K个数
 */
public class KTh {

    public static void main(String[] args) {
        int arrsy[] = {4,8,6,8,1,2,3,45,4,1,2,8};
        int k = 6;
        System.out.println(thtKTh(arrsy,k));
    }

    // 使用堆   priorityQueue就是使用堆实现的
    public static int thtKTh(int[] array, int k){
        if (k > array.length || k <= 0){
            return -1;
        }
        // priorityqueue默认是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 先生成一个包含K个节点的小根堆
        for (int i = 0; i < k; i++){
            heap.add(array[i]);
        }
        for (int j = k; j < array.length; j++){
            // 新元素大于堆顶元素，剔除堆顶元素
            if (array[j] > heap.peek()){
                heap.poll();
                heap.add(array[j]);
            }
        }
        return heap.peek();
    }

    /**
     * 求无序数组中最小的第K个数
     * @return
     * 使用大根堆
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k <= 0 || k > input.length){
            return null;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < k; i++){
            bigHeap.add(input[i]);
        }

        // 检查新的元素是否小于堆顶元素
        for (int j = k ; j < input.length; j++){
            if (input[j] < bigHeap.peek()){
                bigHeap.poll();
                bigHeap.add(input[j]);
            }
        }

        for (int m : bigHeap){
            list.add(m);
        }
        return list;
    }

}

