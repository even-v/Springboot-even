package cn.even;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * FileName: App
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:23 AM
 * Description: 启动类
 */
@SpringBootApplication
@MapperScan(value = {"cn.even.kingsum.mapper"})
@EnableScheduling
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
