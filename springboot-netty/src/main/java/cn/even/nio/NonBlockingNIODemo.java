package cn.even.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Set;

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
public class NonBlockingNIODemo {

    @Test
    public void client() throws IOException {
        //1.获取通道
        SocketChannel channel=SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));

        //2.切换为非阻塞模式
        channel.configureBlocking(false);

        //3.分配指定大小的缓冲区
        ByteBuffer buffer=ByteBuffer.allocate(1024);

        //4.发送数据给客户端
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        channel.write(buffer);
        buffer.clear();

        channel.shutdownOutput();

        //接受服务器端反馈
        int len;
        while ((len=channel.read(buffer))!=-1){
            buffer.flip();
            System.out.println(new String(buffer.array(),0,len));
            buffer.clear();
        }

        //4.关闭通道
        channel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel serverChannel = ServerSocketChannel.open();

        //2.切换为非阻塞模式
        serverChannel.configureBlocking(false);

        //3.绑定连接
        serverChannel.bind(new InetSocketAddress(9999));

        //4.获取选择器
        Selector selector = Selector.open();

        //5.将通道注册到选择器上，并且指定“监听接收事件”
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询式获取选择器上已经“准备就绪”的时间
        while (selector.select()>0){
            //7.获取当前选择器中所有注册的“选择器（已就绪的监听事件）”
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            for (SelectionKey selectionKey : selectionKeys) {//8.准备“就绪”的事件
                //9.判断具体是什么事件准备就绪
                if (selectionKey.isAcceptable()) {

                    //10.接收就绪，获得客户端链接
                    SocketChannel socketChannel = serverChannel.accept();
                    //11.切换非阻塞模式
                    socketChannel.configureBlocking(false);

                    //12.将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //13.获取当前选择器上“读就绪”状态的通道
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    //14.读取数据
                    ByteBuffer buffer=ByteBuffer.allocate(1024);
                    int len;
                    while((len=socketChannel.read(buffer))!=-1){
                        buffer.flip();
                        System.out.println(new String(buffer.array(),0,len));
                        buffer.clear();
                    }
                }
                selectionKey.cancel();
            }
        }

        //6.关闭通道
        serverChannel.close();
    }
}
