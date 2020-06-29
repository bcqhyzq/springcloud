package com.bcqh.springcloudzk80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/27
 */
@RestController
@RequestMapping("/consumer")
public class OrderZkController {

    private static final String INVOKE_URL ="http://cloud-provider-payment/payment/";

    private RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("payment/get")
    public String getInvokeUrl(){
        return restTemplate.getForObject(INVOKE_URL +"get",String.class);
    }
}
