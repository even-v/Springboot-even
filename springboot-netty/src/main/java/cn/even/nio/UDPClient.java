package cn.even.nio;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.util.CharsetUtil;
import org.junit.Test;

import java.net.InetSocketAddress;



public class UDPClient {

    @Test
    public void test() throws InterruptedException {
        //创建于服务端就是连接操作，创建线程
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //开始客户端的服务，和管道的设置
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST,true)
//                    .option(ChannelOption.SO_RCVBUF, 2048 * 1024)// 设置UDP读缓冲区为2M
//                    .option(ChannelOption.SO_SNDBUF, 1024 * 1024)// 设置UDP写缓冲区为1M
                    .handler(new SimpleChannelInboundHandler<DatagramPacket>() {
                        @Override
                        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
                            String  body =  datagramPacket.content().toString(CharsetUtil.UTF_8);
                            System.out.println(body+"这是服务端发送的内容");
                            //这里接收到服务端发送的1内容
                        }
                    });
            //服务端绑定的管道的端口
            Channel ch = b.bind(23367).sync().channel();
            // 向网段类所有机器广播发UDP，这是想客户端发送内容
            ch.writeAndFlush(new DatagramPacket(
                    Unpooled.copiedBuffer("upd client test", CharsetUtil.UTF_8),
                    //地址
                    new InetSocketAddress(
//                            "192.168.0.103",23367
                            "47.110.67.2",23367
                    ))).sync();
            //如果超过长时间则表示超时
            if(!ch.closeFuture().await(1500)){
                System.out.println("查询超时！！！");
            }
        }
        finally {
            //优雅的关闭释放内存
            group.shutdownGracefully();
        }
    }



}