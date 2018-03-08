# threeq

## docker 打包

```
./gradlew -p threeq-rest buildDocker
```

## TODO

- [ ] docker／docker-compose
- [x] 熔断服务 hystrix api service
- [x] 监控服务 tuibine hystrix-dashboard
- [x] 边缘服务 zuul
- [x] zuul 动态加载路由
- [x] zuul 高可用（集群），启动多个实例。在实际项目中情况一和情况二可以同时使用
    1. 情况一：客户端注册到 eureka 时，客户端通过 eureka 查询多个 zuul 服务进行客户端负载（ribbon／feign）
    2. 情况二：客户端未注册到 eureka 时，A、前面做dns负载；B、加一层负载(nginx/haproxy等)；C、客户端负载
- [x] 注册／发现服务 eureka
- [x] eureka 高可用（集群），多个实例相互注册
- [x] 配置服务 config，使用 bus 作为配置刷新出发 /bus/refresh
- [x] config 高可用（集群），启动指向同一个 git 仓库的多个 config 微服务实例，注册到 eureka 中即可
- [ ] 安全服务器 security service
- [ ] UI
- [x] 单元测试
- [x] 集成测试
- [ ] CI/CD
- [ ] 日志收集 ELK / Grafana / flume / Kafka 
- [x] 服务调用跟踪 zipkin， 使用消息中间件收集数据 RabbitMq，ElasticSearch 做存储
- [ ] demo 实例
- [ ] Sidecar 整合非JVM服务，用于老系统升级方案
- [ ] 存储 ？？？

## 问题

1. 集群更新过后各个服务的注册表修改问题