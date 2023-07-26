package com.yc.springtest4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource(value = "db.properties") //用于指定外部属性文件的位置，并将其加载到Spring环境中供应用程序使用。
public class Config {
}
