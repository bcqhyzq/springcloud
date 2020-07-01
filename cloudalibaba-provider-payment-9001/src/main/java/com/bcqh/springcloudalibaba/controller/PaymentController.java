package com.bcqh.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/7/1
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/get/{id}")
    public String getServerPort(@PathVariable("id") Long id) {
        return "nacos register, serverPort: " + serverPort + "\t id: " + id;
    }
}
