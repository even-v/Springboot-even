package cn.even.singleton;

/**
 * FileName: Singleton1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     4/17/2020 2:15 PM
 * Description: 单例设计模式。枚举
 *
 * <p>
 * 优点：避免多线程问题、防止反序列化创建新的对象实例
 * 推荐使用
 * </p>
 */
public enum Singleton8 {
    INSTANCE;

    public void test() {
        System.out.println("hello china");
    }
}
