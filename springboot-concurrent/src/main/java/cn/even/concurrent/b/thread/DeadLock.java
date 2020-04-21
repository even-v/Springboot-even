package cn.even.concurrent.b.thread;

import cn.even.concurrent.a.annotation.NotRecommend;
import cn.even.concurrent.a.annotation.NotThreadSafe;

/**
 * FileName: DeadLock
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 21:21
 * Description: 死锁
 */
@NotThreadSafe
@NotRecommend
public class DeadLock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();


        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a1");

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s2) {
                        s2.append("b2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("c1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (s1) {
                        s2.append("d2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}
