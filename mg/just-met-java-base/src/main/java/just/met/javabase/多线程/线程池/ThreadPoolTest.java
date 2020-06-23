package just.met.javabase.多线程.线程池;


import java.util.concurrent.*;

/**
 * @author wangmaogang
 *
 * 打印结果为 0
 * 虽然最大线程数有100但核心线程数为1，任务队列为100。
 * 满足了 '当线程数大于等于核心线程数，且任务队列未满时，将任务放入任务队列。' 这个条件。
 * 所以后续添加的任务都会被堵塞。
 */
public class ThreadPoolTest {

    private static ThreadPoolExecutor executor =
            new ThreadPoolExecutor(1,100,100, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));

    public static void main(String[] args) {

        for(int i = 0 ; i < 5 ; i++){
            final int targetNum = i;
            executor.execute(()->{
                System.out.println(targetNum);
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
