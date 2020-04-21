package cn.even.concurrent.c.atomic;

import cn.even.concurrent.a.annotation.ThreadSafe;
import lombok.Getter;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * FileName: CountingFactorizer
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/20 21:15
 * Description:对于多线程来说，操作count是原子性的
 */
@ThreadSafe
public class CountingFactorizer implements Servlet {

    @Getter
    private final AtomicLong count = new AtomicLong(0);


    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        count.incrementAndGet();
        req.getRequestDispatcher("").forward(req, res);
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
