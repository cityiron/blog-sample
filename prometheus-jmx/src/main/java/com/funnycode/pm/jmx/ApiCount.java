package com.funnycode.pm.jmx;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author tc
 * @date 2020/11/3
 */
public class ApiCount implements ApiCountMBean {

    private final AtomicLong total = new AtomicLong();

    @Override
    public long getTotal() {
        return total.get();
    }

    public void increment() {
        total.incrementAndGet();
    }

}
