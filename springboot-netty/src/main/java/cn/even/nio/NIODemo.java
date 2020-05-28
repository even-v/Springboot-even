package cn.even.nio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * FileName: NIODemo
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/15 21:09
 * Description: 测试NIO server-client
 */
@Slf4j
public class NIODemo {

    @Test
    public void server() throws IOException {

        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        //得到socket并绑定本地9999端口
        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(9999));

        //设置channel为非阻塞
        serverSocketChannel.configureBlocking(false);

        //得到一个Selector对象
        Selector selector = Selector.open();

        //把Channel注册到Selector上,监听事件为SelectionKey.OP_ACCEPT(连接)
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //等待1秒且监听的事件没有发生
            if (selector.select(1000) == 0) {
                log.info("等待了1秒，无连接"+System.currentTimeMillis());
                continue;
            }

            //获得监听事件的集合
            //如果返回数据大于0表示已获取到监听的事件
            Set<SelectionKey> selectionKeys = selector.selectedKeys();


            Iterator<SelectionKey> it=selectionKeys.iterator();
            while(it.hasNext()){
                SelectionKey  selectionKey=it.next();

                //连接事件
                if (selectionKey.isAcceptable()) {
                    //给该客户端生成一个SocketChannel
                    try {
                        SocketChannel socketChannel = serverSocketChannel.accept();

                        //设置为非阻塞
                        socketChannel.configureBlocking(false);

                        //将当前的socketChannel注册到selector,监听SelectionKey.OP_READ事件
                        //关联一个buffer
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //读数据事件
                if(selectionKey.isReadable()){
                    //通过key反向获取到channel
                    SocketChannel channel = (SocketChannel)selectionKey.channel();

                    //获取该channel关联的buffer
                    ByteBuffer buffer = (ByteBuffer)selectionKey.attachment();
                    try {
                        channel.read(buffer);
                        log.info("from client"+new String(buffer.array()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                //手动从集合中删除key
                selectionKeys.remove(selectionKey);
            }
        }
    }


    @Test
    public void client() throws IOException {

        //得到一个网络通道
        SocketChannel socketChannel=SocketChannel.open();

        //设置非阻塞
        socketChannel.configureBlocking(false);

        //创建服务器的ip和端口
        InetSocketAddress address=new InetSocketAddress(9999);

        if(!socketChannel.connect(address)){
            while (!socketChannel.finishConnect()){
                log.info("连接需要时间，客户端不会阻塞，可以做其他工作");
            }
        }
        log.info("连接成功");

        //buffer大小和字节数组的大小一致
        ByteBuffer buffer = ByteBuffer.wrap(" Hello even".getBytes());

        //发送数据，将buffer写入channel
        socketChannel.write(buffer);

        log.info("发送数据");
        System.in.read();

    }
}
