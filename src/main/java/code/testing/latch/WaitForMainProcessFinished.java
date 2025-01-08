package code.testing.latch;

import java.util.concurrent.CountDownLatch;

public class WaitForMainProcessFinished {

    public static void run() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // 設置計數器為 3

        // 創建三個工作線程
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is working");
                    Thread.sleep(1000); // 模擬工作
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown(); // 工作完成，計數器減 1
                    System.out.println(Thread.currentThread().getName() + " finished");
                }
            }).start();
        }

        System.out.println("Main thread is waiting for workers to finish...");
        latch.await(); // 主線程等待計數器歸零
        System.out.println("All workers finished. Main thread continues.");
    }
}
