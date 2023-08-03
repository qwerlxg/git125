package com.yc.springtest4;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Configuration
@ComponentScan
@PropertySource("db.properties") //用于指定外部属性文件的位置，并将其加载到Spring环境中供应用程序使用。
public class Config {

}
