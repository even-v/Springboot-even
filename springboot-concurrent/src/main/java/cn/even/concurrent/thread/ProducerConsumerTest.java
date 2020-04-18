package cn.even.concurrent.thread;

import cn.even.concurrent.annotation.ThreadSafe;

/**
 * FileName: ProducerConsumerTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/18 10:38
 * Description: 生产者消费者问题
 * 生产者生产产品，将产品交给店员，消费者从店员处消费产品；店员处只能存放固定数量的产品；
 * 如果生产者试图生产较多的产品时，店员会叫生产者暂停生产，如果有空位时在通知生产者开始生产；
 * 如果店员没有产品时，店员会叫消费者暂停消费，如果有产品时在通知消费者开始消费
 * <p>
 * 1、多线程问题：生产者线程、消费者线程
 * 2、共享数据：店员的产品
 * 3、解决线程安全问题（同步代码块，同步方法，锁）
 * 4、涉及线程之间的通信
 */
@ThreadSafe
public class ProducerConsumerTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer p1 = new Producer(clerk);

        Consumer c1 = new Consumer(clerk);

        Thread t1 = new Thread(p1);
        t1.setName("生产者1");

        Thread t2 = new Thread(c1);
        t2.setName("消费者1");
        Thread t3 = new Thread(c1);
        t3.setName("消费者2");

        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 店员
 */
class Clerk {
    /**
     * 产品
     */
    private int product;

    /**
     * 生产产品
     */
    public synchronized void startProduce() {

        if (product < 20) {
            System.out.println(Thread.currentThread().getName() + ":开始生产" + (++product) + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消费产品
     */
    public synchronized void startConsum() {
        if (product > 0) {
            System.out.println(Thread.currentThread().getName() + ":开始消费" + (product--) + "个产品");
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer implements Runnable {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.startProduce();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true) {
            clerk.startConsum();
        }
    }
}


