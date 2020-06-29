package com.bcqh.springcloud8080.lib;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
@Component
public class MyLib implements LoadBalance {

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int next = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(next);
    }

    /**
     * 获取此时的连接次数
     * @return
     */
    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        }
        while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("这是第" + next + "次访问");
        return next;
    }
}
