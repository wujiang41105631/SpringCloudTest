package com.xcn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: xupeng.guo
 * @date: 2019/6/18
 * @description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class RibbonClientTest {
    /**
     * ribbon 已经默认实现了这些配置bean：
     * <p>
     * IClientConfig ribbonClientConfig: DefaultClientConfigImpl
     * <p>
     * IRule ribbonRule: ZoneAvoidanceRule
     * <p>
     * IPing ribbonPing: NoOpPing
     * <p>
     * ServerList ribbonServerList: ConfigurationBasedServerList
     * <p>
     * ServerListFilter ribbonServerListFilter: ZonePreferenceServerListFilter
     * <p>
     * ILoadBalancer ribbonLoadBalancer: ZoneAwareLoadBalancer
     *
     * @param args
     */

    public static void main(String[] args) {
        SpringApplication.run(RibbonClientTest.class, args);
    }
}
