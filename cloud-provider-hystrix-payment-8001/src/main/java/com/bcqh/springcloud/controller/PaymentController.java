package com.bcqh.springcloud.controller;

import com.bcqh.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/timeOut/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Long id){
        return paymentService.paymentInfo_timeOut(id);
    }

    @GetMapping("/payment/cir/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
