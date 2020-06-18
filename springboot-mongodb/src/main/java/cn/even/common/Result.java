package cn.even.common;

/**
 * FileName: Result
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:39 AM
 * Description:
 */
public class Result {
    public Result() {
    }

    public static ResponseEntity success(Object data) {
        ResponseEntity entity = new ResponseEntity(true);
        entity.setData(data);
        return entity;
    }

    public static ResponseEntity success() {
        ResponseEntity entity = new ResponseEntity(true);
        return entity;
    }

    public static ResponseEntity failure(String msg) {
        ResponseEntity entity = new ResponseEntity(false);
        entity.setMsg(msg);
        return entity;
    }

    public static ResponseEntity failure(String msg, String code) {
        ResponseEntity entity = new ResponseEntity(false);
        entity.setMsg(msg);
        entity.setCode(code);
        return entity;
    }
}
