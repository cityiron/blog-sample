package com.funnycode.pm.jmx;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author tc
 * @date 2020/11/3
 */
public class Registry {

    @Autowired
    private CustomMBean customMBean;

    @Autowired
    private ApiCount customMetrics;

    @PostConstruct
    public void start() {
        try {
            customMBean.registry(customMetrics);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
