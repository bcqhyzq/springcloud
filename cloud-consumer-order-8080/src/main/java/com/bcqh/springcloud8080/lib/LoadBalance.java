package com.bcqh.springcloud8080.lib;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/28
 */
public interface LoadBalance {
    /**
     * 获取活的机器数的总数
     * @param serviceInstances
     * @return
     */
    ServiceInstance instance (List<ServiceInstance> serviceInstances);
}
