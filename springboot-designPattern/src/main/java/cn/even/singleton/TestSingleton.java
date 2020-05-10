package cn.even.singleton;

/**
 * FileName: TestSingleton
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:17 PM
 * Description: 测试单例模式
 */
public class TestSingleton {
    public static void main(String[] args) {
        Singleton8 singleton1 = Singleton8.INSTANCE;
        Singleton8 singleton2 = Singleton8.INSTANCE;
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}
