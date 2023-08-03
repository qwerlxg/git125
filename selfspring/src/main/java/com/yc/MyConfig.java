package com.yc;

import org.ycframework.annotation.YcComponentScan;
import org.ycframework.annotation.YcConfiguration;
import org.ycframework.annotation.YcPropertySource;

@YcConfiguration
@YcComponentScan(value = {"com.yc","com.yc1"})
@YcPropertySource(value = "db.properties")
public class MyConfig {

}
