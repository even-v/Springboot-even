package cn.even.concurrent.b.thread;

/**
 * FileName: Thread
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:05
 * Description: 继承Thread类创建多线程
 */
public class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "----线程在执行----");
    }
}
