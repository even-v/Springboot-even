package cn.even.concurrent.b.thread;

import cn.even.concurrent.a.annotation.NotRecommend;
import cn.even.concurrent.a.annotation.NotThreadSafe;

/**
 * FileName: SellTicket1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:12
 * Description: 线程不安全-卖票(继承Thread类)
 */
@NotThreadSafe
@NotRecommend
public class SellTicket3 extends Thread {
    /**
     * 线程共享数据
     */
    private int ticket = 100;

    /**
     * 线程共享锁，不可一个线程一个锁，该方式不安全，因为每个线程都会创建Object对象
     */
    Object object = new Object();

    /**
     * 线程共享锁，不可一个线程一个锁，该方式安全，因为每个线程的Object对象都相同
     */
//    static Object object = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {
                    System.out.println(ticket--);
                } else {
                    break;
                }
            }
        }
    }
}
