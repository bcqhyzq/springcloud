package com.bcqh.springcloud8002.mapper;

import com.bcqh.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/26
 */
@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
