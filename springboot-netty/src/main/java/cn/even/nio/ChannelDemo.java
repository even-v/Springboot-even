package cn.even.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * FileName: ChannelDemo
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/10 19:40
 * Description: 测试通道
 * 一、通道：用于源节点与目标节点的连接，在java NIO中负责缓冲区中数据的传输，Channel本身不存储数据，因此需要配合缓冲区进行传输
 * <p>
 * 二、通道的主要实现类
 * java.nio.channels.Channel接口
 * |--FileChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * 三、获取通道
 * 1.java针对支持通道的类提供了getChannel()方法
 * 本地IO：
 * FileInputStream/FileOutputStream
 * RandomAccessFile
 * <p>
 * 网络IO：
 * Socket
 * ServletSocket
 * DatagramSocket
 * 2.在jdk1.7中的NIO2针对各个通道提供了静态方法open()
 * 3.在jdk1.7中的NIO2的Files工具类的 newByteChannel()方法
 */
public class ChannelDemo {

    /**
     * 输出数据
     *
     * @throws IOException 异常
     */
    @Test
    public void test1() throws IOException {
        //获得文件输出流
        FileOutputStream outputStream = new FileOutputStream("D:\\a.txt");

        //获得通道
        FileChannel channel = outputStream.getChannel();

        //创建并分配一定空间的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读数据
        buffer.put("hello,你好".getBytes());

        //转换为写数据
        buffer.flip();

        //写数据
        channel.write(buffer);

        outputStream.close();

    }

    /**
     * 输入数据
     */
    @Test
    public void test2() throws IOException {
        FileInputStream inputStream = new FileInputStream("D:\\a.txt");
        //获得通道
        FileChannel channel = inputStream.getChannel();

        //创建并分配一定空间的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //将通道的数据读入buffer
        channel.read(buffer);

        //将字节数组数据转为字符串
        System.out.println(new String(buffer.array()));
        inputStream.close();
    }

    /**
     * 复制文件
     */
    @Test
    public void test3() throws IOException {
        //输入流、通道
        FileInputStream inputStream = new FileInputStream("D:\\a.txt");
        FileChannel channel = inputStream.getChannel();

        //输出流、通道
        FileOutputStream outputStream = new FileOutputStream("D:\\b.txt");
        FileChannel fileChannel = outputStream.getChannel();

        //字节数组
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        int len;
        while ((len = channel.read(buffer)) != -1) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }
        //关闭流
        fileChannel.close();
        outputStream.close();
        channel.close();
        inputStream.close();
    }


    /**
     * 使用调用transferFrom拷贝文件
     */
    @Test
    public void test4() throws IOException {
        //输入流、通道
        FileInputStream inputStream = new FileInputStream("D:\\a.txt");
        FileChannel inChannel = inputStream.getChannel();

        //输出流、通道
        FileOutputStream outputStream = new FileOutputStream("D:\\b.txt");
        FileChannel outChannel = outputStream.getChannel();

        //调用transferFrom
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        //关闭资源
        outChannel.close();
        inChannel.close();
        outputStream.close();
        inChannel.close();
    }

    /**
     * MappedByteBuffer可以让文件直接在内存修改，操作系统不需要拷贝一次
     */
    @Test
    public void test5() throws IOException {

        RandomAccessFile accessFile=new RandomAccessFile("D:\\a.txt","rw" );
        FileChannel channel = accessFile.getChannel();

        //参数1：表示读写模式
        //参数2：表示可以修改的起始位置
        //参数3：是映射到内存的大小
        //可以修改的范围是0-5(起始位置，起始位置+映射到内存的大小)
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        map.put(0,(byte)'H');
        map.put(1,(byte)'A');
        map.put(2,(byte)'S');
        map.put(3,(byte)'D');
        map.put(4,(byte)'F');

        channel.close();
        accessFile.close();
    }
}
