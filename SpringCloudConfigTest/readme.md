配置中心可以依赖于Eureka做高可用
#### server端
- application.propertis中添加eureka.client.serviceUrl.defaultZone=http://localhost:8889/eureka/
#### client端
- bootstrap.properties文件
```
spring.application.name=config-client
spring.cloud.config.label=master
spring.cloud.config.profile=dev
#spring.cloud.config.uri= http://localhost:8888/

eureka.client.serviceUrl.defaultZone=http://localhost:8889/eureka/
# 是否从配置中心读取文件
spring.cloud.config.discovery.enabled=true
# spring.cloud.config.discovery.serviceId 配置中心的servieId，即服务名
spring.cloud.config.discovery.serviceId=config-server
server.port=8881
```
