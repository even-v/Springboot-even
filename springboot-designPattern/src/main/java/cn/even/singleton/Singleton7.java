package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。静态内部类
 * 外部类加载时，静态内部类不会立即加载；类(静态内部类)加载时是线程安全的
 * <p>
 * 优点：延时加载、线程安全、保证效率
 * 推荐使用
 * </p>
 */
public class Singleton7 {
    /**
     * 1、构造方法私有化
     */
    private Singleton7() {
    }

    /**
     * 2、静态内部类，实例化对象的实例
     */
    private static class Singleton7Instance {
        private static final Singleton7 singleton7 = new Singleton7();
    }


    /**
     * 3、提供公有的静态方法，返回静态内部类创建的对象
     *
     * @return 对象实例
     */
    public static Singleton7 getInstance() {
        return Singleton7Instance.singleton7;
    }
}
