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
