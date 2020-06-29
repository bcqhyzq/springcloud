package com.bcqh.springcloudfeign80.controller;

import com.bcqh.springcloud.pojo.CommonResult;
import com.bcqh.springcloud.pojo.Payment;
import com.bcqh.springcloudfeign80.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@RestController
@RequestMapping("/consumer/payment")
public class OrderFeignController {

    private PaymentService paymentService;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    }

}
