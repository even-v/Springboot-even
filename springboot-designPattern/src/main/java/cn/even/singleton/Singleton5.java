package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。懒汉式-同步创建对象代码块
 * <p>
 * 缺点：并没有解决线程安全问题，验证对象实例是否为空依然可能有多个线程同时进入
 * </p>
 */
public class Singleton5 {
    /**
     * 1、构造方法私有化
     */
    private Singleton5() {
    }

    /**
     * 2、本类内部声明对象
     */
    private static Singleton5 singleton5;


    /**
     * 3、提供公有的静态方法，加入synchronized 同步创建对象的代码块
     *
     * @return 对象实例
     */
    public static Singleton5 getInstance() {
        if (singleton5 == null) {
            synchronized (Singleton5.class) {
                singleton5 = new Singleton5();
            }
        }
        return singleton5;
    }
}
