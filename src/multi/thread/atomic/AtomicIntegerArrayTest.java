package multi.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:35 2019/7/30
 */
public class AtomicIntegerArrayTest {
    static int[] value = new int[] {1,2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        // 改变了ai的值
        System.out.println(ai.get(0));
        // value 是通过构造函数传入的，atomicIntegerArray会将这个数组拷贝一份，不会影响value原来的值
        System.out.println(value[0]);
    }
 }
