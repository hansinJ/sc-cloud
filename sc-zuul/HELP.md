# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/maven-plugin/)

目前市面上比较主流的网关框架: zuul gateway
zuul是springcloud项目的流量入口，理论上所有请求都要经过zuul过滤和分发。
zuul解决的问题:分布式部署项目的情况下，简化nginx配置，只需要配置zuul地址即可

获取路由规则的接口
http://localhost:7070/actuator/routes

zuul路由动态刷新
    利用配置中心实现不重启服务器的情况下，完成配置的动态刷新；
    原理:请求刷新接口，向mq中插入一条消息，由订阅消息的服务完成消息的消费；其消费其实就是收集
    @RefreshScope注解的类，从bean容器中销毁，并再创建，以达到刷新的目的



权限架构:
    第一种架构:
        zuul做权限校验，下游系统不做，下游系统部署在内网，防火墙配置白名单ip；
        过度依赖网络安全，不能保证内网一定安全。
    第二种架构:
        zuul不做权限校验，下游系统做权限校验;
        理论上zuul是网关，不包含资源，没必要做权限校验;

oauth2.0是一种权限校验的标准:
    1.客户端模式(appId,appSecret)
    2.密码模式
    3.授权码模式
    
    
            
        