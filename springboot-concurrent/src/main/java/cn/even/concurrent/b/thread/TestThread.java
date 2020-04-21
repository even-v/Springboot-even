package cn.even.concurrent.b.thread;


import java.util.concurrent.FutureTask;

/**
 * FileName: TestThread
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:06
 * Description: 测试多线程
 */
public class TestThread {
    public static void main(String[] args) {
        callableTest();
        // System.out.println(Thread.currentThread().getName()+"在执行----");
    }

    public static void testThread1() {
        Thread1 t1 = new Thread1();
        t1.start();
    }

    public static void testThread2() {
        Thread2 t1 = new Thread2();
        Thread2 t2 = new Thread2();

        Thread t01 = new Thread(t1);
        Thread t02 = new Thread(t2);
        t01.start();
        t02.start();
    }

    public static void sellTicket1() {
        SellTicket1 t1 = new SellTicket1();

        Thread t01 = new Thread(t1);
        Thread t02 = new Thread(t1);
        Thread t03 = new Thread(t1);
        Thread t04 = new Thread(t1);
        t01.start();
        t02.start();
        t03.start();
        t04.start();
    }

    public static void sellTicket2() {
        SellTicket2 t1 = new SellTicket2();

        Thread t01 = new Thread(t1);
        Thread t02 = new Thread(t1);
        Thread t03 = new Thread(t1);
        Thread t04 = new Thread(t1);
        t01.start();
        t02.start();
        t03.start();
        t04.start();
    }

    public static void sellTicket3() {
        SellTicket3 t1 = new SellTicket3();
        SellTicket3 t2 = new SellTicket3();
        SellTicket3 t3 = new SellTicket3();

        t1.start();
        t2.start();
        t3.start();
    }

    public static void sellTicket4() {
        SellTicket4 t1 = new SellTicket4();

        Thread t01 = new Thread(t1);
        Thread t02 = new Thread(t1);
        Thread t03 = new Thread(t1);
        Thread t04 = new Thread(t1);
        t01.start();
        t02.start();
        t03.start();
        t04.start();
    }

    public static void lockTest1() {
        LockTest1 t1 = new LockTest1();

        Thread t01 = new Thread(t1);
        Thread t02 = new Thread(t1);
        Thread t03 = new Thread(t1);
        Thread t04 = new Thread(t1);
        t01.start();
        t02.start();
        t03.start();
        t04.start();
    }

    public static void callableTest() {
        CallableThread ct = new CallableThread();
        FutureTask<Integer> task = new FutureTask<>(ct);
        new Thread(task).start();

        try {
            int result = task.get();
            System.out.println("result=" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
