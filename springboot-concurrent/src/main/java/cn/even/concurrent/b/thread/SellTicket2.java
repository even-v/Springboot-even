package cn.even.concurrent.b.thread;

import cn.even.concurrent.a.annotation.Recommend;
import cn.even.concurrent.a.annotation.ThreadSafe;

/**
 * FileName: SellTicket1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:12
 * Description: 线程安全-卖票(实现Runnable接口)
 */
@ThreadSafe
@Recommend
public class SellTicket2 implements Runnable {
    /**
     * 线程共享数据
     */
    private int ticket = 100;

    /**
     * 线程共享锁，不可一个线程一个锁
     */
    Object object = new Object();

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
