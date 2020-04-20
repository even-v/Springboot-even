package cn.even.atomic;

import cn.even.concurrent.annotation.NotThreadSafe;
import lombok.Getter;

import javax.servlet.*;
import java.io.IOException;

/**
 * FileName: UnsafeCountingFactorizer
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/20 21:01
 * Description: 在没有同步的情况下统计已处理请求数量是Servlet，多线程操作count是非原子性的
 */
@NotThreadSafe
public class UnsafeCountingFactorizer implements Servlet {

    @Getter
    private long count = 0;


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        ++count;

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
