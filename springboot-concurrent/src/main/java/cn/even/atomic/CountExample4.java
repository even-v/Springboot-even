package cn.even.atomic;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * FileName: CountExample1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/19 19:56
 * Description: 多线程比较和修改
 */
public class CountExample4 {

    private static AtomicIntegerFieldUpdater<CountExample4> updater = AtomicIntegerFieldUpdater.newUpdater(CountExample4.class, "count");

    @Getter
    public volatile int count = 100;

    private static CountExample4 example4 = new CountExample4();

    public static void main(String[] args) {
        if (updater.compareAndSet(example4, 100, 120)) {
            System.out.println(example4.getCount());
        }

        if (updater.compareAndSet(example4, 100, 150)) {
            System.out.println(example4.getCount());
        } else {
            System.out.println("未执行");
        }

    }


}

