package com.bcqh.springcloudzk80;

import com.bcqh.rule.RibbonRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/27
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-consumer-order",configuration = RibbonRuleConfig.class)
public class OrderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderZkMain80.class, args);
    }
}
