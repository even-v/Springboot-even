package cn.even.concurrent.b.thread;

import java.util.concurrent.Callable;

/**
 * FileName: CallableThread
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/18 12:38
 * Description: CallableThread测试
 */
public class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i <= 100; i++) {
            sum += i;
            System.out.println(i);
        }
        return sum;
    }
}
