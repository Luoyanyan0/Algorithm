package multi.thread.concurrentool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:11 2019/7/31
 */
public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";

                try {
                    // 如果注释掉其中一个exchange方法，程序就会一直等待
                    exgr.exchange(A);
                } catch (InterruptedException e) {

                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    String B = "银行流水B";
                    String A = exgr.exchange("B");
                    System.out.println("AB数据是否一致"+A.equals(B));
                    System.out.println("A:"+A +"  B:"+B);
                } catch (InterruptedException e) {

                }
            }
        });
        threadPool.shutdown();
    }
}
