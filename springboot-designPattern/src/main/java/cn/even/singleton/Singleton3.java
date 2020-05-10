package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。懒汉式-线程不安全
 * <p>
 * 优点：懒加载，只能在单线程下使用
 * 缺点：多线程下不可以使用该方式(实际开发中不要使用该方式)
 * </p>
 */
public class Singleton3 {
    /**
     * 1、构造方法私有化
     */
    private Singleton3() {
    }

    /**
     * 2、本类内部声明对象
     */
    private static Singleton3 singleton3;


    /**
     * 3、提供公有的静态方法，若对象实例不存在则先创建对象实例,否则直接返回对象实例
     *
     * @return 对象实例
     */
    public static Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}
