package multi.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:34 2019/7/30
 */
public class AtomicIntegerTest {
    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        // 返回自增前的值
        System.out.println(ai.getAndIncrement());
        System.out.println(ai.get());
    }
}
