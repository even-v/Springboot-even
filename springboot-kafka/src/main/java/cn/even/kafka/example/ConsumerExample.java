package cn.even.kafka.example;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
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
@Slf4j
public class ConsumerExample {

    @KafkaListener(topics = {"demo"},groupId = "0")
    public void listen(ConsumerRecord<String,Object> record) {
        log.info(record.topic() + ":" + record.key() + "=" + record.value());
    }
}
