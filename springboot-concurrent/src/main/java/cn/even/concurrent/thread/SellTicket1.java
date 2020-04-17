package cn.even.concurrent.thread;

import cn.even.concurrent.annotation.NotRecommend;
import cn.even.concurrent.annotation.NotThreadSafe;

/**
 * FileName: SellTicket1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/17 20:12
 * Description: 线程不安全-卖票
 */
@NotThreadSafe
@NotRecommend
public class SellTicket1 implements Runnable{
    private int ticket=100;

    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(ticket--);
            }else{
                break;
            }
        }
    }
}
