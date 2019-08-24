package multi.thread.connection.pool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:26 2019/7/25
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 保证所有的 ConnectionRunner 能够同时开始
     */
    static CountDownLatch start = new CountDownLatch(1);

    /**
     * main线程将会等待所有ConnectionRunner结束以后才能继续执行
     */
    static CountDownLatch end;


    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++){
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: "+(threadCount * count));
        System.out.println("got: "+got);
        System.out.println("notgot: "+notGot);
    }


    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(int count, AtomicInteger got, AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {

            }

            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException ex){
                        } finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                } finally {
                    count --;
                }
            }
            end.countDown();
        }
    }
}


