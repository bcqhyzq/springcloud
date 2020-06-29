package com.bcqh.springcloud8001.service;

import com.bcqh.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/26
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
