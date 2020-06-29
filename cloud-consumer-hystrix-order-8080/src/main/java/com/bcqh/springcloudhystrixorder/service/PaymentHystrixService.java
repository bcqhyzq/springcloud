package com.bcqh.springcloudhystrixorder.service;

import com.bcqh.springcloudhystrixorder.fallback.PaymentHystrixFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentHystrixFallback.class)
public interface PaymentHystrixService {

    @GetMapping("/payment/ok/{id}")
    String paymentInfo_ok(@PathVariable("id") Long id);

    @GetMapping("/payment/timeOut/{id}")
    String paymentInfo_timeOut(@PathVariable("id") Long id);
}
