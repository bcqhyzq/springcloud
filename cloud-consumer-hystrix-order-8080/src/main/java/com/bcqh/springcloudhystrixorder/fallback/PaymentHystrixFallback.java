package com.bcqh.springcloudhystrixorder.fallback;

import com.bcqh.springcloudhystrixorder.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@Component
public class PaymentHystrixFallback implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Long id) {
        return "paymentInfo_ok 运行异常，请稍后重试，o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeOut(Long id) {
        return "paymentInfo_timeOut 运行异常，请稍后重试，o(╥﹏╥)o";
    }
}
