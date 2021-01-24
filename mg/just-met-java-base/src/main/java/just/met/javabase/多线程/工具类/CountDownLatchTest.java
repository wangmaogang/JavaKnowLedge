package just.met.javabase.多线程.工具类;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();
        c.await();
        //必须等待上面的子线程执行完成后才能执行（即主线程执行c.await()，需要等待子线程执行c.countDown()直到c的计数为0）
        System.out.println("3");
    }
}