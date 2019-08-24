package test;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution1 {

    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
    }

    static int count = 0;
    /** 默认是小根堆*/
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    /** 构造大根堆，默认是小根堆，所以要创建比较函数 */
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,
            new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });

    public static void Insert(Integer num) {
        if (count % 2 == 0) {
            // 将数放入小根堆中筛选
            minHeap.offer(num);
            int minNumber = minHeap.poll();

            // 将筛选后的数放入大根堆中
            maxHeap.offer(minNumber);

        } else {
            // 将数放入大根堆中筛选
            maxHeap.offer(num);
            int maxNum = maxHeap.poll();
            // 将数放入右边小根堆中
            minHeap.offer(maxNum);
        }
        //新增下一个数
        count ++;

    }

    public static Double GetMedian() {
        //偶数个数的时候，中位数等于（左边大根堆堆顶元素 + 右边小根堆堆顶元素）/2
        if(count % 2 == 0){
            //这里需要将两个相加的值转化成double，然后除以2，结果自然也就是double
            return (double) (maxHeap.peek() + minHeap.peek())/2;

            //奇数个元素的时候，直接取左边大根堆的堆顶元素即可
        }else {
            return (double) maxHeap.peek();
        }
    }





}