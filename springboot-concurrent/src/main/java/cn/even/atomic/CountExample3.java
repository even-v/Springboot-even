package cn.even.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * FileName: CountExample1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/19 19:56
 * Description: 多线程比较和修改
 */
public class CountExample3 {

    private static AtomicReference<Integer> count = new AtomicReference<>(0);


    public static void main(String[] args) {
        count.compareAndSet(0, 2);
        count.compareAndSet(1, 1);
        count.compareAndSet(2, 3);
        count.compareAndSet(1, 4);
        count.compareAndSet(3, 5);

        System.out.println(count.get());
    }


}

