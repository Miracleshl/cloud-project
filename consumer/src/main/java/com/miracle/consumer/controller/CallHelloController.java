package com.miracle.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * CallHelloController
 * Simple Class description.
 *
 * @author SHL
 * @version 1.0
 * @date 2020/9/4
 **/
@RestController
public class CallHelloController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call")
    public String call() {
        ServiceInstance serviceInstance = loadBalancer.choose("service-producer");
        System.out.println("服务地址：" + serviceInstance.getUri());
        System.out.println("服务名称：" + serviceInstance.getServiceId());
        System.out.println(serviceInstance.getUri().getPath());
        //serviceInstance.getUri().toString() 已重写为返回可访问地址
        String callServiceResult = restTemplate.getForObject(serviceInstance.getUri().toString() + "/hello", String.class);
        return callServiceResult;
    }

}
