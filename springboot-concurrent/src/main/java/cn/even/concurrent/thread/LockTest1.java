package cn.even.concurrent.thread;

import cn.even.concurrent.annotation.Recommend;
import cn.even.concurrent.annotation.ThreadSafe;

import java.util.concurrent.locks.ReentrantLock;

/**
 * FileName: LockTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 21:39
 * Description: 测试Lock
 */
@ThreadSafe
@Recommend
public class LockTest1 implements Runnable {
    /**
     * 线程共享数据
     */
    private int ticket = 100;
    private ReentrantLock lock=new ReentrantLock();

    /**
     * 线程共享锁，不可一个线程一个锁
     */
    Object object = new Object();

    @Override
    public void run() {
        while (true) {
            try {

                lock.lock();
                Thread.sleep(10);
                if (ticket > 0) {
                    System.out.println(ticket--);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }


        }
    }
}
