package com.bcqh.springcloudhystrixorder.controller;

import com.bcqh.springcloudhystrixorder.service.PaymentHystrixService;
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
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("/consumer/payment/timeOut/{id}")
    public String paymentInfo_timeOut(@PathVariable("id") Long id){
        return paymentHystrixService.paymentInfo_timeOut(id);
    }

}
