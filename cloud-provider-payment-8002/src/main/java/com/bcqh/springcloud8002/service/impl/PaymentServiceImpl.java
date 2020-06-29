package com.bcqh.springcloud8002.service.impl;

import com.bcqh.springcloud8002.mapper.PaymentMapper;
import com.bcqh.springcloud.pojo.Payment;
import com.bcqh.springcloud8002.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/26
 */
@Service
public class PaymentServiceImpl implements PaymentService {


    private PaymentMapper paymentMapper;

    @Autowired
    public void setPaymentMapper(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    @Override
    public int create(Payment payment){
        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id){
        return paymentMapper.getPaymentById(id);
    }
}
