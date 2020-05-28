package cn.even.bio;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * FileName: BIODemo
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/12 20:58
 * Description: 测试BIO
 */
@Slf4j
public class BIODemo {

    @Test
    public void BIOServer() throws IOException {
        //创建线程池
        ExecutorService service = Executors.newCachedThreadPool();

        //创建一个ServerSocket
        ServerSocket serverSocket = new ServerSocket(9999);

        log.info("服务器启动了");

        while (true) {
            //监听、等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            //创建一个线程，与客户端通信
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 处理客户端socket请求
     *
     * @param socket 客户端socket
     * @throws IOException IOException
     */
    public void handler(Socket socket) throws IOException {
        byte[] bytes = new byte[1024];

        //通过socket获得输入流
        InputStream inputStream = socket.getInputStream();

        //读取客户端发送的数据
        int read;
        while ((read = inputStream.read(bytes)) != -1) {
            //输出客户端发送的数据
            System.out.println(new String(bytes, 0, read));
        }

        inputStream.close();
        socket.close();
    }
}
