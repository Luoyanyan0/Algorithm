package multi.thread;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 10:27 2019/7/24
 */
public class Waiting implements Runnable {
    @Override
    public void run() {
        while (true){
            synchronized (Waiting.class){
                try {
                    Waiting.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
