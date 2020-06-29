package com.bcqh.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:
 *
 * @author yzq
 * @date 2020/6/27
 */
@Configuration
public class RibbonRuleConfig {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
