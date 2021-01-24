package just.met.javabase.多线程.lock;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    public void fair() {
        testLock(fairLock);
    }

    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(Lock lock) {
        // 启动5个Job
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Job(lock);
            thread.setName("线程" + i);
            thread.start();
        }
        countDownLatch.countDown();
    }

    /**
     * 自定义线程Job
     */
    private static class Job extends Thread {
        private final Lock lock;

        public Job(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            try {
                //等待countDownLatch计数为0时才执行，模拟并发操作
                countDownLatch.await();
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            // 连续2次打印当前的Thread和等待队列中的Thread
            for (int i = 0; i < 2; i++) {
                lock.lock();
                try {
                    //第一次打印
                    printThreads(lock);
                    //第二次打印
                    printThreads(lock);
                } finally {
                    lock.unlock();
                }
            }
        }

        /**
         * 打印当前状态
         *
         * @param lock 当前锁信息
         */
        private void printThreads(Lock lock) {
            System.out.println("now:" + Thread.currentThread().getName());
            Collection<Thread> threads = ((ReentrantLock2) this.lock).getQueuedThreads();
            StringBuilder stringBuilder = new StringBuilder();
            for (Thread thread : threads) {
                stringBuilder.append(thread.getName()).append(",");
            }
            System.out.println("wait:" + stringBuilder);
        }
    }

    /**
     * 自定义ReentrantLock
     */
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        public Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<Thread>(super.getQueuedThreads());
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    public static void main(String[] args) {
        FairAndUnfairTest fairAndUnfairTest = new FairAndUnfairTest();
        fairAndUnfairTest.unfair();
    }
}
