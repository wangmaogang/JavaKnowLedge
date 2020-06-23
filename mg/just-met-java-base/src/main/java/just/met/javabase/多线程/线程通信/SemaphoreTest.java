package just.met.javabase.多线程.线程通信;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // 假设有50个同时来到酸奶店⻔⼝
        int nums = 50;
        // 酸奶店只能容纳10个⼈同时挑选酸奶
        Semaphore semaphore = new Semaphore(10);
        for (int i = 0; i < nums; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    // 有"号"的才能进酸奶店挑选购买
                    semaphore.acquire();
                    System.out.println("顾客" + finalI + "在挑选商品，购买...");
                    // 假设挑选了xx⻓时间，购买了
                    Thread.sleep(1000);
                    // 归还⼀个许可，后边的就可以进来购买了
                    System.out.println("顾客" + finalI + "购买完毕了...");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
