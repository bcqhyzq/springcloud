package com.bcqh.springcloud8002.controller;

import com.bcqh.springcloud.pojo.CommonResult;
import com.bcqh.springcloud.pojo.Payment;
import com.bcqh.springcloud8002.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/26
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(200, "插入数据成功" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据失败", null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录" + id, null);
        }
    }

    @GetMapping("/lb")
    public String getServerPort(){
        return serverPort;
    }

}
