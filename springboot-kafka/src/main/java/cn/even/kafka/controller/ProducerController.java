package cn.even.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * FileName: ProducerController
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/5/9 21:07
 * Description:
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Resource
    KafkaTemplate<String,Object> kafkaTemplate;

    @PostMapping("/send")
    public String sendMsg(@RequestBody String topic,@RequestBody String data){
        kafkaTemplate.send(topic,data );
        return "success";
    }

}
