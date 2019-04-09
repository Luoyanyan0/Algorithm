package test;

import java.util.LinkedList;

/**
 * @Auther: yanyan.luo
 * @Date: 2019/4/8 16:48
 * @Description:两个队列实现一个栈
 */
public class TwoQueueToStack {
    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        System.out.println(pop());
        push(4);
        System.out.println(pop());
    }

    static LinkedList<Integer> queue1 = new LinkedList<>();
    static LinkedList<Integer> queue2 = new LinkedList<>();

    public static void push(int node){
        queue1.offer(node);
    }

    public static int pop(){
        if (!queue1.isEmpty()){
            while (queue1.size() > 1){
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        }else if(!queue2.isEmpty()){
            while (queue2.size() > 1){
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
        return -1;
    }
}
