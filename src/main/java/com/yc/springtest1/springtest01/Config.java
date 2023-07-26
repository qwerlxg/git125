package com.yc.springtest1.springtest01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //用于声明一个类是配置类。配置类用于定义Spring容器的配置信息，其中包括Bean的定义、组件扫描、AOP配置、事务配置等。
@ComponentScan(basePackages={"com.yc.springtest1"}) //basePackages和value用法一样，取决个人兴趣

public class Config {

}
