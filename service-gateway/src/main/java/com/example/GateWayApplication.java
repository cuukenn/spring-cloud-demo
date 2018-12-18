package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

/**
 * @program: clouddemo
 * @author: changgg
 * @create: 2018-12-18 14:06
 **/
@SpringBootApplication
public class GateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }

    public RouteLocator myRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p ->
                        p.path("/hello")
                                .filters(f -> f.addRequestHeader("name", "cgg"))
                                .uri("https://www.baidu.com"))
                .route(p ->
                        p.host("*.hystrict.com")
                                .filters(f ->
                                        f.hystrix(config -> config.setName("test")
                                                .setFallbackUri("www.hao123.com")))
                                .uri("www.baidu.com"))
                .build();
    }
}
