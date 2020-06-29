package com.bcqh.springclou8004.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/payment")
public class ZkController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/get")
    public String getServerPort(){
        return "SpringCloud with zookeeper: " + serverPort +"\t" + UUID.randomUUID().toString();
    }
}
