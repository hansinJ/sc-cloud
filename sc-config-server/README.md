配置中心:
1.抽取公共配置
2.配置文件的动态加载，热加载

springcloud的配置中心为半自动更新
# http://localhost:8085/actuator/refresh 固定刷新某一台，如果是集群将无法操作
服务集群 springcloud的解决方法是引入rabbitMq的广播机制，还是要调一次接口
# http://localhost:8085/actuator/bus-refresh
实际上就是向mq中插入一条消息，供订阅方消费

扩展点:
    这种在系统架构中引入mq的方式比较重，可以自定义redis/zk等为配置中心