package just.met.javabase.多线程.t3;


import java.util.concurrent.*;

/**
 * @author wangmaogang
 */
public class ThreadPoolTest2 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1,100,100, TimeUnit.SECONDS,new LinkedBlockingQueue<>(100));

        //创建单核心的线程池 - LinkedBlockingQueue
        //1、单核心线程池，最大线程也只有一个，这里的时间为 0 意味着无限的生命，不会被摧毁。
        //2、线程是相同的，任务都是一个一个的来，直到有空闲线程时，才会继续执行任务，否则都是等待状态。
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        //创建固定核心数的线程池，这里核心数 = 2 - LinkedBlockingQueue
        //1、传入一个固定的核心线程数，并且核心线程数等于最大线程数，而且它们的线程数存活时间都是无限的
        //2、对比 newSingleThreadPool，其实改变的也就是可以根据我们来自定义线程数的操作，比较相似
        //3、可以做到并发的下载，两个任务可以同时进行，并且所用的线程始终都只有两个，因为它的最大线程数等于核心线程数，不会再去创建新的线程
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);

        //创建一个自动增长的线程池 - SynchronousQueue
        //1、可以进行缓存的线程池，意味着它的线程数是最大的，无限的。
        //2、核心线程数为 0，要考虑线程的摧毁，因为不能够无限的创建新的线程，所以在一定时间内要摧毁空闲的线程
        //3、线程创建后可重复利用，处理任务的线程数量不足时会新创建线程
        //4、这种线程池创建时初始化的都是无界的值，一个是最大线程数，一个是任务的阻塞队列，都没有设置它的界限，这可能会出现问题
        ExecutorService executorService4 = Executors.newCachedThreadPool();

        //创建一个按照计划规定执行的线程池，这里核心数 = 2 - DelayedWorkQueue
        //1、计划性的线程池，就是在给定的延迟之后运行，或周期性地执行
        ExecutorService executorService3 = Executors.newScheduledThreadPool(2);

        //创建一个具有抢占式操作的线程池
        //1、它是一个并行的线程池，参数中传入的是一个线程并发的数量，这里和之前就有很明显的区别，前面4种线程池都有核心线程数、最大线程数等等，而这就使用了一个并发线程数解决问题
        //2、这个线程池不会保证任务的顺序执行，也就是 WorkStealing 的意思，抢占式的工作
        ExecutorService executorService5 = Executors.newWorkStealingPool();

    }

}
