package com.hyxiao;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 跨域配置类
 */
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {

        //  1.添加cors配置相关信息
        CorsConfiguration config = new CorsConfiguration();
        // 允许所有的域名进行跨域调用
        config.addAllowedOriginPattern("*");
        //  设置是否发送cookie信息
        config.setAllowCredentials(true);
        //  设置允许请求的方式
        config.addAllowedMethod("*");
        //  设置允许的header
        config.addAllowedHeader("*");

        //  2.为url添加映射的路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        //  3.返回重新定义好的资源
        return new CorsWebFilter(source);
    }

}
