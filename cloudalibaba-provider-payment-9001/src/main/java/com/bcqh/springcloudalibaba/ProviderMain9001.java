package com.bcqh.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/7/1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9001.class, args);
    }
}
