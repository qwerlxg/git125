package org.ycframework.context;

/**
 *对bean的特征包装的类
 * 特征：scope（singlton/prototype）
 *      lazy（true/false）
 *      primary: 主实例   优先实例  UserDao接口：两个类（加primary拿）
 *                                业务层：@Autowired+@Qualifier
 *                                       @Autowired+@Primary
 */
public class YcBeanDefinition {
    private boolean isLazy;
    private String scope="singleton";
    private boolean isPrimary;

    private String classInfo;  //类的实例信息

    public boolean isLazy() {
        return isLazy;
    }

    public void setLazy(boolean lazy) {
        isLazy = lazy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public String getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(String classInfo) {
        this.classInfo = classInfo;
    }
}
