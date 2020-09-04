package com.miracle.consumer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ServiceController
 * Simple Class description.
 *
 * @author SHL
 * @version 1.0
 * @date 2020/9/4
 **/
@RestController
public class ServiceController {
    @Autowired
    private LoadBalancerClient loadBalancer;
    @Autowired
    private DiscoveryClient discoveryClient;

    private static final ObjectMapper mapper = new ObjectMapper();


    /**
     * 获取所有服务
     */
    @GetMapping("/services")
    public String services() {
        try {
            return mapper.writeValueAsString(discoveryClient.getInstances("service-producer"));
        } catch (JsonProcessingException e) {
            return "解析错误";
        }
    }

    /**
     * 从所有服务中选择一个服务（轮询）
     */
    @GetMapping("/discover")
    public Object discover() {
        try {
            return mapper.writeValueAsString(loadBalancer.choose("service-producer").getUri().toString());
        } catch (JsonProcessingException e) {
            return "解析错误";
        }
    }

}
