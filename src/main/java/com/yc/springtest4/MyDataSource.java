package com.yc.springtest4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;

@Component
public class MyDataSource implements DataSource {
    private ConcurrentLinkedQueue<MyConnection> pool;

    //配置后注入 结合属性文本完成注入
    //从属性文本中取
    @Value("${coreSize}")  //来注入属性文本中的值到相应的变量中。
    private int coreSize;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;


    public  MyDataSource(){
        System.out.println("MyDataSource的构造方法");
    }

    @PostConstruct //这个方法在构造方法后执行======》》初始化连接池
    public void init() throws SQLException {
        System.out.println("MyDataSource的init 初始化");
        pool=new ConcurrentLinkedQueue<>();
        for (int i =0;i<coreSize;i++){
            MyConnection mc = new MyConnection();
            mc.statue=false;
            mc.con = DriverManager.getConnection(url,user,password);
            pool.add(mc);
            //System.out.println(pool+"123");
        }
    }

    class MyConnection{
        Connection con;
        boolean statue;  //ture在使用   false为使用
    }

    @Override
    public Connection getConnection() throws SQLException {
        do {
            MyConnection mc = this.pool.poll();
            if (mc == null){
                return null;
            }
            if (!mc.statue){
                return mc.con;
            }
        }while (true);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
