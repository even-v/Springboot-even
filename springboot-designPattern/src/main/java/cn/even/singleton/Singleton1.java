package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。饿汉式-静态变量式
 * <p>
 * 优点：写法简单，类加载时就完成实例化，避免多线程同步问题
 * 缺点：类加载时完成实例化，没有达到懒加载(lazy loading)效果；如果对象一直未使用过，则会造成内存浪费
 * </p>
 */
public class Singleton1 {
    /**
     * 1、构造方法私有化
     */
    private Singleton1() {
    }

    /**
     * 2、本类内部创建对象实例
     */
    private static final Singleton1 singleton1 = new Singleton1();

    /**
     * 3、提供公有的静态方法，返回对象实例
     *
     * @return 对象实例
     */
    public static Singleton1 getInstance() {
        return singleton1;
    }
}
