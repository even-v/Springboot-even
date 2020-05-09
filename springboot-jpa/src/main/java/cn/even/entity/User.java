package cn.even.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * FileName: User
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/26 9:29
 * Description:
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long  id;

    private String name;

}
