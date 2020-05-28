package cn.even.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * FileName: BlockingNIODemo
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/10 20:42
 * Description: 测试阻塞IO
 * 一、使用 NIO 完成网络通信的单个核心
 * 1.通道(Channel)：负责连接
 *
 * 2.缓冲区(Buffer)：负责数据的存储
 *
 * 3.选择器(selector)：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况
 */
public class BlockingNIODemo {

    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel channel=SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

        FileChannel inChannel=FileChannel.open(Paths.get("D:\\JavaSE.pdf"), StandardOpenOption.READ);

        //2.分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //3.读取本地文件，并发送至服务器
        while(inChannel.read(buffer)!=-1){
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }

        //4.关闭通道
        inChannel.close();
        channel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        FileChannel outChannel=FileChannel.open(Paths.get("D:\\JavaSE1.pdf"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2.绑定连接
        serverChannel.bind(new InetSocketAddress(9999));

        //3.获取客户端连接的通道
        SocketChannel socketChannel=serverChannel.accept();

        //4.分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //5.接受客户端的数据，并保存到本地
        while (socketChannel.read(buffer)!=-1){
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

        //6.关闭通道
        serverChannel.close();
        outChannel.close();
        socketChannel.close();
    }
}
