package cn.even.concurrent.d.shareobject;

import cn.even.concurrent.a.annotation.ThreadSafe;



/**
 * FileName: MutableInteger
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/21 20:20
 * Description: 可变整数类
 */
@ThreadSafe
public class SynchronizedInteger {
    private int value;

    public synchronized void setValue(int value) {

        this.value = value;
    }

    public synchronized int getValue() {
        return value;
    }
}
