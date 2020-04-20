package cn.even.atomic;

import cn.even.concurrent.annotation.NotThreadSafe;

/**
 * FileName: LazyInitRace
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/20 21:05
 * Description: 延迟初始化中的静态条件
 */
@NotThreadSafe
public class LazyInitRace {

    private Object instance = null;

    public Object getInstance() {
        if (instance == null) {
            instance = new Object();
        }
        return instance;
    }
}
