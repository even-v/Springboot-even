package cn.even.concurrent.d.shareobject;

/**
 * FileName: NoVisibility
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/21 20:03
 * Description: 不可见，一个线程的修改，另一个线程可能对其它线程的修改不可见
 */
public class NoVisibility {

    private static boolean ready;

    private static int number;

    public static void main(String[] args) {
        new Thread(() -> {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "--" + number);
        }).start();

        ready = true;
        number = 42;
    }

}
