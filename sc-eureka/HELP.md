# Getting Started

### Guides
The following guides illustrates how to use certain features concretely:

* [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery/)

在eureka中没有leader的概念，当一个eureka服务启动加入集群时会去同步其他注册中心的服务信息
springcloud alibaba 的nacos服务集群也是使用的这种策略