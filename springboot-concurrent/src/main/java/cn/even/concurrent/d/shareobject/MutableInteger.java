package cn.even.concurrent.d.shareobject;

import cn.even.concurrent.a.annotation.NotThreadSafe;

/**
 * FileName: MutableInteger
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/21 20:20
 * Description: 可变整数类
 */
@NotThreadSafe
public class MutableInteger {
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
