package com.bcqh.springcloudclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/29
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${config.port}")
    private String configInfo;

    @GetMapping("/get")
    public String getControllerInfo(){
        return configInfo;
    }
}
