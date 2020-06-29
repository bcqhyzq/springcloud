package com.bcqh.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@Service
public class PaymentService {

    public String paymentInfo_ok(Long id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_ok " + id +"(*^▽^*)";
    }
    
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public String paymentInfo_timeOut(Long id){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {

        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeOut " + id +"(*^▽^*)";
    }

    public String paymentInfo_timeOutHandler(Long id){
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_timeOut " + id +"o(╥﹏╥)o";
    }

    // 服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), // 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") // 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Long id){
        if (id < 0){
            throw  new RuntimeException("***********id,不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功，流水号：" +simpleUUID;
    }

    public String paymentCircuitBreakerFallback(Long id){
        return "id不能为负数，请稍后重试，o(╥﹏╥)o";
    }
}
