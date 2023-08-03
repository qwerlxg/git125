package org.ycframework.annotation;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YcBean {
    String[] value() default {}; //修改在spring容器的id名
    String[] name() default {};
}
