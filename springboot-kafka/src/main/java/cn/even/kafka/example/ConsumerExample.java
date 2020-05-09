package cn.even.kafka.example;

import org.springframework.kafka.annotation.KafkaListener;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;


/**
 * FileName: ConsumerExample
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/9 21:10
 * Description: 消费者
 */
@Component
public class ConsumerExample {

    @KafkaListener(topics = {"demo"})
//    public void listen(Consumer){

//    }
}
