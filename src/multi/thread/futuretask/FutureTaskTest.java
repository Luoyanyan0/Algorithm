package multi.thread.futuretask;

import java.util.concurrent.*;

/**
 * @Author: yanyan.luo
 * @Description:
 * @Date: Created in 15:14 2019/8/2
 */
public class FutureTaskTest {
    private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();




    private String executionTask(final String taskName) throws InterruptedException, ExecutionException {
        while (true){
            Future<String> future = taskCache.get(taskName);
            if (future == null){
                Callable<String> task = new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                        return taskName;
                    }
                };

                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName,futureTask);
                if (future == null){
                    future = futureTask;
                    futureTask.run();
                }
            }

            try {
                return future.get();
            } catch (CancellationException e) {
                taskCache.remove(taskName,future);
            }
        }

    }
}
