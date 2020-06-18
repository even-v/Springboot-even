package cn.even.common;

import lombok.Data;

/**
 * FileName: ResponseEntity
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:32 AM
 * Description:
 */
@Data
public class ResponseEntity {
    private boolean success;
    private Object data;
    private String msg;
    private String token;
    private String code;

    ResponseEntity() {
        this(true);
    }

    ResponseEntity(boolean success) {
        this.success = success;
    }
}
