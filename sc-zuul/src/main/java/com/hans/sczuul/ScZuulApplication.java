package com.hans.sczuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ScZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScZuulApplication.class, args);
    }

    /**
     * @description 路由动态刷新
     * 当请求接口刷新配置时，会收集@RefreshScope注解的类，
     * 销毁以前的bean，创建新的实例，将最新的配置装载进去
     **/
    @Bean
    @RefreshScope
    @ConfigurationProperties("zuul")
    @Primary
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
