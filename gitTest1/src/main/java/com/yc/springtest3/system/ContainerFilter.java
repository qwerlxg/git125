package com.yc.springtest3.system;

/**
 * 容器过滤接口
 */
public interface ContainerFilter {

    /**
     * 判断此对象是否为有效对象
     * @return
     */
    public boolean doFilter(Object obj);
}
