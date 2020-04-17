package cn.even.concurrent.thread;

/**
 * FileName: Thread2
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:09
 * Description: 实现Runnable接口
 */
public class Thread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----线程在执行----");
    }
}
