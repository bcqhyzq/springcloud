package com.bcqh.springcloud8080.controller;

import com.bcqh.springcloud.pojo.CommonResult;
import com.bcqh.springcloud.pojo.Payment;
import com.bcqh.springcloud8080.lib.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/26
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderController {

    private RestTemplate restTemplate;

    private LoadBalance loadBalance;

    private DiscoveryClient discoveryClient;

    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT/payment/";

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    public void setLoadBalance(LoadBalance loadBalance) {
        this.loadBalance = loadBalance;
    }

    @Autowired
    public void setDiscoveryClient(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "create", payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "get/" + id, CommonResult.class);
    }

    @GetMapping("/lb")
    public String getPaymentUrl() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        if (instances == null || instances.size() < 0){
            return null;
        }else {
            ServiceInstance instance = loadBalance.instance(instances);
            URI uri = instance.getUri();
            /*System.out.println(uri);*/
            return restTemplate.getForObject(uri+"/payment/lb",String.class);
        }
    }

}
