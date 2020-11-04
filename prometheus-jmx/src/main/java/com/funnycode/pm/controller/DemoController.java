package com.funnycode.pm.controller;

import com.funnycode.pm.jmx.ApiCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tc
 * @date 2020/11/3
 */
@RestController
public class DemoController {

    @Autowired
    private ApiCount apiCount;

    @GetMapping(path = "/add")
    public String add() {
        apiCount.increment();
        return String.valueOf(apiCount.getTotal());
    }

}
