package com.yc.springtest3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.yc.springtest3.system","com.yc.springtest3.user"})
public class Config {
}
