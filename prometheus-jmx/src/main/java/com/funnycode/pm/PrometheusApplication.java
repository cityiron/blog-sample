package com.funnycode.pm;

import com.funnycode.pm.jmx.ApiCount;
import com.funnycode.pm.jmx.CustomMBean;
import com.funnycode.pm.jmx.Registry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author tc
 * @date 2020/11/4
 */
@SpringBootApplication
public class PrometheusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class, args);
    }

    // config bean

    @Bean
    public ApiCount apiCount() {
        return new ApiCount();
    }

    @Bean
    public CustomMBean customMBean() {
        return new CustomMBean();
    }

    @Bean
    public Registry registry() {
        return new Registry();
    }

}
