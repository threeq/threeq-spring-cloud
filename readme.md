# threeq

## docker 打包

```
./gradlew -p threeq-rest buildDocker
```

## 说明
1. `server` 为基础服务，以容器方式独立运行
2. `libs` 为公共基础库，以 jar 方式放入发不到私服，其他项目 service 项目使用 gradle 管理其依赖版本。单元测试覆盖率 >95%
3. `service` 为业务服务，每个业务服务单独建立开发工程 

## TODO

- [ ] 全局上下文拦截器
- [ ] 公共依赖 jar 自动发布到私服【jenkins -> nexus】 
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
- [x] 单元测试
- [x] 集成测试
- [ ] docker／docker-compose
- [ ] CI/CD
- [ ] 日志收集 ELK / Grafana / flume / Kafka 
- [x] 服务调用跟踪 jaeger
- [x] demo 实例
- [ ] Sidecar 整合非JVM服务，用于老系统升级方案
- [ ] 存储 mongo / mysql， mybatis / jap
- [ ] 缓存 redis
- [ ] 分布式锁 redis

## 问题

1. 集群 eureka 更新过后各个服务的注册表修改问题