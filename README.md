
监控页面:       
# http://localhost:6060 

注册中心: sc-eureka 
# http://localhost:8761

hystrix监控面板 sc-dashboard 
# http://localhost:9991/hystrix
打开后输入需要监控的端点, eg: 
# http://localhost:8083/actuator/hystrix.stream
当有请求到达@HystrixCommand注解的方法时，页面上就可以看到该接口的请求情况

网关zuul: 获取路由规则的接口
# http://localhost:7070/actuator/routes

配置中心
# https://github.com/hansinJ/sc-sl-tech 目录sc-parent下
当修改了配置文件需手动调用接口，完成热加载;
ip:port可以是接入了springcloud bus的任何一个服务，换句话讲，要完成配置文件热加载的服务，
都必须引入bus相关的包
# http://localhost:8081/actuator/bus-refresh

密码加密
# http://localhost:8085/encrypt?data=111111
解密 post请求
# http://localhost:8085/decrypt

    
todo:               
    1.缺少分布式架构下的事务一致性处理，后期引入seata解决(3pc)               
    2.缺少auth2.0标准的token验证  jwt较重，一般为auth2.0的自定义验证逻辑
                