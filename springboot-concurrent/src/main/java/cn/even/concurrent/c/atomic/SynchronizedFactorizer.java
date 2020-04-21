package cn.even.concurrent.c.atomic;

import cn.even.concurrent.a.annotation.NotRecommend;
import cn.even.concurrent.a.annotation.ThreadSafe;

import javax.servlet.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * FileName: UnsafeCountingFactorizer
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     2020/4/20 21:01
 * Description: 有原子性的保证，能正确的缓存最新的计算结果，但是并发性非常糟糕，不推荐这种写法
 */
@ThreadSafe
@NotRecommend
public class SynchronizedFactorizer implements Servlet {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<>();
    private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<>();


    @Override
    public synchronized void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        BigInteger i = extractFormRequest(req);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse(res, lastFactors.get());
        } else {
            BigInteger[] factors = factor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            encodeIntoResponse(res, factors);
        }
    }

    private BigInteger[] factor(BigInteger i) {
        return null;
    }

    private void encodeIntoResponse(ServletResponse res, BigInteger[] bigIntegers) {
    }

    private BigInteger extractFormRequest(ServletRequest req) {
        return null;
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
