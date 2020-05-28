package cn.even.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * FileName: BufferDemo
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/10 16:20
 * Description: 测试缓冲区
 * capacity：容量
 * limit：界限，表示缓冲区可以操作数据的大小(limit后数据不能进行读写)
 * position：位置，表示缓冲区正在操作数据的位置
 */
public class BufferDemo {


    @Test
    public void test1() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("capacity = " + buffer.capacity());
        System.out.println("limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());

        String str = "abcdefg";

        //写数据
        buffer.put(str.getBytes());

        System.out.println("capacity = " + buffer.capacity());
        System.out.println("limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());

        //切换为读数据模式
        buffer.flip();

        System.out.println("capacity = " + buffer.capacity());
        System.out.println("limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());


        byte[] dst = new byte[buffer.limit()];
        //读数据值 byte 数组中
        buffer.get(dst);
        System.out.println(new String(dst));

        System.out.println("capacity = " + buffer.capacity());
        System.out.println("limit = " + buffer.limit());
        System.out.println("position = " + buffer.position());

        //重复读数据
        buffer.rewind();

        //清空缓冲区，但是数据还在，只是数据处于 “被遗忘” 状态
        buffer.clear();
    }
}
