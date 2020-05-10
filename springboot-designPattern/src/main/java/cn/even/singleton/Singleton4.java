package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。懒汉式-同步方法
 * <p>
 * 优点：解决线程安全方法
 * 缺点：效率低，每次调用getInstance都是同步的，实际只需要在对象创建时解决线程安全问题就行
 * 实际开发中，不推荐使用
 * </p>
 */
public class Singleton4 {
    /**
     * 1、构造方法私有化
     */
    private Singleton4() {
    }

    /**
     * 2、本类内部声明对象
     */
    private static Singleton4 singleton4;


    /**
     * 3、提供公有的静态方法，加入synchronized 同步方法
     *
     * @return 对象实例
     */
    public static synchronized Singleton4 getInstance() {
        if (singleton4 == null) {
            singleton4 = new Singleton4();
        }
        return singleton4;
    }
}
