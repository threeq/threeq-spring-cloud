# ant-network

## docker 打包

```
./gradlew -p ant-network-rest buildDocker
```

## TODO

- [ ] docker／docker-compose
- [x] 熔断服务 hystrix api service
- [x] 监控服务 tuibine hystrix-dashboard
- [x] 边缘服务 zuul
- [x] zuul 动态加载路由
- [ ] zuul 高可用（集群），【启动多个实例，A、前面做dns负载；B、加一层负载；C、客户端负载】
- [x] 注册／发现服务 eureka
- [x] eureka 高可用（集群），多个实例相互注册
- [x] 配置服务 config
- [x] config 高可用（集群），启动指向同一个 git 仓库的多个 config 微服务实例，注册到 eureka 中即可
- [ ] 安全服务器 security service
- [ ] UI
- [x] 单元测试
- [x] 集成测试
- [ ] CI/CD
- [ ] 日志收集 ELK
- [x] 服务调用跟踪 zipkin， 使用消息中间件收集数据 RabbitMq，ElasticSearch 做存储
- [ ] demo 实例

## 问题

1. 集群更新过后各个服务的注册表修改问题