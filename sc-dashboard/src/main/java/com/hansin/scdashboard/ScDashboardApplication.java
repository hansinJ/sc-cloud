package com.hansin.scdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Hans
 **/
@SpringBootApplication
// Greenwich.SR1版本的hystrix dashboard http://localhost:9991/hystrix访问404 ，
// Hoxton.SR1版本的可以访问
// 需要监控的端点（使用了hystrix组件的端点）：http://localhost:8083/actuator/hystrix.stream
@EnableDiscoveryClient
@EnableHystrixDashboard
public class ScDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScDashboardApplication.class, args);
    }

}
