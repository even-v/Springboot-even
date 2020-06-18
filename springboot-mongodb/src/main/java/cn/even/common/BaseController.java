package cn.even.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * FileName: BaseController
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:32 AM
 * Description:
 */
@Getter
public class BaseController<Facade> {

    @Autowired
    protected Facade facade;
}
