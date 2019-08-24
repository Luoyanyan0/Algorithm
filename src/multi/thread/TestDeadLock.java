package multi.thread;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 17:11 2019/8/20
 */
public class TestDeadLock implements Runnable{

    public static void main(String[] args) {
        TestDeadLock td = new TestDeadLock();
        new Thread(td,"张三").start();
        new Thread(td,"李四").start();
    }

    private Object o1 = new Object();
    private Object o2 = new Object();
    boolean flag = true;


    @Override
    public void run() {
        if (flag) {
            flag = false;
            while (true) {
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"获得o1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (o2) {
                        System.out.println(Thread.currentThread().getName()+"获得o2");
                    }
                }
            }
        } else {
            flag = true;
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"获得o2");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName()+"获得o1");
                }
            }
        }
    }
}
