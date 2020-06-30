package com.bcqh.springboot3366.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/30
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${config.port}")
    private String configInfo;

    @GetMapping("/get")
    public String getControllerInfo() {
        return "serverPort: " + serverPort + " configInfo: " + configInfo;
    }
}
