package cn.even.concurrent.b.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FileName: ThreadPoolTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/18 13:12
 * Description: 线程池测试
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);//可以存放10个线程的线程池

        service.execute(new Runnable() {//加入线程池并执行
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
            }
        });

        service.shutdown();//注销线程池
    }
}
