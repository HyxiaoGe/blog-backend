package com.hyxiao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Hyxiao
 * @date 12/08/2023 00:59
 * @description
 */
@EnableDiscoveryClient    // 开启服务注册与发现功能
@SpringBootApplication
public class BlogServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }
}