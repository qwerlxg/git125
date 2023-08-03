package org.ycframework.annotation;

import org.springframework.context.annotation.ComponentScans;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface YcComponentScan {
    String[] basePackages() default {};
    String[] value() default {};
}
