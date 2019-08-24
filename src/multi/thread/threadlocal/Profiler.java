package multi.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 9:46 2019/7/25
 */
public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        @Override
      protected Long initialValue(){
            System.out.println("initial: "+System.currentTimeMillis());
          return System.currentTimeMillis();
      }
    };

    public static final void begin(){
        System.out.println("begin: "+System.currentTimeMillis());
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    public static final long end(){
        System.out.println("end: "+System.currentTimeMillis());
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("cost: "+Profiler.end());
    }
}
