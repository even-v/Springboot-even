package cn.even.concurrent.c.atomic;

import lombok.Getter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * FileName: CountExample1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/19 19:56
 * Description: 多线程-只执行一次
 */
public class CountExample5 {
    /**
     * 客户端总数
     */
    private static int clientTool = 5000;

    /**
     * 同时并发线程数量
     */
    private static int threadTotal = 200;

    private static AtomicBoolean isHappen = new AtomicBoolean(false);


    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(threadTotal);
        CountDownLatch countDownLatch = new CountDownLatch(clientTool);
        for (int i = 0; i < clientTool; i++) {
            service.execute(() -> {
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        service.shutdown();
        System.out.println(isHappen);

    }

    private static void test() {
        if (isHappen.compareAndSet(false, true)) {
            System.out.println("execute()");
        }
    }

}

