package com.iiit.action.springboot.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:*dubbo*.xml"})
@ComponentScan(basePackages = "com.iiit.action.dubbo.trace")
public class DubboConfig {

}
