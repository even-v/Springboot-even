package cn.even.concurrent.b.thread;

import cn.even.concurrent.a.annotation.Recommend;
import cn.even.concurrent.a.annotation.ThreadSafe;

/**
 * FileName: SellTicket1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:12
 * Description: 线程安全-卖票(同步方法)
 */
@ThreadSafe
@Recommend
public class SellTicket4 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            sell();
            if (ticket <= 0) {
                break;
            }
        }
    }

    private synchronized void sell() {
        if (ticket > 0) {
            System.out.println(ticket--);
        }
    }
}
