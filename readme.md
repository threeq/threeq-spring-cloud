# ant-network

## docker 打包

```
./gradlew -p ant-network-rest buildDocker
```

## TODO

- [ ] docker
- [x] 熔断服务 hystrix api service
- [x] 监控服务 tuibine hystrix-dashboard
- [x] 边缘服务 zuul
- [x] zuul 动态加载路由
- [x] 注册／发现服务 eureka
- [x] 配置服务 config
- [ ] 安全服务器 security service
- [ ] UI
- [ ] 单元测试
- [ ] 集成测试
- [ ] CI/CD