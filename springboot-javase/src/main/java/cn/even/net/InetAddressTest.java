package cn.even.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * FileName: InetAddressTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/18 14:28
 * Description: ip地址测试
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("192.168.1.104");
        System.out.println(address);

        InetAddress address1 = InetAddress.getByName("www.wuxiipark.cn");
        System.out.println(address1);

        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

    }
}
