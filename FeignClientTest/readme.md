Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果  
简而言之：  
Feign 采用的是基于接口的注解  
Feign 整合了ribbon，具有负载均衡的能力  
整合了Hystrix，具有熔断的能力(自带断路器的)  

----

断路器：
Hystrix 
- @EnableHystrixDashboard
- @EnableCircuitBreaker  
- 添加@Bean
- http://localhost:8001/hystrix  界面中添加 http://localhost:8001/actuator/hystrix.stream 做监控
新版本需要加上如下方法才能看到hystrix.stream
```
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
```
----

#### 路器聚合监控(Hystrix Turbine
看单个的Hystrix Dashboard的数据并没有什么多大的价值，要想看这个系统的Hystrix Dashboard数据就需要用到Hystrix Turbine。Hystrix Turbine将每个服务Hystrix Dashboard数据进行了整合  
- @EnableTurbine
- http://localhost:8001/hystrix  界面中添加 http://localhost:8001/turbine.stream 做监控
----
超时：使用Feign调用接口分两层，ribbon的调用和hystrix的调用，所以ribbon的超时时间和Hystrix的超时时间的结合就是Feign的超时时间
----
bean的配置：
FeignClientsConfiguration

----

feign.compression.request.enabled=true
feign.compression.response.enabled=true
Feign请求压缩为您提供与您为Web服务器设置的设置相似的设置：

feign.compression.request.enabled=true
feign.compression.request.mime-types=text/xml,application/xml,application/json
feign.compression.request.min-request-size=2048

配置详见
https://segmentfault.com/a/1190000011540107

feign.compression.request.mime-types [text/xml, application/xml, application/json]
支持的MIME类型列表。
feign.compression.request.min-request-size 2048
最小阈值内容大小



在Feign中，Client是一个非常重要的组件，Feign最终发送Request请求以及接收Response响应都是由Client组件来完成的。
Client在Feign源码中是一个接口，在默认情况下，Client的实现类是Client.Default。
Client.Default是由JDK的HttpURLConnection来实现网络请求的。这种情况下，由于缺乏连接池的支持，在达到一定流量的后服务肯定会出问题。
另外,Client还支持HttpClient和OkHttp来进行网络请求
<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-httpclient</artifactId>
    <version>9.4.0</version>
</dependency>

设置 feign.httpclient.enabled


<dependency>
    <groupId>io.github.openfeign</groupId>
    <artifactId>feign-okhttp</artifactId>
    <version>10.2.0</version>
</dependency>
 
feign.okhttp.enabled