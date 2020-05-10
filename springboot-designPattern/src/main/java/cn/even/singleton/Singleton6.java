package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。懒汉式-双重检查，第一次检查是否为null，为null则可能需要创建对象实例；
 * 第二次检查是否有多个线程且别的线程已经创建了实例，如果没有则需要创建实例
 * <p>
 * 优点：延时加载、线程安全、保证效率
 * 推荐使用
 * </p>
 */
public class Singleton6 {
    /**
     * 1、构造方法私有化
     */
    private Singleton6() {
    }

    /**
     * 2、本类内部声明对象
     */
    private static Singleton6 singleton6;


    /**
     * 3、提供公有的静态方法，加入synchronized 同步创建对象的代码块，并且双重检查
     *
     * @return 对象实例
     */
    public static Singleton6 getInstance() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}
